<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;

use Illuminate\Http\Request;

class TasksController extends Controller
{
    public function all_tasks()
    {
        $tasksFromDB = DB::table('tasks')->get();

        return view('tasks.all_tasks', compact('tasksFromDB'));
    }
}
