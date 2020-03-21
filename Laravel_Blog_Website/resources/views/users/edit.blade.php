@extends('layouts.app')
@section('content')
{{--    <div class="box">--}}
{{--        <h2>User Admin - Edit</h2>--}}
{{--        <div>--}}
{{--            <form class="form-group" method="post" action="/users/{{ $user->id }}">--}}
{{--                {{ method_field('PATCH') }}--}}
{{--                {{ csrf_field() }}--}}
{{--                <h4>Name:</h4>--}}
{{--                <input type="text" name="name" value="{{$user->name}}" class="form-control">--}}
{{--                <h4>Email:</h4>--}}
{{--                <input type="text" name="email" value="{{$user->email}}" class="form-control">--}}
{{--                <h4>Roles:</h4>--}}
{{--                @foreach($roles as $role)--}}
{{--                    <div class="custom-control custom-switch">--}}
{{--                        <input type="checkbox" class="custom-control-input" id="customSwitch{{$role->id}}" name="role_{{$role->id}}_check" value="{{$role->id}}"--}}
{{--                        @if($user->roles->contains($role))--}}
{{--                            checked--}}
{{--                        @endif--}}
{{--                        >--}}
{{--                        <label class="custom-control-label" for="customSwitch{{$role->id}}">{{$role->name}}</label>--}}
{{--                    </div>--}}
{{--                @endforeach--}}
{{--                <button type="submit" class="btn btn-primary">Submit Changes</button>--}}
{{--            </form>--}}
{{--        </div>--}}
{{--    </div>--}}
@endsection
