<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Theme extends Model
{
    protected $fillable = ['name', 'description', 'url', 'is_default'];

    public function user(){
        return $this->belongsTo(User::class);
    }
}
