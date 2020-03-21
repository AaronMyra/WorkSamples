<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePostsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('posts', function (Blueprint $table) {
            $table->increments('id');
            $table->string('name', 100);
            $table->string('caption', 255);
            $table->string('url', 1000);
            $table->unsignedInteger('created_by');
            $table->unsignedInteger('last_modified_by')->nullable();
            $table->timestamps();
            $table->boolean('is_deleted')->default(0);
            $table->softDeletes();
            $table->unsignedInteger('deleted_by')->nullable();

            //Foreign Key Constraints
            $table->foreign('created_by')->references('id')->on('users');
            $table->foreign('last_modified_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('posts');
    }
}
