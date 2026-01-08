@extends('layouts.fe_master')

@section('content')

<div class="container mt-4">

    <!-- Card com links e imagem lado a lado -->
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="row align-items-center">

                <!-- Links à esquerda -->
                <div class="col-md-6">
                    <h5 class="mb-3">Menu</h5>

                    <h7>Utilizadores</h7>

                    <div class="list-group">
                        <a href="{{ route('user.add') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Adicionar Utilizador
                        </a>
                         <a href="{{ route('user.all') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Visualizar Utilizadores
                        </a>

                        <br>
                        <h7>Tasks</h7>
                        <a href="{{ route('tasks.add') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Adicionar Tasks
                        </a>
                        <a href="{{ route('task.all') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Visualizar Tasks
                        </a>

                        <br>
                        <h7>Gifts</h7>
                        <a href="{{ route('gift.add') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Adicionar Gifts
                        </a>
                        <a href="{{ route('gift.all') }}" id="btnAcesso" class="list-group-item list-group-item-action">
                            Visualizar Gift List
                        </a>
                    </div>
                </div>

                <!-- Imagem à direita -->
                <div class="col-md-6 text-center">
                    <img src="{{ asset('images/1lemur.jpg') }}"
                         alt="Lemure Image"
                         class="img-fluid rounded"
                         style="max-height: 350px;">
                </div>

            </div>
        </div>
    </div>
    <!-- ALERTA PARA ADMINISTRADOR -->
    @if(session('user_type') === '1')
        <div class="alert alert-warning alert-dismissible fade show mt-3" role="alert">
            ⚠️ Conta Administrador
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    @endif

</div>
@endsection


