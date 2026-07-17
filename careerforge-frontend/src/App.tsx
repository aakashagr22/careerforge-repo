import { Toaster } from 'react-hot-toast';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { ThemeProvider } from './contexts/ThemeContext';
import { AppRoutes } from './routes/AppRoutes';

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      retry: 1,
    },
  },
});

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <ThemeProvider>
        <Toaster
          position="top-right"
          toastOptions={{
            className: 'dark:bg-zinc-900 dark:text-white border dark:border-zinc-800 text-sm font-medium rounded-xl shadow-lg',
            duration: 4000,
            style: {
              borderRadius: '12px',
            }
          }}
        />
        <AppRoutes />
      </ThemeProvider>
    </QueryClientProvider>
  );
}

export default App;
