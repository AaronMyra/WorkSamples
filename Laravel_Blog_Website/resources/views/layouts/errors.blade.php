@if ($errors->any())
    {{--    display server validation errors --}}
    <div class="notification is-danger">
        <ul>
            @foreach($errors->all() as $error)
                <li>{{ $error }}</li>
            @endforeach
        </ul>
    </div>
@endif
