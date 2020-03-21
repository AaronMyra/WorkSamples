@extends('layouts.app')

@section('stylesheet')
    <link href="{{ asset('css/theme.css') }}" rel="stylesheet" type="text/css">
@endsection

@section('content')
    <div class="box">
        <h2>Themes</h2>
        <div class="search_bar">
            <form method="get" action="/themes">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit">Submit</button>
            </form>
        </div>
        <div>
            <table id="theme_table">
                <tr class="table-active theme_table_header">
                    <th class="theme_table_head">Title</th>
                    <th class="theme_table_head">Description</th>
                    <th class="theme_table_head"></th>
                    <th class="theme_table_head"></th>
                    <th class="theme_table_head"></th>
                </tr>
                @php($i = 2)
                @foreach($themes as $theme)
                    @if(($i%2) == 0)
                        <tr class="table-primary">
                    @else
                        <tr class="table-secondary">
                    @endif
                    <td>{{ $theme->name}}</td>
                    <td>{{ $theme->description}}</td>
                    @if(!$theme->is_default)
                        <td>
                            <form method="GET" action="/themes/{{ $theme->id }}/default">
                                <button type="submit" class="btn btn-warning">Set Default</button>
                            </form>
                        </td>
                    @else
                        <td>
                            <form>
                                <button type="submit" class="btn btn-warning disabled" disabled>Set Default</button>
                            </form>
                        </td>
                    @endif
                        <td>
                            <form method="GET" action="/themes/{{ $theme->id }}/edit">
                                <button type="submit" class="btn btn-warning">Edit</button>
                            </form>
                        </td>
                        <td>
                            <form method="POST" action="/themes/{{$theme->id}}">
                                {{ csrf_field() }}
                                {{ method_field('DELETE') }}
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                    @php($i++)
                @endforeach
            </table>
        </div>
    </div>
@endsection
