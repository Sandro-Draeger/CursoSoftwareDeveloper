@extends('layouts.fe_master')
@section('content')
<div class="container mt-4">

    {{-- Card: Dados da Task --}}
    <div class="card mb-4 shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Dados da Task</h5>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6 mb-2">
                    <strong>Nome:</strong> {{ $task->name }}
                </div>
                <div class="col-md-6 mb-2">
                    <strong>Status:</strong>
                    <span class="badge {{ $task->status ? 'bg-success' : 'bg-warning text-dark' }}">
                        {{ $task->status ? 'Feito' : 'A Fazer' }}
                    </span>
                </div>
                <div class="col-12 mb-2">
                    <strong>Descrição:</strong> {{ $task->description }}
                </div>
                <div class="col-md-6 mb-2">
                    <strong>Responsável:</strong>
                    {{ $task->user_id}}
                </div>
            </div>
        </div>
    </div>

    {{-- Card: Editar Task --}}
    <div class="card shadow-sm">
        <div class="card-header">
            <h5 class="mb-0">Editar Task</h5>
        </div>
        <div class="card-body">
            <form method="POST" action="{{ route('tasks.update') }}">
                @csrf
                @method('PUT')

                <input type="hidden" name="id" value="{{ $task->id }}">

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nome</label>
                        <input
                            type="text"
                            name="name"
                            value="{{ old('name', $task->name) }}"
                            class="form-control @error('name') is-invalid @enderror"
                        >
                        @error('name')
                            <div class="invalid-feedback">Erro de nome</div>
                        @enderror
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">Status</label>
                        <select
                            name="status"
                            class="form-select"
                        >
                            <option value="0" {{ old('status', $task->status) == 0 ? 'selected' : '' }}>
                                A Fazer
                            </option>
                            <option value="1" {{ old('status', $task->status) == 1 ? 'selected' : '' }}>
                                Feito
                            </option>
                        </select>
                    </div>

                    <div class="col-12 mb-3">
                        <label class="form-label">Descrição</label>
                        <input
                            type="text"
                            name="description"
                            value="{{ old('description', $task->description) }}"
                            class="form-control @error('description') is-invalid @enderror"
                        >
                        @error('description')
                            <div class="invalid-feedback">Erro de descrição</div>
                        @enderror
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">Responsável</label>
                        <select
                            name="user_id"
                            class="form-select"
                        >
                            <option value="">Selecione um</option>
                            @foreach ($users as $user)
                                <option
                                    value="{{ $user->id }}"
                                    {{ old('user_id', $task->user_id) == $user->id ? 'selected' : '' }}
                                >
                                    {{ $user->name }}
                                </option>
                            @endforeach
                        </select>
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success">
                        💾 Guardar Alterações
                    </button>
                </div>
            </form>
        </div>
    </div>

</div>
@endsection
