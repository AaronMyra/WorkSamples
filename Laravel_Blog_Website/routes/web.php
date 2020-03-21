<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return redirect('/posts');
});

//Route::get('/', function () {
//    return view('welcome');
//});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::resource('posts', 'PostController');

Route::resource('users', 'UserController');

Route::resource('/themes', 'ThemeController');

Route::get('/themes/{theme}/default', 'ThemeController@setAsDefault');

Route::get('themes/style', 'ThemeController@setThemeStyle');

Route::resource('profiles', 'ProfileController');

Route::get('/fetchPosts', 'PostController@fetchPosts');

Route::get('/style', 'ThemeController@setStyle');

