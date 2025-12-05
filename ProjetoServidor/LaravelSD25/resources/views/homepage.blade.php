<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
</head>
<body>
    @php
        //consulta a base de dados pelo nome do login
        $myName = "Sandro";       
    @endphp
    <h3>Bem vindo {{$myName}}</h3>
    <ul>
        <li><a href="{{ route('welcome') }}">Welcome Page</li>
        <li><a href="{{ route('hello') }}">Hello Page</li>
        <li><a href="{{ route('form') }}">Adicionar Utilizador</li>
    </ul>

</body>
</html>