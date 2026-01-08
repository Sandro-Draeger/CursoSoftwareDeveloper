@extends('layouts.fe_master')

@section('content')
    <h5>Aqui vamos ver os dados de um user</h5>

    <h6>Nome: {{ $user->name }}</h6>
    <h6>Email: {{ $user->email }}</h6>
    <h6>Morada: {{ $user->address }}</h6>
    <h6>NIF: {{ $user->nif }}</h6>
           <form method="POST" action="{{ route('users.update') }}">
        @csrf
        @method('PUT')

        <input type="hidden" name="id" value="{{ $user->id }}" />

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nome</label>
            <input value="{{$user->name}}" name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        @error('name')
            <p class="text-danger"> Erro de nome</p>
        @enderror
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input value="{{$user->email}}" name="email" disabled required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div  id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        @error('email')
            <p class="text-danger"> Erro de email</p>
        @enderror

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Morada</label>
            <input value="{{ $user->address }}" name="address" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Nif</label>
            <input value="{{ $user->nif }}" name="nif" type="text" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
@endsection
