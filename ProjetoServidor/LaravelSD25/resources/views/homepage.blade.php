@extends('layouts.fe_master')

@section('content')
<div class="container mt-4">

    <!-- Card com links e imagem lado a lado -->
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="row align-items-center">

                <!-- Links à esquerda -->
                <div class="col-md-6">
                    <h5 class="mb-3">Links Rápidos</h5>
                    <div class="list-group">
                        <a href="{{ route('welcome', 'Software Developer') }}" class="list-group-item list-group-item-action">
                            Welcome Page
                        </a>
                        <a href="{{ route('hello') }}" class="list-group-item list-group-item-action">
                            Hello Page
                        </a>
                        <a href="{{ route('user.add') }}" class="list-group-item list-group-item-action">
                            Adicionar Utilizador
                        </a>
                        <a href="{{ route('user.all') }}" class="list-group-item list-group-item-action">
                            Adicionar Alunos
                        </a>
                        <a href="{{ route('tasks.add') }}" class="list-group-item list-group-item-action">
                            Adicionar Tasks
                        </a>
                        <a href="{{ route('task.all') }}" class="list-group-item list-group-item-action">
                            Visualizar Tasks
                        </a>
                        <a href="{{ route('gift.add') }}" class="list-group-item list-group-item-action">
                            Adicionar Gifts
                        </a>
                        <a href="{{ route('gift.all') }}" class="list-group-item list-group-item-action">
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

</div>
@endsection


