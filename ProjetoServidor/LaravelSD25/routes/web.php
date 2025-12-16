<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;
use App\Http\Controllers\TasksController;

Route::get('/home', [UtilController::class, 'home'])->name('home');

Route::get('/hello', [UtilController::class, 'hello'])->name('hello');

Route::get('/welcome/{name}', [UtilController::class, 'welcome'])->name('welcome');


//rota nova para o formulário
Route::get('/add-user',  [UserController::class, 'addUser'])->name('user.add');

//rota nova para o formulário
Route::get('/all-users',  [UserController::class, 'listUsers'])->name('user.all');

//rota nova para as tasks
Route::get('/all-tasks',  [TasksController::class, 'all_tasks'])->name('task.all');

Route::fallback(function () {
    return view('homepage');;
});
