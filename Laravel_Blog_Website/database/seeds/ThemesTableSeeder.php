<?php

use Illuminate\Database\Seeder;

class ThemesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $theme_names = [
            'Cerulean',
            'Cosmo',
            'Cyborg',
            'Darkly',
            'Flatly',
            'Journal',
            'Litera',
            'Lumen',
            'LUX'
        ];
        $theme_urls = [
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cerulean/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/flatly/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/journal/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/litera/bootstrap.min.css'.
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css',
            'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css'
        ];
        $theme_descriptions = [
            'A calm blue sky',
            'An ode to Metro',
            'Jet black and electric blue',
            'Flatly in night mode',
            'Flat and modern',
            'Crisp like a new sheet of paper',
            'The medium is the message',
            'Light and shadow',
            'A touch of class'
        ];

        for ($i =0; $i < 8; $i++){
            if ($i == 0){
                DB::table('themes')->insert([
                    'name' => $theme_names[$i],
                    'url' => $theme_urls[$i],
                    'description' => $theme_descriptions[$i],
                    'is_default' => 1
                ]);
            }
            else {
                DB::table('themes')->insert([
                    'name' => $theme_names[$i],
                    'url' => $theme_urls[$i],
                    'description' => $theme_descriptions[$i]
                ]);
            }
        }
    }
}
