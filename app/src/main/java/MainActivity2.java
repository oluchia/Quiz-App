package com.example.oluchianyabuike.quizapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;

public class MainActivity2 extends AppCompatActivity{

    String finalOption;
    String playerName;
    String item;
    static String FORGOT_INPUT = "Quiz incomplete, please select value";

    RadioButton ansOption1a;
    RadioButton ansOption1b;
    RadioButton ansOption1c;
    RadioButton ansOption1d;

    RadioButton ansOption2a;
    RadioButton ansOption2b;
    RadioButton ansOption2c;
    RadioButton ansOption2d;

    CheckBox ansOption3a;
    CheckBox ansOption3b;
    CheckBox ansOption3c;
    CheckBox ansOption3d;

    RadioButton ansOption4a;
    RadioButton ansOption4b;
    RadioButton ansOption4c;
    RadioButton ansOption4d;

    EditText ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        playerName = getIntent().getStringExtra("name_input");

        ansOption1a = (RadioButton) findViewById(R.id.radio_option1a);
        ansOption1b = (RadioButton) findViewById(R.id.radio_option1b);
        ansOption1c = (RadioButton) findViewById(R.id.radio_option1c);
        ansOption1d = (RadioButton) findViewById(R.id.radio_option1d);

        ansOption2a = (RadioButton) findViewById(R.id.radio_option2a);
        ansOption2b = (RadioButton) findViewById(R.id.radio_option2b);
        ansOption2c = (RadioButton) findViewById(R.id.radio_option2c);
        ansOption2d = (RadioButton) findViewById(R.id.radio_option2d);

        ansOption3a = (CheckBox) findViewById(R.id.checkbox_option3a);
        ansOption3b = (CheckBox) findViewById(R.id.checkbox_option3b);
        ansOption3c = (CheckBox) findViewById(R.id.checkbox_option3c);
        ansOption3d = (CheckBox) findViewById(R.id.checkbox_option3d);

        ansOption4a = (RadioButton) findViewById(R.id.radio_option4a);
        ansOption4b = (RadioButton) findViewById(R.id.radio_option4b);
        ansOption4c = (RadioButton) findViewById(R.id.radio_option4c);
        ansOption4d = (RadioButton) findViewById(R.id.radio_option4d);

        ans = (EditText) findViewById(R.id.edit_query);

    }

    public void calculateSuggestion() {
        finalOption = "";

        boolean oneA = ansOption1a.isChecked();
        boolean twoA = ansOption2a.isChecked();
        boolean threeA = ansOption3a.isChecked();
        boolean fourA = ansOption4a.isChecked();

        boolean oneB = ansOption1b.isChecked();
        boolean twoB = ansOption2b.isChecked();
        boolean threeB = ansOption3b.isChecked();
        boolean fourB = ansOption4b.isChecked();

        boolean oneC = ansOption1c.isChecked();
        boolean twoC = ansOption2c.isChecked();
        boolean threeC = ansOption3c.isChecked();
        boolean fourC = ansOption4c.isChecked();

        boolean oneD = ansOption1d.isChecked();
        boolean twoD = ansOption2d.isChecked();
        boolean threeD = ansOption3d.isChecked();
        boolean fourD = ansOption4d.isChecked();

        item = ans.getText().toString();

        if(oneA && twoA && (threeA || threeD) && fourA) {
            finalOption = "Split";
        }

        if(oneB && twoB && (threeB || threeC) && fourB){
            finalOption = "Paris";

        }

        if(oneC && twoC && (threeC || threeB) && fourC){
            finalOption = "Edinburgh";

        }

        if(oneD && twoD && ((threeD && threeC) || ((threeD || threeC))) && fourD){
            finalOption = "New York";

        }

    }

    public boolean checkIfComplete() {
        RadioGroup firstGroup = (RadioGroup) findViewById(R.id.ques1_group);
        RadioGroup secondGroup = (RadioGroup) findViewById(R.id.ques2_group);
        RadioGroup fourthGroup = (RadioGroup) findViewById(R.id.ques4_group);

        if(firstGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, FORGOT_INPUT,Toast.LENGTH_SHORT).show();
            return false;
        }

        if(secondGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, FORGOT_INPUT,Toast.LENGTH_SHORT).show();
            return false;
        }

        if(fourthGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, FORGOT_INPUT,Toast.LENGTH_SHORT).show();
            return false;
        }

        calculateSuggestion();
        return true;
    }

    public void toSubmit(View view) {

       if (!checkIfComplete()) {
           return;
       }
        else {
           Intent intent = new Intent(this, MainActivity3.class);
           intent.putExtra("suggestion", finalOption);
           intent.putExtra("name_input", playerName);
           intent.putExtra("item_input", item);
           startActivity(intent);
       }

    }
}
