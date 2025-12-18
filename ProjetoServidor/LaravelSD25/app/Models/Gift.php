<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Gift extends Model
{
    protected $fillable = [
        'name',
        'estimated_value',
        'spent_value',
        'user_id',
    ];
}

