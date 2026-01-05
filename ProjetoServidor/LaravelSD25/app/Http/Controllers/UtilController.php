<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UtilController extends Controller
{
public function home()
{
    $myName = "Sandro";

    $userData = [
        'name' => 'Sara',
        'age'  => 39
    ];

    $cesaeInfo = $this->getCesaeInfo();

    return view('homepage', compact('myName', 'userData', 'cesaeInfo'));
}

private function getCesaeInfo()
{
    return [
            'name' => 'Cesae',
            'address' => 'Rua Ciríaco Cardoso 186, 4150-212 Porto',
            'email' => 'cesae@cesae.pt'
        ];
}

        public function hello(){
        return "<h1>Hello, World!</h1>";
    }

    public function welcome($name){
        return "<h1>bem-vindo, $name</h1>";
    }
}
