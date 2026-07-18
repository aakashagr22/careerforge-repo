import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { DataTable, Column } from '../components/DataTable';
import { Badge } from '../components/Badge';
import { Users, Trash2 } from 'lucide-react';

interface StudentProfileRow {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  branch: string;
  semester: number;
  targetRole: string;
  streak: number;
}

export const ManageStudentsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [page, setPage] = useState(0);
  const size = 10;

  // Fetch paginated student profiles
  const { data, isLoading } = useQuery({
    queryKey: ['adminStudents', page],
    queryFn: () => adminService.getAllStudents(page, size),
  });

  // Delete student profile mutation
  const deleteStudentMutation = useMutation({
    mutationFn: adminService.deleteStudent,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminStudents'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      toast.success('Student profile deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete student.');
    }
  });

  const handleDelete = (id: string) => {
    if (window.confirm('Are you sure you want to delete this student profile? This action is permanent and deletes all progress logs.')) {
      deleteStudentMutation.mutate(id);
    }
  };

  // Define DataTable columns
  const columns: Column<StudentProfileRow>[] = [
    {
      header: 'Name',
      render: (row) => (
        <span className="font-semibold text-slate-800 dark:text-slate-200">
          {row.firstName} {row.lastName}
        </span>
      ),
    },
    {
      header: 'Email',
      key: 'email',
    },
    {
      header: 'Branch',
      render: (row) => (
        <span className="text-xs font-semibold text-slate-750 dark:text-zinc-300">
          {row.branch || 'N/A'}
        </span>
      ),
    },
    {
      header: 'Semester',
      render: (row) => (
        <span className="text-xs font-semibold px-2 py-0.5 rounded bg-slate-100 dark:bg-zinc-800 text-slate-700 dark:text-zinc-300">
          Sem {row.semester || 'N/A'}
        </span>
      ),
    },
    {
      header: 'Target Role',
      render: (row) => (
        row.targetRole ? <Badge variant="brand">{row.targetRole}</Badge> : <span className="text-slate-400 text-xs">Not Configured</span>
      ),
    },
    {
      header: 'Streak',
      render: (row) => (
        <div className="flex items-center gap-1 text-amber-500 font-bold text-xs">
          <span>{row.streak || 0} 🔥</span>
        </div>
      ),
    },
    {
      header: 'Actions',
      render: (row) => (
        <button
          onClick={() => handleDelete(row.id)}
          className="text-red-500 hover:text-red-700 p-1.5 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-lg transition-colors shrink-0"
          title="Delete Student"
        >
          <Trash2 className="h-4.5 w-4.5" />
        </button>
      ),
    },
  ];

  const students = data?.content || [];
  const totalElements = data?.totalElements || 0;

  return (
    <div className="space-y-6">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Users className="h-7 w-7 text-rose-650" /> Student Directory
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Query platform user statistics, check target selections, or delete profiles.
        </p>
      </div>

      {/* ==================== DATA TABLE ==================== */}
      <DataTable
        columns={columns}
        data={students}
        loading={isLoading}
        page={page}
        size={size}
        totalElements={totalElements}
        onPageChange={setPage}
        emptyMessage="No students registered on CareerForge yet."
      />

    </div>
  );
};
export default ManageStudentsPage;
