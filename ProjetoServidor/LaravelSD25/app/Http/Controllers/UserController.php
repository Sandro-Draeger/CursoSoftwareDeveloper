<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function addUser(){
        $users = $this->getAllUsers();

        return view('users.add_user', compact('users'));
    }

    public function listUsers(){
        $usersThatWillComeFromDB = ['Manuela', 'Vitor','Alexandre', 'Bruno'];
        return view('users.all_users', compact('usersThatWillComeFromDB'));
    }


    private function getAllUsers(){

        //no futuro carregamos dados da base de dados (query À BD)
        $users = ['Francisco', 'Luís','Rafaela', 'Maria'];
        return $users;
    }

}


