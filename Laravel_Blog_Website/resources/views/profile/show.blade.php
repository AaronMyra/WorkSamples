@extends('layouts.app')
@section('content')
    <div class="container box">

        @if(!$profile->owner)
            <div class="alert alert-dismissible alert-danger" style="text-align: center">
                <strong >User Deactivated</strong>
            </div>
        @else
            <h1 style="text-align: center">{{ $profile->owner->name }}</h1>
            <div class="container box">
                <img id="profilePic" src="{{ $profile->pic_url}}" style="width: 20%">
            </div>
            <div class="card border-primary mb-3" style="max-width: 20rem;">
                <div class="card-header">Bio</div>
                <div class="card-body">
                    <p class="card-text">{{ $profile->bio }}</p>
                    <h5>Birthday</h5>
                    <p class="card-text">{{ $profile->birth_date }}</p>
                </div>
            </div>
            <div class="card border-primary mb-3" style="max-width: 20rem;">
                <div class="card-header">Contact Info</div>
                <div class="card-body">
                    <h5>Phone Number</h5>
                    <p class="card-text">{{ $profile->phone_number }}</p>
                    <h5>Email</h5>
                    <p class="card-text">{{ $profile->owner->email }}</p>
                </div>
            </div>
            @if($profile->owner->id == Auth::user()->id)
                <form method="GET" action="/profiles/{{ $profile->id }}/edit">
                    <button class="btn btn-primary" type="submit">Edit</button>
                </form>
            @endif
        @endif
    </div>
@endsection
