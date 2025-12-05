@extends('layouts.fe_master')

@section('content')


    @if($myName)
    <h3>Bem vindo {{$myName}}</h3>
    @else
    <h3>Caro utilizador, faça login</h3>
    @endif

    <img src="{{ asset('images/1lemur.jpg') }}" alt="Lemure Image">
    <ul>
        <li><a href="{{ route('welcome', 'Software Developer') }}">Welcome Page</a></li>
        <li><a href="{{ route('hello') }}">Hello Page</a></li>
        <li><a href="{{ route('form') }}">Adicionar Utilizador</a></li>
    </ul>

@endsection
