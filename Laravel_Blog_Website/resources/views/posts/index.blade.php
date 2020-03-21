@extends('layouts.app')

@php(\Carbon\Carbon::class)

@section('stylesheet')
    <link href="{{ asset('css/post.css') }}" rel="stylesheet" type="text/css">
@endsection

@section('content')
    <div class="box">
        <h2 id="title">Post Feed</h2>
        <form method="get" action="/posts" class="search_bar">
            <div class="form-group">
                <input type="text" name="search" class="form-control" id="exampleInputEmail1" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-primary">Search</button>
                </span>
            </div>
        </form>
        <div class="container box">
            <select class="form-control" name="themes" onchange="styleChange()" id="styles">
                @foreach($themes as $theme)
                    @if($theme->name == request()->cookie('styleName'))
                        <option selected name="style" value="{{ $theme->name }}">{{ $theme->name }}</option>
                    @else
                        <option name="style" value="{{ $theme->name }}">{{ $theme->name }}</option>
                    @endif
                @endforeach
            </select>
        </div>
        </div>
        @if(Auth::user())
            <div class="container box">
                <form method="GET" action="/posts/create">
                    {{csrf_field()}}
                    <button type="submit" id="createPost" class="btn btn-primary">Create Post</button>
                </form>
            </div>
        @endif
        <div>
            <table id="post_table" style="margin: auto;">
                    <script>
                        function fetchPost() {
                            var url = 'http://127.0.0.1:8000/fetchPosts';
                            fetch(url).then(response => response.text()).then(text => {
                                if (text.length > 0) {
                                    var postsDiv = document.getElementById('post_table');
                                    postsDiv.innerHTML = text + postsDiv.innerHTML;
                                }
                            }).catch(err => {
                                console.log(err)
                            });

                            setTimeout(fetchPost, 3000);
                        }
                        fetchPost()
                    </script>
                @if(sizeof($posts) != 0)
                    @foreach($posts->reverse() as $post)
                        @if(!$post->is_deleted)
                            <tr>
                                <td class="table_row">
                                    <div class="card mb-3">
                                        <h3 class="card-header">{{ $post->name }}</h3>
                                        <img src="{{ $post->url }}" alt="{{ $post->name }}" class="card-img">
                                        <div class="card-body">
                                            <p class="card-text">{{ $post->caption }}</p>
                                        </div>
                                        @if(Auth::user())
                                            @if($post->user)
                                                <div class="card-body">
                                                    <a href="/profiles/{{ $post->user->profile->id}}" class="card-link">User</a>
                                                </div>
                                            @endif
                                            @if(Auth::user()->isPostAdmin())
                                                <form method="POST" action="/posts/{{$post->id}}">
                                                    {{ csrf_field() }}
                                                    {{ method_field('DELETE') }}
                                                    <button type="submit" id="postDelete">DELETE</button>
                                                </form>
                                            @endif
                                        @endif
                                    </div>
                                </td>
                            </tr>
                        @endif
                    @endforeach
                @endif

            </table>
        </div>
    </div>
@endsection
