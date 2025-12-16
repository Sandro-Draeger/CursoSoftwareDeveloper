@extends('layouts.fe_master')
@section('content')

    <h6>Tasks</H6>

        <table class="table">
<thead>
<tr>
<th scope="col">#</th>
<th scope="col">Nome</th>
<th scope="col">Descrição</th>
<th scope="col">Status</th>
</tr>
</thead>
<tbody>
    @foreach ($tasksFromDB as $tasks)
<tr>
<th scope="row">{{ $tasks->id }}</th>
<td>{{ $tasks->name }}</td>
<td>{{ $tasks->description }}</td>
<td>{{ $tasks->status == 1 ? 'Feito' : 'A Fazer' }}</td>
</tr>
@endforeach
</tbody>
</table>

@endsection
