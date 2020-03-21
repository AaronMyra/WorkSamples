<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Profile extends Model
{
    protected $fillable = ['user_id', 'pic_url', 'bio', 'gender', 'phone_number'];

    public function owner(){
        return $this->hasOne('App\User', 'id', 'user_id');
    }
}
