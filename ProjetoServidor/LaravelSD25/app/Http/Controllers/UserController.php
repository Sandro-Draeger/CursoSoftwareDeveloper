<?php



namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    public function addUser(){
        $users = $this->getAllUsers();

        return view('users.add_user', compact('users'));
    }

    //nova função para update
    public function updateUser(Request $request){

        //validar se os dados recebidos estão em conformidade com a BAse de dados
        $request->validate([
            'name' => 'required',
            'address' => 'nullable|string|max:255',
            'nif' => 'nullable|string|max:20',
        ]);

        User::where('id', $request->id)
            ->update([
                'name' => $request->name,
                'address' => $request->address,
                'nif' => $request->nif,
            ]);

        return redirect()
            ->route('user.view', ['id' => $request->id])
            ->with('message', 'User atualizado com sucesso!');
    }
    //listar e filtro de users
    public function listUsers(){

        //se o campo de pesquisa tiver valor, atribui à variável $search, senão atribui null
        $search = request()->query('search') ? request()->query('search') : null;

        //se tiver valor na variável $search, faz pesquisa com filtro, senão lista todos
        if($search){
            $usersFromDB = DB::table('users')
            ->where('name', 'like', '%'.$search.'%')
            ->orWhere('email', 'like', '%'.$search.'%')
            ->get();
        }else{
            $usersFromDB = DB::table('users')
            ->get();
        }

        return view('users.all_users', compact('usersFromDB'));
    }

    public function viewUser($id){

        $user = User::where('id', $id)->first();

        return view('users.view_user', compact('user'));
    }


    private function getAllUsers(){

        //no futuro carregamos dados da base de dados (query À BD)
        $users = ['Francisco', 'Luís','Rafaela', 'Maria'];
        return $users;
    }

    public function storeUser(Request $request){
        //dd($request->all());

           //validar se os dados recebidos estão em conformidade com a BAse de dados
        $request->validate([
            'name' => 'required',
            'email' => 'required|unique:users|email',
            'password' =>'min:8|required'
        ]);

        //inserir user na base de dados
        User::insert([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
            'updated_at' => now(),
        ]);
              return redirect()->route('user.add')->with('message', 'User adicionado com sucesso!');

    }


    public function deleteUser($id){

        //se tiver tasks associadas, apaga
        Db::table('tasks')
        ->where('user_id', $id)
        ->delete();

         DB::table('users')
        ->where('id', $id)
        ->delete();


        return back();
    }

}


