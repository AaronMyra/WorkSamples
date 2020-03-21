@extends('layouts.app')

@section('stylesheet')
    <link href="{{ asset('css/user.css') }}" rel="stylesheet" type="text/css">
@endsection

@section('content')
    <div class="box">
        <h2 id="title">Users</h2>
        <form method="get" action="/users" class="search_bar">
            <div class="form-group">
                <input type="text" name="search" class="form-control" id="exampleInputEmail1" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-primary">Search</button>
                </span>
            </div>
        </form>
        <div>
           <table id="usersTable">
               <tr class="table-active theme_table_header">
                   <th class="theme_table_head">Username</th>
                   <th class="theme_table_head">Email</th>
                   <th class="theme_table_head"></th>
                   <th class="theme_table_head"></th>
               </tr>
               @foreach($users as $user)
                   @if(!$user->is_deleted)
                       @if($user->id%2 != 0)
                            <tr class="table-primary">
                       @else
                           <tr class="table-secondary">
                       @endif
                           <td>{{ $user->name}}</td>
                           <td>{{ $user->email}}</td>
                           <td>
                               <form method="get" action="/users/{{ $user->id }}/edit">
                                   <button type="submit" class="btn btn-warning">Edit</button>
                                   {{ csrf_field() }}
                               </form>
                           </td>
                           @if(!$user->is_deleted)
                               <td>
                                   <form method="POST" action="/users/{{$user->id}}">
                                       <button type="submit" class="btn btn-danger">Delete</button>
                                       {{ csrf_field() }}
                                       {{ method_field('DELETE') }}
                                   </form>
                               </td>
                           @else
                               <td>
                                   <form>
                                       <button type="submit">Un-Delete</button>
                                   </form>
                               </td>
                           @endif
                       </tr>
                    @endif
               @endforeach
           </table>
        </div>
    </div>
@endsection
