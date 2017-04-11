package com.example.oluchianyabuike.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    String name;
    String suggestion;
    String item;
    ImageView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_layout);

        place = (ImageView) findViewById(R.id.icon_1);

        name = getIntent().getStringExtra("name_input");
        suggestion = getIntent().getStringExtra("suggestion");
        item = getIntent().getStringExtra("item_input");

        //Overrides existing image with suggestion and an image of the location
        if(suggestion.equalsIgnoreCase("Split")) {
            place.setImageResource(R.drawable.split_cr);
        }else if(suggestion.equalsIgnoreCase("Edinburgh")) {
            place.setImageResource(R.drawable.edin);
        }else if(suggestion.equalsIgnoreCase("Paris")) {
            place.setImageResource(R.drawable.paris);
        }else if(suggestion.equalsIgnoreCase("New York")) {
            place.setImageResource(R.drawable.nyc);
        }
        else place.setImageResource(R.drawable.icon_1);

        displaySuggestion();
    }

    //Brings user back to the starting point of the application
    public void restart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void displaySuggestion() {
        String message = "Hi " + name + " you should go to " + suggestion + "!\nAnd don't forget to bring your " + item;

        //Overrides existing message with information given by user 
        TextView place = (TextView) findViewById(R.id.exit_message);
        place.setText(message);
    }
}
