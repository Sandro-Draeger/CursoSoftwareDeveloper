@extends('layouts.fe_master')
@section('content')

<h6>Aqui vamos carregar todos os users que estão na base de dados</h6>

    <ul>
        @foreach ($usersThatWillComeFromDB as $user)
            <li>{{ $user }}</li>
        @endforeach
    </ul>

    <h6>Users vindo da BD</H6>

        <table class="table">
<thead>
<tr>
<th scope="col">#</th>
<th scope="col">Nome</th>
<th scope="col">Email</th>
<th scope="col">NIF</th>
</tr>
</thead>
<tbody>
    @foreach ($usersFromDB as $user)
<tr>
<th scope="row">{{ $user->id }}</th>
<td>{{ $user->name }}</td>
<td>{{ $user->email }}</td>
<td>{{ $user->nif }}/td>
</tr>
@endforeach
</tbody>
</table>

@endsection
