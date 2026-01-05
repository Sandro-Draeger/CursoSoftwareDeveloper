@extends('layouts.fe_master')
@section('content')


<div class="container mt-4">
    <h6>Presentes</h6>

    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Valor Previsto</th>
                <th>Valor Gasto</th>
                <th>Quem vai receber</th>
            </tr>
        </thead>

        <tbody>
            @foreach ($gifts as $gift)
                <tr>
                    <th scope="row">{{ $gift->id }}</th>
                    <td>{{ $gift->name }}</td>
                    <td>{{ $gift->estimated_value}} €</td>
                    <td>{{ $gift->spent_value}} €</td>
                    <td>{{ $gift->username }}</td>
                    <td><a href="" class="btn btn-info">Ver</a></td>
                    <td><a href="" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>

</div>

@endsection
