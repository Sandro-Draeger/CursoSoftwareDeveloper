<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
})->name('welcome');


Route::get('/hello', function () {
    return "<h1>Hello, World!</h1>";
})->name('hello');


Route::get('/welcome/{name}', function ($name) {
    return "<h1>bem-vindo, $name</h1>";
});

Route::get('/home', function(){
    return view('homepage');
});


//rota nova para o formulário
Route::get('/form', function(){
    return view('users.formpage');
})->name('form');


Route::fallback(function () {
    return view('homepage');;
});