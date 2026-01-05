<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;
use App\Models\Task;
use Illuminate\Http\Request;
use App\Models\User;


class TasksController extends Controller
{





    public function storeTask(Request $request){
        //dd($request->all());

           //validar se os dados recebidos estão em conformidade com a BAse de dados
        $request->validate([
            'name' => 'required',
            'description' => 'required',
            'user_id' =>'required'
        ]);

        //inserir user na base de dados
        Task::insert([
            'name' => $request->name,
            'description' => $request->description,
            'user_id' => $request->user_id
        ]);
              return redirect()->route('task.all')->with('message', 'Task adicionada com sucesso!');
    }

        public function addTask(){
        $tasks = $this->getAllTasks();

        return view('tasks.add_tasks', compact('tasks'));
    }


    public function all_tasks()
    {
        $tasksFromDB = $this->getAllTasks();

        return view('tasks.all_tasks', compact('tasksFromDB'));
    }

    public function viewTasks($id){

        $task = $this->getAllTasks()->where('id', $id)->first();


        return view('tasks.view_tasks', compact('task'));
    }

    public function deleteTasks($id){

      DB::table('tasks')
        ->where('id', $id)
        ->delete();

        return back();
    }


protected function getAllTasks(){
        $tasks = DB::table('tasks')
        ->join('users', 'users.id', '=', 'tasks.user_id')
        ->select("tasks.*","users.name as username")
        ->get();

        return $tasks;

    }


    }


