@extends('layouts.fe_master')
@section('content')

<h6>Aqui vamos carregar todos os users que estão na base de dados</h6>

    <ul>
        @foreach ($usersThatWillComeFromDB as $user)
            <li>{{ $user }}</li>
        @endforeach
    </ul>
@endsection
