@extends('layouts.fe_master')
@section('content')
<div class="container mt-4">

    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Adicionar Task</h5>
        </div>
        <div class="card-body">

            <h6 class="mb-4">Olá, aqui podes adicionar tasks!</h6>

            <form method="POST" action="{{ route('tasks.store') }}">
                @csrf

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nome</label>
                        <input
                            required
                            name="name"
                            type="text"
                            class="form-control @error('name') is-invalid @enderror"
                        >
                        @error('name')
                            <div class="invalid-feedback">Erro de nome</div>
                        @enderror
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">Descrição</label>
                        <input
                            required
                            name="description"
                            type="text"
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
                            class="form-select @error('user_id') is-invalid @enderror"
                            required
                        >
                            <option value="">Selecione um</option>
                            @foreach($users as $user)
                                <option value="{{ $user->id }}">{{ $user->name }}</option>
                            @endforeach
                        </select>
                        @error('user_id')
                            <div class="invalid-feedback">Erro de usuario</div>
                        @enderror
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success">
                        💾 Adicionar Task
                    </button>
                </div>
            </form>

        </div>
    </div>

</div>
@endsection
