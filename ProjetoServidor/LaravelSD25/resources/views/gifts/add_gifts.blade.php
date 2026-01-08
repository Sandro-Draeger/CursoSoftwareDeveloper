@extends('layouts.fe_master')
@section('content')


<form action="{{ route('gift.store') }}" method="POST">
    @csrf

<div class="container mt-4">
    <h3 class="mb-4">Adicionar Presente</h3>

    <form action="{{ route('gift.store') }}" method="POST">
        @csrf

        <div class="mb-3">
            <label class="form-label">Nome do presente</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Valor previsto</label>
            <input type="number" step="0.01" name="estimated_value" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Pessoa que vai receber</label>
            <select name="user_id" class="form-select" required>
                <option value="">Selecione um</option>
                @foreach($users as $user)
                    <option value="{{ $user->id }}">{{ $user->name }} </option>
                @endforeach
            </select>
        </div>

        <button type="submit" class="btn btn-primary">
            Adicionar
        </button>
    </form>


@endsection
