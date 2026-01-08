@extends('layouts.fe_master')
@section('content')



    <h6>Users vindo da BD</H6>
    @if (session('message'))
    <div class="alert alert-success">{{session('message')}}</div>
    @endif

        <table class="table">
<thead>
<tr>
<th scope="col">#</th>
<th scope="col">Nome</th>
<th scope="col">Email</th>
<th scope="col">NIF</th>
<th scope="col"></th>
<th scope="col"></th>
</tr>
</thead>
<tbody>
    @foreach ($usersFromDB as $user)
<tr>
<th scope="row">{{ $user->id }}</th>
    <td>{{ $user->name }}</td>
    <td>{{ $user->email }}</td>
    <td>{{ $user->nif }}</td>
    <td><a href="{{ route('user.view', $user->id) }}" class="btn btn-info">Ver/Editar</a></td>
    <td><a href="{{ route('users.delete', $user->id) }}" class="btn btn-danger">Apagar</a></td>
</tr>
@endforeach
</tbody>
</table>

@endsection
