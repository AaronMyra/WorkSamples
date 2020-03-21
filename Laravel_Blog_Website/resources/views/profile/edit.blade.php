@extends('layouts.app')
@section('content')
    <div class="box">
        <h1 style="text-align: center">{{$profile->owner->name}}</h1>
            <form class="form-group" method="post" action="/profiles/{{ $profile->id }}">
                {{ method_field('PATCH') }}
                {{ csrf_field() }}
                <div class="container box">
                    <img id="profilePic" src="{{ $profile->pic_url}}" style="width: 20%">
                    <input type="text" class="form-control" name="pic_url" value="{{ $profile->pic_url }}">
                </div>
                <div class="container box">
                    <div class="card border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-header">Bio
                        </div>
                        <div class="card-body">
                            <textarea class="card-text" name="bio">{{ $profile->bio }}</textarea>
                            <h5>Birthday</h5>
                            <input class="card-text" value="{{ $profile->birth_date }}">
                        </div>
                    </div>
                    <div class="card border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-header">Contact Info</div>
                        <div class="card-body">
                            <h5>Phone Number</h5>
                            <input type="text" class="card-text" name="phone_number" value="{{ $profile->phone_number }}">
                            <h5>Email</h5>
                            <p class="card-text">{{ $profile->owner->email }}</p>
                        </div>
                    </div>
                </div>
                <div class="container box">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
        <div class="container box">
            <form method="GET" action="/profiles/{{ $profile->id }}">
                <button type="submit" class="btn btn-primary">Return</button>
            </form>
        </div>
    </div>
@endsection
