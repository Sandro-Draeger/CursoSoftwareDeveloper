<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
   public function home(){
    $myName = "Sandro";
        return view('homepage', compact('myName'));
   }

    public function hello(){
        return "<h1>Hello, World!</h1>";
    }

    public function welcome($name){
        return "<h1>bem-vindo, $name</h1>";
    }
}
