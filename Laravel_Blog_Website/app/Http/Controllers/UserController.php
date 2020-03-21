<?php

namespace App\Http\Controllers;

use App\Role;
use App\Theme;
use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Input;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $themes = Theme::all();
        $search_query = \Request::get('search');
        if ($search_query != ""){
            $users = User::where('name','like','%'.$search_query.'%')->orWhere('email', 'like', '%'.$search_query.'%')
                ->orderBy('name')->get();
        }
        else{
            $users = User::all();
        }
        $this->authorize('update', $users[0]);
        return view("users.index", compact('users'), compact('themes'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //Handled by Auth
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //Handled by Auth
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show(User $user)
    {

    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(User $user)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $user);
        $roles = Role::all();
        return view("users.edit", compact("user", "roles"));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(User $user)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $user);
       $roles = Role::all();
       foreach ($roles as $role){
           if (Input::get('role_'.$role->id.'_check')){
               $user->roles()->attach($role->id);
           }
           else{
                $user->roles()->detach($role->id);
           }
       }

        $user->update(request(['name', 'email']));
        return redirect('/users');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(User $user)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $user);
        $user->is_deleted = 1;
        $user->deleted_by = Auth::user()->id;
        $user->update(request(['is_deleted']));
        $user->delete();
        return redirect('/users');
    }

    public function ValidateLoggedIn(){
        if (!Auth::user()) {
            return false;
        }
    }
}
