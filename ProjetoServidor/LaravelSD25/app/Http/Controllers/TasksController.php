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

    public function updateTask(Request $request)
    {
        $request->validate([
            'id' => 'required|integer',
            'name' => 'required',
            'description' => 'required',
            'user_id' => 'required|integer',
            'status' => 'required|in:0,1',
        ]);

        DB::table('tasks')
            ->where('id', $request->id)
            ->update([
                'name' => $request->name,
                'description' => $request->description,
                'user_id' => $request->user_id,
                'status' => $request->status,
                'updated_at' => now(),
            ]);

        return redirect()->route('task.all')->with('message', 'Task atualizada com sucesso!');
    }


    public function addTask(){
            $tasks = $this->getAllTasks();
            $users = User::all();

            return view('tasks.add_tasks', compact('tasks', 'users'));
    }


    public function all_tasks()
    {
        $search = request()->query('search') ? request()->query('search') : null;

        if($search){
            $tasksFromDB = DB::table('tasks')
            ->where('name', 'like', '%'.$search.'%')
            ->orWhere('description', 'like', '%'.$search.'%')
            ->orWhere('status', 'like', '%'.$search.'%')
            ->orWhere('user_id', 'like', '%'.$search.'%')
            ->get();
        }else{
            $tasksFromDB = $this->getAllTasks();
        }

        return view('tasks.all_tasks', compact('tasksFromDB'));
    }

    public function viewTasks($id){

        $task = $this->getAllTasks()->where('id', $id)->first();
        $users = User::all();

        return view('tasks.view_tasks', compact('task', 'users'));
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


