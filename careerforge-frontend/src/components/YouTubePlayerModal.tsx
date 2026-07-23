import React, { useState } from 'react';
import { X, ListVideo } from 'lucide-react';

export const YoutubeIcon: React.FC<React.SVGProps<SVGSVGElement>> = (props) => (
  <svg
    viewBox="0 0 24 24"
    fill="currentColor"
    {...props}
  >
    <path d="M23.498 6.163a3.003 3.003 0 0 0-2.11-2.107C19.505 3.545 12 3.545 12 3.545s-7.505 0-9.388.511a3.002 3.002 0 0 0-2.11 2.107C0 8.048 0 12 0 12s0 3.952.502 5.837a3.002 3.002 0 0 0 2.11 2.107c1.883.511 9.388.511 9.388.511s7.505 0 9.388-.511a3.003 3.003 0 0 0 2.11-2.107C24 15.952 24 12 24 12s0-3.952-.502-5.837zM9.545 15.568V8.432L15.818 12l-6.273 3.568z" />
  </svg>
);

interface YouTubePlayerModalProps {
  title: string;
  url: string;
  onClose: () => void;
}

export interface ParsedYouTubeUrl {
  videoId: string;
  playlistId: string;
  startQuery: string;
  embedUrl: string;
  thumbnailUrl: string;
  isPlaylist: boolean;
}

export const parseYoutubeUrl = (videoUrl: string): ParsedYouTubeUrl => {
  if (!videoUrl) {
    return { videoId: '', playlistId: '', startQuery: '', embedUrl: '', thumbnailUrl: '', isPlaylist: false };
  }

  let videoId = '';
  let playlistId = '';
  let startQuery = '';

  // Extract playlist ID
  const playlistMatch = videoUrl.match(/[?&]list=([^#&]+)/);
  if (playlistMatch && playlistMatch[1]) {
    playlistId = playlistMatch[1];
  }

  // Extract video ID
  const videoMatch = videoUrl.match(/(?:youtu\.be\/|v\/|u\/\w\/|embed\/|watch\?v=|&v=)([^#&?]*)/);
  if (videoMatch && videoMatch[1] && videoMatch[1].length === 11) {
    videoId = videoMatch[1];
  }

  // Extract timestamp
  const timeMatch = videoUrl.match(/[?&](t|start)=([0-9hms]+)/);
  if (timeMatch) {
    const rawTime = timeMatch[2];
    let seconds = 0;
    const hoursMatch = rawTime.match(/([0-9]+)h/);
    const minsMatch = rawTime.match(/([0-9]+)m/);

    if (hoursMatch) seconds += parseInt(hoursMatch[1], 10) * 3600;
    if (minsMatch) seconds += parseInt(minsMatch[1], 10) * 60;

    if (!hoursMatch && !minsMatch && rawTime.match(/^[0-9]+$/)) {
      seconds = parseInt(rawTime, 10);
    } else {
      const cleanSecs = rawTime.replace(/[^0-9]/g, '');
      if (cleanSecs) seconds = parseInt(cleanSecs, 10);
    }

    if (seconds > 0) {
      startQuery = `&start=${seconds}`;
    }
  }

  const isPlaylist = Boolean(playlistId);
  let embedUrl = '';
  let thumbnailUrl = '';

  if (isPlaylist && videoId) {
    // Both specific video and playlist series
    embedUrl = `https://www.youtube-nocookie.com/embed/${videoId}?list=${playlistId}&autoplay=1&rel=0${startQuery}`;
    thumbnailUrl = `https://i.ytimg.com/vi/${videoId}/hqdefault.jpg`;
  } else if (isPlaylist) {
    // Pure playlist (no single video ID specified)
    embedUrl = `https://www.youtube-nocookie.com/embed/videoseries?list=${playlistId}&autoplay=1&rel=0`;
    thumbnailUrl = ''; // Uses stylish playlist facade
  } else if (videoId) {
    // Single video
    embedUrl = `https://www.youtube-nocookie.com/embed/${videoId}?autoplay=1&rel=0${startQuery}`;
    thumbnailUrl = `https://i.ytimg.com/vi/${videoId}/hqdefault.jpg`;
  } else {
    embedUrl = videoUrl;
  }

  return { videoId, playlistId, startQuery, embedUrl, thumbnailUrl, isPlaylist };
};

export const YouTubePlayerModal: React.FC<YouTubePlayerModalProps> = ({ title, url, onClose }) => {
  const [loaded, setLoaded] = useState(false);
  const parsed = parseYoutubeUrl(url);

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/80 backdrop-blur-sm p-4 md:p-6">
      <div className="relative w-full max-w-3xl bg-slate-900 border border-slate-800 rounded-3xl overflow-hidden shadow-2xl flex flex-col p-3 md:p-4">
        {/* Header */}
        <div className="flex items-center justify-between pb-3 px-1.5 bg-slate-900 border-b border-slate-800/60 mb-2">
          <div className="flex items-center gap-2.5 text-slate-200">
            <YoutubeIcon className="h-5 w-5 text-red-500 fill-red-500 shrink-0" />
            <div className="flex items-center gap-2 overflow-hidden">
              <span className="font-semibold text-xs md:text-sm truncate max-w-[200px] md:max-w-md">
                {title}
              </span>
              {parsed.isPlaylist && (
                <span className="px-2 py-0.5 rounded-full text-[10px] font-extrabold uppercase bg-red-500/20 text-red-400 border border-red-500/30 flex items-center gap-1 shrink-0">
                  <ListVideo className="h-3 w-3" /> Playlist
                </span>
              )}
            </div>
          </div>
          <button
            onClick={onClose}
            className="text-slate-400 hover:text-white p-1 rounded-xl hover:bg-slate-800 transition-colors"
          >
            <X className="h-5 w-5" />
          </button>
        </div>

        {/* Facade pattern container */}
        <div className="relative w-full aspect-video bg-black rounded-2xl overflow-hidden">
          {loaded ? (
            <iframe
              src={parsed.embedUrl}
              title={title}
              className="absolute inset-0 w-full h-full border-0 rounded-2xl"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowFullScreen
            />
          ) : (
            <button
              onClick={() => setLoaded(true)}
              className="group absolute inset-0 w-full h-full flex items-center justify-center bg-slate-950"
              aria-label={`Play video: ${title}`}
            >
              {parsed.thumbnailUrl ? (
                <img
                  src={parsed.thumbnailUrl}
                  alt={title}
                  loading="lazy"
                  className="w-full h-full object-cover rounded-2xl"
                />
              ) : (
                <div className="w-full h-full bg-gradient-to-br from-slate-900 via-zinc-900 to-black flex flex-col items-center justify-center p-6 text-center">
                  <div className="h-16 w-16 rounded-full bg-red-600/20 border border-red-500/30 flex items-center justify-center mb-3 group-hover:scale-110 transition-transform">
                    <ListVideo className="h-8 w-8 text-red-500" />
                  </div>
                  <span className="text-sm font-bold text-slate-200 mb-1">
                    YouTube Playlist Series
                  </span>
                  <span className="text-xs text-slate-400 max-w-sm">
                    Click to load full video playlist player
                  </span>
                </div>
              )}
              <span className="absolute inset-0 flex items-center justify-center bg-black/20 transition-all duration-300 group-hover:bg-black/35">
                <div className="relative h-16 w-20 flex items-center justify-center rounded-2xl bg-black/40 group-hover:bg-red-600 transition-colors duration-300 shadow-xl border border-white/5">
                  <YoutubeIcon className="h-9 w-9 text-white fill-white" />
                </div>
              </span>
            </button>
          )}
        </div>
      </div>
    </div>
  );
};
