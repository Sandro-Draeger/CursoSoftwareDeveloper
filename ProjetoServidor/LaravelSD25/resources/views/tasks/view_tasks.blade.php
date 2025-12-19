@extends('layouts.fe_master')
@section('content')

<h5>Dados Tasks</h5>

<h6>Nome: {{ $task->name }}</h6>
<h6>Descrição: {{ $task->description }}</h6>
<h6>Data: {{ $task->due_at }}</h6>
<h6>Responsável: {{ $task->username }}</h6>


@endsection
