<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateThemesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('themes', function (Blueprint $table) {
            $table->increments('id');
            $table->string('name', 50);
            $table->string('url', 255);
            $table->string('description', 255);
            $table->boolean('is_default')->default(0);
            $table->unsignedInteger('created_by')->nullable();
            $table->unsignedInteger('last_modified_by')->nullable();
            $table->timestamps();

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
        Schema::dropIfExists('themes');
    }
}
