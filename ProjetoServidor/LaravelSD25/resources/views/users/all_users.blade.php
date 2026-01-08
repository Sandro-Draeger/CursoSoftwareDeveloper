@extends('layouts.fe_master')
@section('content')
<div class="container mt-4">

    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Users vindo da BD</h5>
        </div>

        <div class="card-body">

            @if (session('message'))
                <div class="alert alert-success">
                    {{ session('message') }}
                </div>
            @endif

            {{-- Formulário de pesquisa --}}
            <form class="row g-2 mb-4" action="" method="get">
                <div class="col-md-8">
                    <input
                        type="text"
                        name="search"
                        id="search"
                        class="form-control"
                        placeholder="Pesquisar por nome ou email"
                    >
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary w-100">Pesquisar</button>
                </div>
            </form>

            {{-- Tabela de users --}}
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>NIF</th>
                            <th class="text-end">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach ($usersFromDB as $user)
                            <tr>
                                <td>{{ $user->id }}</td>
                                <td>{{ $user->name }}</td>
                                <td>{{ $user->email }}</td>
                                <td>{{ $user->nif }}</td>
                                <td class="text-end">
                                    @auth
                                     {{-- Apenas mostrar ações se o user estiver autenticado --}}
                                    <a href="{{ route('user.view', $user->id) }}" class="btn btn-sm btn-info">
                                        Ver/Editar
                                    </a>
                                    @if(Auth::user()->email == 'sandro@gmail.com')
                                    <a href="{{ route('users.delete', $user->id) }}"
                                       class="btn btn-sm btn-danger"
                                       onclick="return confirm('Tem a certeza que deseja apagar este user?')">
                                        Apagar
                                    </a>
                                    @endif
                                    @endauth
                                </td>

                            </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>
@endsection

