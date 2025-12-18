@extends('layouts.fe_master')

@section('content')


    <img src="{{ asset('images/1lemur.jpg') }}" alt="Lemure Image">
    <ul>
        <li><a href="{{ route('welcome', 'Software Developer') }}">Welcome Page</a></li>
        <li><a href="{{ route('hello') }}">Hello Page</a></li>
        <li><a href="{{ route('user.add') }}">Adicionar Utilizador</a></li>
        <li><a href="{{ route('user.all') }}">Adicionar Alunos</a></li>
        <li><a href="{{ route('tasks.add') }}">Adicionar Tasks</a></li>
        <li><a href="{{ route('task.all') }}">Visualizar Tasks</a></li>
    </ul>

@endsection
