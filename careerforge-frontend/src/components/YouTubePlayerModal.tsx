import React, { useState } from 'react';
import { X } from 'lucide-react';

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

export const YouTubePlayerModal: React.FC<YouTubePlayerModalProps> = ({ title, url, onClose }) => {
  const [loaded, setLoaded] = useState(false);

  // Extracts YouTube video ID and start time from standard and short YouTube URLs
  const parseYoutubeUrl = (videoUrl: string): { videoId: string; startQuery: string } => {
    if (!videoUrl) return { videoId: '', startQuery: '' };
    let videoId = '';
    let startQuery = '';
    
    const regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
    const match = videoUrl.match(regExp);
    
    if (match && match[2].length === 11) {
      videoId = match[2];
    } else {
      return { videoId: videoUrl, startQuery: '' };
    }
    
    const timeMatch = videoUrl.match(/[\?&](t|start)=([0-9hms]+)/);
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
        if (cleanSecs) {
          seconds = parseInt(cleanSecs, 10);
        }
      }
      
      if (seconds > 0) {
        startQuery = `&start=${seconds}`;
      }
    }
    
    return { videoId, startQuery };
  };

  const { videoId, startQuery } = parseYoutubeUrl(url);
  const embedUrl = `https://www.youtube-nocookie.com/embed/${videoId}?autoplay=1&rel=0${startQuery}`;

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/80 backdrop-blur-sm p-4 md:p-6">
      <div className="relative w-full max-w-3xl bg-slate-900 border border-slate-800 rounded-3xl overflow-hidden shadow-2xl flex flex-col p-3 md:p-4">
        {/* Header */}
        <div className="flex items-center justify-between pb-3 px-1.5 bg-slate-900 border-b border-slate-800/60 mb-2">
          <div className="flex items-center gap-2.5 text-slate-200">
            <YoutubeIcon className="h-5 w-5 text-red-500 fill-red-500" />
            <span className="font-semibold text-xs md:text-sm truncate max-w-[200px] md:max-w-lg">
              {title}
            </span>
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
              src={embedUrl}
              title={title}
              className="absolute inset-0 w-full h-full border-0 rounded-2xl"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowFullScreen
            />
          ) : (
            <button
              onClick={() => setLoaded(true)}
              className="group absolute inset-0 w-full h-full flex items-center justify-center"
              aria-label={`Play video: ${title}`}
            >
              <img
                src={`https://i.ytimg.com/vi/${videoId}/hqdefault.jpg`}
                alt={title}
                loading="lazy"
                className="w-full h-full object-cover rounded-2xl"
              />
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
