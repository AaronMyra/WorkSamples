@extends('layouts.app')
@section('content')
    <div class="box">
        <h2>Theme Edit</h2>
        <div>
            <form class="form-group" method="post" action="/themes/{{ $theme->id }}">
                {{ method_field('PATCH') }}
                {{ csrf_field() }}
                <h4>Title:</h4>
                <input type="text" name="name" value="{{$theme->name}}" class="form-control">
                <h4>Description:</h4>
                <input type="text" name="description" value="{{$theme->description}}" class="form-control">
                <h4>URL:</h4>
                <input type="text" name="url" value="{{$theme->url}}" class="form-control">
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </div>
@endsection
