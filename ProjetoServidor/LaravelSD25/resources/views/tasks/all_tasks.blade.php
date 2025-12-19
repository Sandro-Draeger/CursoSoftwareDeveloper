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
<th scope="col">Data de Conclusão</th>
<th scope="col">Responsável</th>
<th scope="col"></th>
<th scope="col"></th>
</tr>
</thead>
<tbody>
    @foreach ($tasksFromDB as $tasks)
<tr>
<th scope="row">{{ $tasks->id }}</th>
<td>{{ $tasks->name }}</td>
<td>{{ $tasks->description }}</td>
<td>{{ $tasks->status == 1 ? 'Feito' : 'A Fazer' }}</td>
<td>{{ $tasks->due_at }}</td>
<td>{{ $tasks->username }}</td>
 <td><a href="{{ route('tasks.view', $tasks->id) }}" class="btn btn-info">Ver</a></td>
<td><a href="{{ route('tasks.delete', $tasks->id) }}" class="btn btn-danger">Apagar</a></td>
</tr>
@endforeach
</tbody>
</table>

@endsection
