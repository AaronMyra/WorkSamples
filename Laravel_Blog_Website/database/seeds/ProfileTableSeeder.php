<?php

use Illuminate\Database\Seeder;

class ProfileTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('profiles')->insert([
            'user_id' => 1,
            'pic_url' => 'https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1-744x744.jpg',
            'bio' => '',
            'birth_date' => '2019-12-07',
            'phone_number' => '902-299-0664'
        ]);
    }
}
