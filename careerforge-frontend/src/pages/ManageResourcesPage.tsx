import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm, Controller } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { resourceFolderService } from '../services/resourceFolderService';
import { Breadcrumbs } from '../components/Breadcrumbs';
import { FolderCard } from '../components/FolderCard';
import { ResourceCard } from '../components/ResourceCard';
import { YouTubePlayerModal } from '../components/YouTubePlayerModal';
import { Card, CardContent } from '../components/Card';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
import { 
  Library, Plus, FolderPlus, X, Loader2, Save, FolderOpen 
} from 'lucide-react';
import { ResourceFolder, StudyResource } from '../types/resources';

const resourceSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().max(250).optional().or(zod.literal('')),
  url: zod.string().min(1, 'URL is required').url('Must be a valid URL'),
  type: zod.enum(['VIDEO', 'ARTICLE']),
  durationMinutes: zod.number().min(1, 'Est duration must be positive').optional(),
});

type ResourceFormValues = zod.infer<typeof resourceSchema>;

export const ManageResourcesPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [activeFolderId, setActiveFolderId] = useState<string | null>(null);
  const [page, setPage] = useState(0);
  const [type, setType] = useState<'ALL' | 'VIDEO' | 'ARTICLE'>('ALL');
  const [activeVideo, setActiveVideo] = useState<{ title: string; url: string } | null>(null);
  const size = 9; // Paginated files count

  // Modal States
  const [isFolderModalOpen, setIsFolderModalOpen] = useState(false);
  const [editingFolder, setEditingFolder] = useState<ResourceFolder | null>(null);
  const [folderName, setFolderName] = useState('');

  const [isResourceModalOpen, setIsResourceModalOpen] = useState(false);
  const [editingResource, setEditingResource] = useState<StudyResource | null>(null);

  // Fetch Directory (folders + paginated resources)
  const { data: directoryData, isLoading: loadingDirectory } = useQuery({
    queryKey: ['adminDirectory', activeFolderId, page, size, type],
    queryFn: () => resourceFolderService.getDirectory(true, activeFolderId, page, size, type),
    staleTime: 5 * 60 * 1000,
  });

  const { register, handleSubmit, control, reset, setValue, formState: { errors } } = useForm<ResourceFormValues>({
    resolver: zodResolver(resourceSchema),
    defaultValues: {
      title: '',
      description: '',
      url: '',
      type: 'VIDEO',
      durationMinutes: 15,
    }
  });

  // Mutate: Folder Actions
  const folderCreateMutation = useMutation({
    mutationFn: resourceFolderService.createFolder,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      setIsFolderModalOpen(false);
      setFolderName('');
      toast.success('Folder created successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to create folder.');
    }
  });

  const folderUpdateMutation = useMutation({
    mutationFn: ({ id, data }: { id: string; data: { name: string; parentId?: string } }) =>
      resourceFolderService.updateFolder(id, data),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      setEditingFolder(null);
      setFolderName('');
      toast.success('Folder renamed successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to rename folder.');
    }
  });

  const folderDeleteMutation = useMutation({
    mutationFn: resourceFolderService.deleteFolder,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      toast.success('Folder deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete folder.');
    }
  });

  // Mutate: Resource Actions
  const resourceCreateMutation = useMutation({
    mutationFn: adminService.createResource,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      setIsResourceModalOpen(false);
      reset();
      toast.success('Resource published successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to publish resource.');
    }
  });

  const resourceUpdateMutation = useMutation({
    mutationFn: ({ id, data }: { id: string; data: any }) =>
      adminService.updateResource(id, data),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      setEditingResource(null);
      setIsResourceModalOpen(false);
      reset();
      toast.success('Resource updated successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to update resource.');
    }
  });

  const resourceDeleteMutation = useMutation({
    mutationFn: adminService.deleteResource,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['resourceDirectory'] });
      queryClient.invalidateQueries({ queryKey: ['globalSearchResources'] });
      toast.success('Resource deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete resource.');
    }
  });

  const handleFolderSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!folderName.trim()) return;

    if (editingFolder) {
      folderUpdateMutation.mutate({
        id: editingFolder.id,
        data: { name: folderName.trim(), parentId: editingFolder.parentId }
      });
    } else {
      folderCreateMutation.mutate({
        name: folderName.trim(),
        parentId: activeFolderId || undefined
      });
    }
  };

  const handleResourceSubmit = (values: ResourceFormValues) => {
    const payload = {
      ...values,
      folderId: activeFolderId || undefined
    };

    if (editingResource) {
      resourceUpdateMutation.mutate({
        id: editingResource.id,
        data: payload
      });
    } else {
      resourceCreateMutation.mutate(payload);
    }
  };

  const handleRenameFolderClick = (folder: ResourceFolder) => {
    setEditingFolder(folder);
    setFolderName(folder.name);
  };

  const handleDeleteFolderClick = (id: string) => {
    if (window.confirm('Are you sure you want to delete this folder? The folder must be completely empty.')) {
      folderDeleteMutation.mutate(id);
    }
  };

  const handleEditResourceClick = (res: StudyResource) => {
    setEditingResource(res);
    setValue('title', res.title);
    setValue('description', res.description);
    setValue('url', res.url);
    setValue('type', res.type);
    setValue('durationMinutes', res.durationMinutes || 15);
    setIsResourceModalOpen(true);
  };

  const handleDeleteResourceClick = (id: string) => {
    if (window.confirm('Are you sure you want to delete this resource?')) {
      resourceDeleteMutation.mutate(id);
    }
  };

  const openCreateResourceModal = () => {
    setEditingResource(null);
    reset({
      title: '',
      description: '',
      url: '',
      type: 'VIDEO',
      durationMinutes: 15,
    });
    setIsResourceModalOpen(true);
  };

  const childFolders = directoryData?.childFolders || [];
  const resources = directoryData?.resources?.content || [];
  const totalPages = directoryData?.resources?.totalPages || 0;
  const totalElements = directoryData?.resources?.totalElements || 0;

  const hasContent = childFolders.length > 0 || resources.length > 0;

  return (
    <div className="space-y-8 max-w-6xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-2">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2">
            <Library className="h-7 w-7 text-rose-650" /> Manage Study Materials
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Publish educational videos/articles or organize directories inside the study library.
          </p>
        </div>

        {/* Directory action triggers */}
        <div className="flex gap-3 shrink-0">
          <button
            onClick={() => { setEditingFolder(null); setFolderName(''); setIsFolderModalOpen(true); }}
            className="inline-flex items-center gap-1.5 bg-slate-100 hover:bg-slate-200 dark:bg-zinc-800 dark:hover:bg-zinc-700 text-slate-700 dark:text-slate-200 px-4 py-2.5 rounded-xl font-bold text-xs transition-colors shadow-sm"
          >
            <FolderPlus className="h-4 w-4 text-amber-500" /> Create Folder
          </button>
          <button
            onClick={openCreateResourceModal}
            className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-bold text-xs transition-colors shadow-sm"
          >
            <Plus className="h-4 w-4" /> Publish Resource
          </button>
        </div>
      </div>

      {/* ==================== BREADCRUMB NAV ==================== */}
      {!loadingDirectory && (
        <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4">
          <Breadcrumbs
            breadcrumbs={directoryData?.breadcrumbs || []}
            onNavigate={(id) => { setActiveFolderId(id); setPage(0); }}
          />

          {/* Format selection filter */}
          <div className="flex items-center gap-1.5 bg-slate-100 dark:bg-zinc-800/40 p-1.5 rounded-xl border border-slate-200/40 dark:border-dark-border/10 shrink-0">
            {([
              { id: 'ALL', name: 'All Formats' },
              { id: 'VIDEO', name: 'Videos' },
              { id: 'ARTICLE', name: 'Articles' }
            ] as const).map((format) => (
              <button
                key={format.id}
                onClick={() => { setType(format.id); setPage(0); }}
                className={`px-3.5 py-1.5 text-[10px] font-bold rounded-lg uppercase tracking-wider transition-all ${
                  type === format.id
                    ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                    : 'text-slate-500 hover:text-slate-700 dark:hover:text-slate-350'
                }`}
              >
                {format.name}
              </button>
            ))}
          </div>
        </div>
      )}

      {/* ==================== DIRECTORY VIEW ==================== */}
      {loadingDirectory ? (
        <div className="flex flex-col items-center justify-center py-32 gap-3 text-slate-500 font-semibold text-xs">
          <Loader2 className="h-5 w-5 animate-spin text-rose-600" /> Syncing library assets...
        </div>
      ) : !hasContent ? (
        <div className="text-center py-20 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-3xl max-w-md mx-auto space-y-3">
          <FolderOpen className="h-10 w-10 text-slate-350 mx-auto" />
          <h3 className="text-sm font-bold text-slate-800 dark:text-white">This Folder is Empty</h3>
          <p className="text-xs text-slate-500">
            Publish your first resource or add a subfolder at this directory level using the actions above.
          </p>
        </div>
      ) : (
        <div className="space-y-8">
          {/* Subfolders list */}
          {childFolders.length > 0 && (
            <div className="space-y-3">
              <h2 className="text-[10px] font-extrabold text-slate-450 uppercase tracking-wider">Subfolders</h2>
              <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-5">
                {childFolders.map((folder) => (
                  <FolderCard
                    key={folder.id}
                    folder={folder}
                    isAdmin={true}
                    onClick={(id) => { setActiveFolderId(id); setPage(0); }}
                    onRename={handleRenameFolderClick}
                    onDelete={handleDeleteFolderClick}
                  />
                ))}
              </div>
            </div>
          )}

          {/* Resources list */}
          {resources.length > 0 && (
            <div className="space-y-3">
              <h2 className="text-[10px] font-extrabold text-slate-450 uppercase tracking-wider">Resources</h2>
              <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {resources.map((res) => (
                  <ResourceCard
                    key={res.id}
                    resource={res}
                    isAdmin={true}
                    onPlayVideo={(title, url) => setActiveVideo({ title, url })}
                    onEdit={handleEditResourceClick}
                    onDelete={handleDeleteResourceClick}
                  />
                ))}
              </div>
            </div>
          )}
        </div>
      )}

      {/* ==================== PAGINATION BOTTOM ==================== */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-bold text-slate-450 pt-6 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>Showing page {page + 1} of {totalPages} ({totalElements} resources)</span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors"
            >
              Prev
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors"
            >
              Next
            </button>
          </div>
        </div>
      )}

      {/* ==================== CREATE/RENAME FOLDER MODAL ==================== */}
      {(isFolderModalOpen || editingFolder) && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-sm shadow-2xl">
            <form onSubmit={handleFolderSubmit} className="p-6 space-y-4">
              <div className="flex justify-between items-center">
                <h3 className="text-sm font-bold text-slate-900 dark:text-white">
                  {editingFolder ? 'Rename Folder' : 'Create Folder'}
                </h3>
                <button
                  type="button"
                  onClick={() => { setIsFolderModalOpen(false); setEditingFolder(null); }}
                  className="text-slate-400 hover:text-slate-600"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Folder Name
                </label>
                <input
                  type="text"
                  required
                  value={folderName}
                  onChange={(e) => setFolderName(e.target.value)}
                  placeholder="e.g. Dynamic Programming"
                  className="w-full px-3.5 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800 text-xs font-semibold focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-850 dark:text-slate-100"
                />
              </div>

              <div className="flex justify-end gap-3 pt-2">
                <button
                  type="button"
                  onClick={() => { setIsFolderModalOpen(false); setEditingFolder(null); }}
                  className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-300 dark:hover:text-white"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  disabled={folderCreateMutation.isPending || folderUpdateMutation.isPending}
                  className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-xs font-semibold disabled:opacity-75"
                >
                  {folderCreateMutation.isPending || folderUpdateMutation.isPending ? (
                    <Loader2 className="h-3.5 w-3.5 animate-spin" />
                  ) : (
                    <Save className="h-3.5 w-3.5" />
                  )}
                  Save Folder
                </button>
              </div>
            </form>
          </Card>
        </div>
      )}

      {/* ==================== CREATE/EDIT RESOURCE MODAL ==================== */}
      {isResourceModalOpen && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-md shadow-2xl">
            <form onSubmit={handleSubmit(handleResourceSubmit)} className="p-6 space-y-4">
              <div className="flex justify-between items-center">
                <h3 className="text-sm font-bold text-slate-900 dark:text-white">
                  {editingResource ? 'Edit Resource' : 'Publish Resource'}
                </h3>
                <button
                  type="button"
                  onClick={() => setIsResourceModalOpen(false)}
                  className="text-slate-400 hover:text-slate-600"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              <Input
                label="Resource Title"
                placeholder="e.g., Intro to Graphs"
                error={errors.title?.message}
                {...register('title')}
              />

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Description
                </label>
                <textarea
                  placeholder="Summarize content..."
                  {...register('description')}
                  className={`w-full px-4 py-2 rounded-xl border bg-slate-50/50 dark:bg-zinc-800 text-xs font-semibold transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 resize-none h-16 ${
                    errors.description ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
                  }`}
                />
                {errors.description && (
                  <p className="text-xs text-red-500">{errors.description.message}</p>
                )}
              </div>

              <Input
                label="Redirect URL"
                placeholder="e.g., https://youtube.com/..."
                error={errors.url?.message}
                {...register('url')}
              />
              <div className="grid grid-cols-2 gap-4">
                <Controller
                  control={control}
                  name="type"
                  render={({ field }) => (
                    <Select
                      label="Format"
                      options={[
                        { value: 'VIDEO', label: 'Video' },
                        { value: 'ARTICLE', label: 'Article' }
                      ]}
                      value={field.value}
                      onChange={field.onChange}
                      className="w-full text-left"
                    />
                  )}
                />

                <Input
                  label="Est. Duration (Min)"
                  type="number"
                  error={errors.durationMinutes?.message}
                  {...register('durationMinutes', { valueAsNumber: true })}
                />
              </div>

              <div className="flex justify-end gap-3 pt-2">
                <button
                  type="button"
                  onClick={() => setIsResourceModalOpen(false)}
                  className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-300 dark:hover:text-white"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  disabled={resourceCreateMutation.isPending || resourceUpdateMutation.isPending}
                  className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-xs font-semibold disabled:opacity-75"
                >
                  {resourceCreateMutation.isPending || resourceUpdateMutation.isPending ? (
                    <Loader2 className="h-3.5 w-3.5 animate-spin" />
                  ) : (
                    <Save className="h-3.5 w-3.5" />
                  )}
                  Save Resource
                </button>
              </div>
            </form>
          </Card>
        </div>
      )}

      {/* ==================== VIDEO PLAYER MODAL ==================== */}
      {activeVideo && (
        <YouTubePlayerModal
          title={activeVideo.title}
          url={activeVideo.url}
          onClose={() => setActiveVideo(null)}
        />
      )}

    </div>
  );
};

export default ManageResourcesPage;
