@extends('layouts.fe_master')

@section('content')
<div class="container mt-4">

    {{-- Card: Dados do Utilizador --}}
    <div class="card mb-4 shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Dados do Utilizador</h5>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6 mb-2">
                    <strong>Nome:</strong> {{ $user->name }}
                </div>
                <div class="col-md-6 mb-2">
                    <strong>Email:</strong> {{ $user->email }}
                </div>
                <div class="col-md-6 mb-2">
                    <strong>Morada:</strong> {{ $user->address }}
                </div>
                <div class="col-md-6 mb-2">
                    <strong>NIF:</strong> {{ $user->nif }}
                </div>
            </div>
        </div>
    </div>

    {{-- Card: Editar Utilizador --}}
    <div class="card shadow-sm">
        <div class="card-header">
            <h5 class="mb-0">Editar Utilizador</h5>
        </div>
        <div class="card-body">
            <form method="POST" action="{{ route('users.update') }}">
                @csrf
                @method('PUT')

                <input type="hidden" name="id" value="{{ $user->id }}">

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nome</label>
                        <input
                            type="text"
                            name="name"
                            value="{{ old('name', $user->name) }}"
                            class="form-control @error('name') is-invalid @enderror"
                        >
                        @error('name')
                            <div class="invalid-feedback">Erro de nome</div>
                        @enderror
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">Email</label>
                        <input
                            type="email"
                            value="{{ $user->email }}"
                            class="form-control"
                            disabled
                        >
                        <div class="form-text">
                            O email não pode ser alterado.
                        </div>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">Morada</label>
                        <input
                            type="text"
                            name="address"
                            value="{{ old('address', $user->address) }}"
                            class="form-control"
                        >
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class="form-label">NIF</label>
                        <input
                            type="text"
                            name="nif"
                            value="{{ old('nif', $user->nif) }}"
                            class="form-control"
                        >
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

