<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Post extends Model
{
    use SoftDeletes;

    protected $fillable = [
        'name', 'caption', 'url', 'created_by'
    ];

    public function user(){
        return $this->belongsTo('App\User', 'created_by', 'id');
    }
}
