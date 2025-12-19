<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\UtilController;
use App\Http\Controllers\TasksController;
use App\Http\Controllers\GiftController;

Route::get('/home', [UtilController::class, 'home'])->name('home');

Route::get('/', function () {
    return view('welcome');
})->name('welcome');

Route::get('/hello', [UtilController::class, 'hello'])->name('hello');

Route::get('/welcome/{name}', [UtilController::class, 'welcome'])->name('welcome');


//rota: Users
Route::get('/add-user',  [UserController::class, 'addUser'])->name('user.add');

Route::post('/store-user',[UserController::class, 'storeUser'])->name('users.store');

Route::get('/all-users',  [UserController::class, 'listUsers'])->name('user.all');

Route::get('/user/{id}', [UserController::class, 'viewUser'])->name('user.view');

Route::get('/delete-user/{id}', [UserController::class, 'deleteUser'])->name('users.delete');


//rota: Tasks
Route::get('/all-tasks',  [TasksController::class, 'all_tasks'])->name('task.all');

Route::get('/task/{id}', [TasksController::class, 'viewTasks'])->name('tasks.view');

Route::get('/delete-task/{id}', [TasksController::class, 'deleteTasks'])->name('tasks.delete');

Route::post('/store-task',[TasksController::class, 'storeTask'])->name('tasks.store');

Route::get('/add-tasks',  [TasksController::class, 'addTask'])->name('tasks.add');

//rota: Gifts
Route::get('/add-gifts',  [GiftController::class, 'addGift'])->name('gift.add');

Route::post('/store-gifts',[GiftController::class, 'storeGift'])->name('gift.store');

Route::get('/all-gifts',  [GiftController::class, 'listGift'])->name('gift.all');


Route::fallback(function () {
    return view('homepage');;
});
