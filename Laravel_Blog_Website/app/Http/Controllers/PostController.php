<?php

namespace App\Http\Controllers;

use App\Post;
use App\Theme;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use phpDocumentor\Reflection\Types\Compound;
use Carbon\Carbon;
use PhpParser\Node\Stmt\Foreach_;

class PostController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $themes = Theme::all();
        $search_query = \Request::get('search');
        if ($search_query != ""){
            $posts = Post::where('name','like','%'.$search_query.'%')
                ->orderBy('name')->get();
        }
        else{
            $posts = Post::all();
        }
        return view("posts.index", compact('posts'), compact('themes'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('posts.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $validated = $this->validatePost();
        $validated['created_by'] = auth()->id();

       $post = Post::create($validated);
        return redirect('/posts');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Post $post)
    {
        $post->is_deleted = 1;
        $post->deleted_by = Auth::user()->id;
        $post->update(request(['is_deleted']));
        $post->delete();
        return redirect('/posts');
    }

    public function validatePost(){
        return request()->validate([
            'name' => ['required', 'min:3', 'max:255'],
            'caption' => ['required', 'min:3'],
            'url' => ['required', 'max:1000']//, 'regex:/^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/']
        ]);
    }

    public function fetchPosts(){
        $timestamp = Carbon::now()->subSeconds(3);
        //$posts = Post::where('created_at', '>', $timestamp)->where('created_by', '!=', Auth::user()->id)->get();
//        $posts = $posts->keyBy('id');
//        foreach ($posts as $post){
//            if ($post->created_by == Auth::user()->id){
//                $posts->forget($post->id);
//            }
//        }
        $posts = Post::where('created_at', '>', $timestamp)->get();
        return view("posts.fetch", compact('posts'));
    }
}
