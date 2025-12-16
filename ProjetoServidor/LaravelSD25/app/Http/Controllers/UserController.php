<?php



namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function addUser(){
        $users = $this->getAllUsers();

        return view('users.add_user', compact('users'));
    }

    public function listUsers(){
        $usersThatWillComeFromDB = ['Manuela', 'Vitor','Alexandre', 'Bruno'];

        $usersFromDB = db::table('users')->get();



        return view('users.all_users', compact('usersThatWillComeFromDB', 'usersFromDB'));
    }


    private function getAllUsers(){

        //no futuro carregamos dados da base de dados (query À BD)
        $users = ['Francisco', 'Luís','Rafaela', 'Maria'];
        return $users;
    }

    private function insertUserIntoDB(){
    DB::table('users')->updateOrinsert(
            ['email' =>'teste1@gmail.com'],
            [
            'name' =>'Joao',
            'updated_at'=>now(),
            'password' => '1234444'
        ]);
    }
    private function deleteUser(){

        DB::table('users')
        ->where('email', 'sara@gmail.com')
        ->delete();
    }

}


