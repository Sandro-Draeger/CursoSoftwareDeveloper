@extends('layouts.fe_master')
@section('content')

<div class="row justify-content-center mt-4">
    <div class="col-md-6">

        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white">
                <h5 class="mb-0">Adicionar Utilizador</h5>
            </div>

            <div class="card-body">
                <p class="text-muted mb-4">
                    Olá, aqui podes adicionar utilizadores!
                </p>

                <form method="POST" action="{{ route('users.store') }}">
                    @csrf

                    <div class="mb-3">
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

                    <div class="mb-3">
                        <label class="form-label">Email address</label>
                        <input
                            required
                            name="email"
                            type="email"
                            class="form-control @error('email') is-invalid @enderror"
                        >
                        <div class="form-text">
                            We'll never share your email with anyone else.
                        </div>
                        @error('email')
                            <div class="invalid-feedback">Erro de email</div>
                        @enderror
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input
                            required
                            name="password"
                            type="password"
                            class="form-control @error('password') is-invalid @enderror"
                        >
                        @error('password')
                            <div class="invalid-feedback">Erro de password</div>
                        @enderror
                    </div>

                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-success">
                            Criar Utilizador
                        </button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

@endsection
