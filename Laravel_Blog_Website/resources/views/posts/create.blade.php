@extends('layouts.app')

@section('stylesheet')
    <link href="{{ asset('css/post.css') }}" rel="stylesheet" type="text/css">
@endsection

@section('content')
    <div class="container box">
        <h2>Create Post</h2>
        <div>
            <form class="form-group" method="POST" action="/posts">
                {{ csrf_field() }}
                <h4>Title:</h4>
                <input type="text" name="name" value="{{old('name')}}" class="form-control">
                <h4>Description:</h4>
                <textarea name="caption" class="form-control">{{old('caption')}}</textarea>
                <h4>URL:</h4>
                <input type="text" name="url" value="{{old('url')}}" class="form-control">
                <button type="submit" class="btn btn-primary">Submit Changes</button>
            </form>
        </div>
    </div>
    @include('layouts.errors')
@endsection
