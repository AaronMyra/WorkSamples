<?php

namespace App;

use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Notifications\Notifiable;
use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;

class User extends Authenticatable
{
    use Notifiable;
    use SoftDeletes;
    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'name', 'email', 'password',
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token',
    ];

    /**
     * The attributes that should be cast to native types.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];
    /**
     * @var int
     */
    private $is_deleted;

    public function profile(){
        return $this->hasOne('App\Profile', 'user_id', 'id');
    }

    public function posts(){
        return $this->hasMany('App\Post', 'created_by', 'id');
    }

    public function roles(){
        return $this->belongsToMany(Role::class);
    }

    public function themes(){
        return $this->hasMany(Theme::class);
    }

    public function isPostAdmin()
    {
        foreach ($this->roles()->get() as $role)
        {
            if ($role->name == 'Post Admin')
            {
                return true;
            }
        }

        return false;
    }

    public function isUserAdmin()
    {
        foreach ($this->roles()->get() as $role)
        {
            if ($role->name == 'User Admin')
            {
                return true;
            }
        }

        return false;
    }

    public function isThemeAdmin()
    {
        foreach ($this->roles()->get() as $role)
        {
            if ($role->name == 'Theme Admin')
            {
                return true;
            }
        }

        return false;
    }
}
