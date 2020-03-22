package com.example.quizit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button startQuizBtn, createQuizBtn;
    private TextView nameTV, errTV;
    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errTV = findViewById(R.id.errTextView);
        startQuizBtn = findViewById(R.id.loadFileBtn);
        nameET = findViewById(R.id.nameEditText);
        nameTV = findViewById(R.id.NameTextView);
        createQuizBtn = findViewById(R.id.createQuizBtn);

        //Start quiz button
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validates users name (not empty)
                if (nameET.getText().length() != 0) {
                    try {
                        Intent intent = new Intent(MainActivity.this, Questions.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", nameET.getText().toString());
                        if (getIntent().getStringExtra("filePath") != null){
                            intent.putExtra("filePath", getIntent().getStringExtra("filePath"));
                        }
                        //Starts Question intent
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    catch (Exception e){
                        Log.e("Activity", "Error starting questions activity");
                    }
                }
                else{
                    errTV.setVisibility(View.VISIBLE);
                }
            }
        });

        //Not Implemented
        createQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateQuiz.class);
                startActivity(intent);
            }
        });
    }

    void displayToast(String message){
        int duration = Toast.LENGTH_LONG;
        Context contex = getApplicationContext();
        Toast toast = Toast.makeText(contex, message, duration);
        toast.show();
    }
}
