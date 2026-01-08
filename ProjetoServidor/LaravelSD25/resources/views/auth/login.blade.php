@extends('layouts.fe_master')
@section('content')


 <form method="POST" action="{{ route('login') }}">
        @csrf


<div class="row justify-content-center">
    <div class="col-md-5">

        <div class="card shadow-sm">
            <div class="card-body">

                <h5 class="text-center mb-4">Login</h5>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input
                        required
                        name="email"
                        type="email"
                        class="form-control @error('email') is-invalid @enderror"
                        placeholder="exemplo@email.com"
                    >
                    @error('email')
                        <div class="invalid-feedback">
                            Erro de email
                        </div>
                    @enderror
                </div>

                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input
                        required
                        name="password"
                        type="password"
                        class="form-control @error('password') is-invalid @enderror"
                        placeholder="••••••••"
                    >
                    @error('password')
                        <div class="invalid-feedback">
                            Erro de password
                        </div>
                    @enderror
                </div>

    <button type="submit" class="btn btn-primary w-100 mt-3">
                    Entrar
                </button>

            </div>
        </div>

</div>
</div>
</form>

@endsection

