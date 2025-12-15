<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function form(){
    return view('users.formpage');
    }

    public function addForm(){
        $users = ['Francisco', 'Ana', 'Maria', 'João'];

        return view('users.formpage', compact('users'));
}
}

