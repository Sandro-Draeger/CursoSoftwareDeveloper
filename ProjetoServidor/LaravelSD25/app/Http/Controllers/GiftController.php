<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Gift;
use App\Models\User;

class GiftController extends Controller
{
    /**
     * Lista todos os presentes
     */
    public function listGift()
    {
        $gifts = $this->getAllGifts();

        return view('gifts.all_gifts', compact('gifts'));
    }

    /**
     * Mostra o formulário para adicionar presente
     */
    public function addGift()
    {
        $users = User::all();

        return view('gifts.add_gifts', compact('users'));
    }

    /**
     * Salva o presente no banco
     */
    public function storeGift(Request $request)
    {
        $request->validate([
            'name'            => 'required|string|max:255',
            'estimated_value' => 'required|numeric',
            'user_id'         => 'required|exists:users,id',
            'spent_value'     => 'nullable|numeric',
        ]);

        Gift::create([
            'name'            => $request->name,
            'estimated_value' => $request->estimated_value,
            'user_id'         => $request->user_id,
            'spent_value'     => $request->spent_value,
        ]);

        return redirect()
            ->route('gift.all')
            ->with('message', 'Presente adicionado com sucesso!');
    }

    /**
     * Busca todos os presentes no banco
     */
    protected function getAllGifts()
    {
        return DB::table('gifts')
            ->join('users', 'users.id', '=', 'gifts.user_id')
            ->select(
                'gifts.*',
                'users.name as username'
            )
            ->get();
    }

    public function create()
{
    $users = User::all(); // ou o filtro que você quiser
    return view('sua_view', compact('users'));
}
}
