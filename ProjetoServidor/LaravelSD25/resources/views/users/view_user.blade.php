@extends('layouts.fe_master')
@section('content')

<h5>Dados User</h5>

    <h5>Aqui vamos ver os dados de um user</h5>

    <h6>Nome: {{ $user->name }}</h6>
    <h6>Email: {{ $user->email }}</h6>
    <h6>Morada: {{ $user->address }}</h6>

@endsection



