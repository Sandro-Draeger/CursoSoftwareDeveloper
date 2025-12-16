<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;

Route::get('/home', [UtilController::class, 'home'])->name('home');

Route::get('/hello', [UtilController::class, 'hello'])->name('hello');

Route::get('/welcome/{name}', [UtilController::class, 'welcome'])->name('welcome');


//rota nova para o formulário
Route::get('/add-user',  [UserController::class, 'addUser'])->name('user.add');

//rota nova para o formulário
Route::get('/all-users',  [UserController::class, 'listUsers'])->name('user.all');


Route::fallback(function () {
    return view('homepage');;
});
