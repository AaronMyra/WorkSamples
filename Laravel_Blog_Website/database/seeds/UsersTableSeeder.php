<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class UsersTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $usernames = ['Aaron']; //, 'Bill', 'Greg', 'Ben', 'Matt'];
        $emails = ['w0235012@nscc.ca']; //, 'w0235012@gmail.com', 'w0235012@hotmail.com', 'w0235012@example.ca', 'w0235012@test.ca'];
        $passwords = ['inet2005'];  //, 'inet2005', 'inet2005', 'inet2005', 'inet2005'];

        for ($i=0; $i < 1; $i++) {
            DB::table('users')->insert([
                'name' => $usernames[$i],
                'email' => $emails[$i],
                'password' => bcrypt($passwords[$i]),
            ]);
        }
    }
}
