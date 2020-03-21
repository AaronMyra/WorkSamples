@component('mail::message')
# User Created

New user '{{ $user->name }}' was created at {{ $user->created_at }}.

@component('mail::button', ['url' => ''])
View Profile
@endcomponent

Thanks,<br>
{{ config('app.name') }}
@endcomponent
