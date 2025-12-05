@extends('layouts.fe_master')

@section('content')

    <h3>Olá, aqui podes adicionar utilizadores!</h3>
    <form>
        <label for="name">Nome:</label>
        <input type="text" id="name">
        <br><br>
        <label for="email">Email:</label>
        <input type="email" id="email">
        <br><br>
        <button type="submit">Adicionar Utilizador</button>
</form>

@endsection
      
