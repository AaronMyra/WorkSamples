@foreach($posts as $post)
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
@endforeach
