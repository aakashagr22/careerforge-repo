import React from 'react';
import { AdminChatConsole } from '../components/AdminChatConsole';

export const AdminChatPage: React.FC = () => {
  return (
    <div className="p-2 md:p-4 max-w-7xl mx-auto">
      <AdminChatConsole />
    </div>
  );
};
