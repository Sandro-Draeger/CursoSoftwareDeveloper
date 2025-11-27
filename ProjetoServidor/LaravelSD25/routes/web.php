<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/hello', function () {
    return "<h1>Hello, World!</h1>";
});

Route::get('/welcome/{name}', function ($name) {
    return "<h1>bem-vindo, $name</h1>";
});
