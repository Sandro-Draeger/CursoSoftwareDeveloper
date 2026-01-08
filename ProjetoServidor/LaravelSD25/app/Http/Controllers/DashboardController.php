<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class DashboardController extends Controller
{
   public function index()
    {
        $user = Auth::user();

        $user_type = $user->user_type;

        return view('dashboard', compact('user', 'user_type'));
    }

    public function dashboard()
    {
        return view('homepage');
    }
}
