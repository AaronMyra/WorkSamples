<?php

namespace App\Http\Controllers;

use App\Theme;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Cookie;

class ThemeController extends Controller
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
        $this->authorize('update', $themes[1]);
        $search_query = \Request::get('search');
        if ($search_query != "") {
            $themes = Theme::where('name', 'like', '%' . $search_query . '%')
                ->orderBy('name')->get();
        }
        return view("themes.index", compact('themes'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(Theme $theme)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $theme);
        return view("themes.edit", compact("theme"));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Theme $theme)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $theme);
        $theme->update(request(['name', 'description', 'url']));
        return redirect('/themes');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Theme $theme)
    {
        if (!Auth::user()){
            return redirect('/login');
        }
        $this->authorize('update', $theme);
        $theme->delete();
        return redirect('/themes');
    }

    public function setAsDefault($id){
        $themes = Theme::all();
        foreach ($themes as $theme){
            if($theme->id == $id){
                $theme->update(['is_default' => 1]);
            }
            else{
                $theme->update(['is_default' => 0]);
            }
        }
        return redirect('/themes');
    }

    public function ValidateLoggedIn(){
        if (!Auth::user()) {
            return false;
        }
    }

    public function setStyle(){
        $themeName = (\request('name'));
        $theme = Theme::where('name', $themeName)->first();
        Cookie::queue('styleUrl', $theme->url, 5000);
        Cookie::queue('styleName', $theme->name, 5000);
        return redirect('/posts');
    }
}
