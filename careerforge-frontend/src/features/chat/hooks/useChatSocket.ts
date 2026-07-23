import { useEffect, useRef, useState, useCallback } from 'react';
import { Client, StompSubscription } from '@stomp/stompjs';
import { useAuthStore } from '../../../store/authStore';
import { ChatMessage, SendMessageRequest } from '../types/chat';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8082';

// Convert http://localhost:8082 -> ws://localhost:8082/ws/websocket for native STOMP over WebSocket
const getWsUrl = () => {
  const url = new URL(API_BASE_URL);
  const protocol = url.protocol === 'https:' ? 'wss:' : 'ws:';
  return `${protocol}//${url.host}/ws/websocket`;
};

interface UseChatSocketProps {
  roomId?: string | null;
  conversationId?: string | null;
  onMessageReceived?: (message: ChatMessage) => void;
}

export const useChatSocket = ({
  roomId,
  conversationId,
  onMessageReceived,
}: UseChatSocketProps) => {
  const { accessToken } = useAuthStore();
  const clientRef = useRef<Client | null>(null);
  const subscriptionRef = useRef<StompSubscription | null>(null);

  const [connected, setConnected] = useState(false);
  const [error, setError] = useState<string | null>(null);

  // Callback ref pattern to avoid re-subscribing on every callback instance change
  const onMessageReceivedRef = useRef(onMessageReceived);
  useEffect(() => {
    onMessageReceivedRef.current = onMessageReceived;
  }, [onMessageReceived]);

  useEffect(() => {
    if (!accessToken) return;

    const stompClient = new Client({
      brokerURL: getWsUrl(),
      connectHeaders: {
        Authorization: `Bearer ${accessToken}`,
      },
      debug: (msg) => {
        if (import.meta.env.DEV) {
          console.debug('[STOMP]', msg);
        }
      },
      reconnectDelay: 5000,
      heartbeatIncoming: 10000,
      heartbeatOutgoing: 10000,
    });

    stompClient.onConnect = () => {
      setConnected(true);
      setError(null);
    };

    stompClient.onStompError = (frame) => {
      console.error('[STOMP Error]', frame.headers['message'], frame.body);
      setError(frame.headers['message'] || 'WebSocket STOMP Connection Error');
    };

    stompClient.onWebSocketError = (event) => {
      console.error('[WebSocket Error]', event);
      setError('Failed to connect to real-time chat server');
    };

    stompClient.onDisconnect = () => {
      setConnected(false);
    };

    stompClient.activate();
    clientRef.current = stompClient;

    return () => {
      if (subscriptionRef.current) {
        subscriptionRef.current.unsubscribe();
        subscriptionRef.current = null;
      }
      stompClient.deactivate();
      setConnected(false);
    };
  }, [accessToken]);

  // Subscribe to active room or active conversation topic
  useEffect(() => {
    const client = clientRef.current;
    if (!connected || !client) return;

    // Unsubscribe previous active subscription
    if (subscriptionRef.current) {
      subscriptionRef.current.unsubscribe();
      subscriptionRef.current = null;
    }

    let topicDestination = '';
    if (roomId) {
      topicDestination = `/topic/chat/${roomId}`;
    } else if (conversationId) {
      topicDestination = `/topic/private/${conversationId}`;
    }

    if (!topicDestination) return;

    const subscription = client.subscribe(topicDestination, (message) => {
      try {
        const parsedMessage: ChatMessage = JSON.parse(message.body);
        if (onMessageReceivedRef.current) {
          onMessageReceivedRef.current(parsedMessage);
        }
      } catch (err) {
        console.error('Failed to parse incoming STOMP message payload:', err);
      }
    });

    subscriptionRef.current = subscription;

    return () => {
      if (subscription) {
        subscription.unsubscribe();
      }
    };
  }, [connected, roomId, conversationId]);

  // Send message over STOMP
  const sendMessage = useCallback(
    (request: SendMessageRequest) => {
      const client = clientRef.current;
      if (!client || !connected) {
        throw new Error('Real-time chat client is not connected');
      }

      let appDestination = '';
      if (request.chatRoomId) {
        appDestination = `/app/chat.room.${request.chatRoomId}`;
      } else if (request.conversationId) {
        appDestination = `/app/chat.private.${request.conversationId}`;
      }

      if (!appDestination) {
        throw new Error('Destination (chatRoomId or conversationId) must be specified');
      }

      client.publish({
        destination: appDestination,
        body: JSON.stringify(request),
        headers: {
          'content-type': 'application/json',
        },
      });
    },
    [connected]
  );

  return {
    connected,
    error,
    sendMessage,
  };
};
