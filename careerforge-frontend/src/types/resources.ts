export interface StudyResource {
  id: string;
  title: string;
  description: string;
  url: string;
  type: 'VIDEO' | 'ARTICLE';
  durationMinutes?: number;
  folderId?: string;
  createdBy?: string;
  createdAt?: string;
}

export interface ResourceFilters {
  query?: string;
  folderId?: string;
  type?: string;
  page: number;
  size: number;
}

export interface ResourceFolder {
  id: string;
  name: string;
  parentId?: string;
  createdAt: string;
  updatedAt: string;
}

export interface FolderBreadcrumb {
  id: string;
  name: string;
}

export interface FolderDirectory {
  currentFolder: ResourceFolder | null;
  breadcrumbs: FolderBreadcrumb[];
  childFolders: ResourceFolder[];
  resources: {
    content: StudyResource[];
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
  };
}
