@extends('layouts.fe_master')
@section('content')
<div class="container mt-4">

    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Tasks</h5>
            <a href="{{ route('tasks.add') }}" class="btn btn-green btn-sm">➕ Adicionar Task</a>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Status</th>
                            <th>Responsável</th>
                            <th>Atualizado em</th>
                            <th class="text-end">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        @forelse ($tasksFromDB as $task)
                            <tr>
                                <td>{{ $task->id }}</td>
                                <td>{{ $task->name }}</td>
                                <td class="text-truncate" style="max-width: 250px;">
                                    {{ $task->description }}
                                </td>
                                <td>
                                    <span class="badge {{ $task->status ? 'bg-success' : 'bg-warning text-dark' }}">
                                        {{ $task->status ? 'Feito' : 'A Fazer' }}
                                    </span>
                                </td>
                                <td>{{ $task->username ?? '—' }}</td>
                                <td>{{ $task->updated_at}}</td>
                                <td class="text-end">
                                    <a href="{{ route('tasks.view', $task->id) }}"
                                       class="btn btn-sm btn-info">
                                        ✏️ Ver / Editar
                                    </a>
                                    <a href="{{ route('tasks.delete', $task->id) }}"
                                       class="btn btn-sm btn-danger"
                                       onclick="return confirm('Tem a certeza que deseja apagar esta task?')">
                                        🗑️ Apagar
                                    </a>
                                </td>
                            </tr>
                        @empty
                            <tr>
                                <td colspan="7" class="text-center text-muted">
                                    Nenhuma task encontrada.
                                </td>
                            </tr>
                        @endforelse
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
@endsection

