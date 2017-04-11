package com.example.oluchianyabuike.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toQuiz(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        String playerName = name.getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name_input", playerName);
        startActivity(intent)
    }
}
