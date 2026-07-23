import React from 'react';
import { ChatRoom } from '../types/chat';
import { RoomCard } from './RoomCard';

interface RoomListProps {
  rooms: ChatRoom[];
  selectedRoomId: string | null;
  onSelectRoom: (roomId: string) => void;
}

export const RoomList: React.FC<RoomListProps> = ({
  rooms,
  selectedRoomId,
  onSelectRoom,
}) => {
  const yearRooms = rooms.filter((r) => r.roomType === 'YEAR_CHAT');
  const generalRooms = rooms.filter((r) => r.roomType === 'GENERAL_CHAT');
  const seniorRooms = rooms.filter((r) => r.roomType === 'SENIOR_CHAT');

  return (
    <div className="space-y-5 px-3 py-2">
      {/* Year Chats Section */}
      {yearRooms.length > 0 && (
        <div className="space-y-1">
          <h4 className="px-3 text-xs font-semibold uppercase tracking-wider text-slate-400 dark:text-slate-500">
            Year Chats
          </h4>
          {yearRooms.map((room) => (
            <RoomCard
              key={room.id}
              room={room}
              isSelected={selectedRoomId === room.id}
              onClick={() => onSelectRoom(room.id)}
            />
          ))}
        </div>
      )}

      {/* General Chat Section */}
      {generalRooms.length > 0 && (
        <div className="space-y-1">
          <h4 className="px-3 text-xs font-semibold uppercase tracking-wider text-slate-400 dark:text-slate-500">
            General
          </h4>
          {generalRooms.map((room) => (
            <RoomCard
              key={room.id}
              room={room}
              isSelected={selectedRoomId === room.id}
              onClick={() => onSelectRoom(room.id)}
            />
          ))}
        </div>
      )}

      {/* Senior Rooms Section */}
      {seniorRooms.length > 0 && (
        <div className="space-y-1">
          <h4 className="px-3 text-xs font-semibold uppercase tracking-wider text-slate-400 dark:text-slate-500">
            Senior Rooms
          </h4>
          {seniorRooms.map((room) => (
            <RoomCard
              key={room.id}
              room={room}
              isSelected={selectedRoomId === room.id}
              onClick={() => onSelectRoom(room.id)}
            />
          ))}
        </div>
      )}
    </div>
  );
};
