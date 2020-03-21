<?php

namespace App\Policies;

use App\User;
use App\Theme;
use Illuminate\Auth\Access\HandlesAuthorization;

class ThemePolicy
{
    use HandlesAuthorization;

    /**
     * Determine whether the user can view the theme.
     *
     * @param  \App\User  $user
     * @param  \App\Theme  $theme
     * @return mixed
     */

    /**
     * Determine whether the user can update the theme.
     *
     * @param  \App\User  $user
     * @param  \App\Theme  $theme
     * @return mixed
     */
    public function update(User $user, Theme $theme)
    {
        return $user->isThemeAdmin();
    }

}
