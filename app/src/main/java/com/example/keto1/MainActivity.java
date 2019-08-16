package com.example.keto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // define variables for the widgets
    private Button button;
    private EditText editTextCurrentWeight;
    private EditText editTextStartDate;
    private EditText editTextGoalWeight;
    private EditText editTextGoalDate;

   private int startDate;
   private int currentWeight;
   private int goalWeight;
   private int goalDate;

    //define the shared pref object
    private SharedPreferences savedValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to the widgets
        button = findViewById(R.id.button);
        editTextCurrentWeight = findViewById(R.id.editTextCurrentWeight);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextGoalWeight = findViewById(R.id.editTextGoalWeight);
        editTextGoalDate = findViewById(R.id.editTextGoalDate);

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    public void pressSubmit(View view){

        //set an intent to invoke in Plan from the first activity
        Intent intent = new Intent(this, Plan.class);

        //get values for the numbers to be added
        startDate = Integer.parseInt(editTextStartDate.getText().toString());
        currentWeight = Integer.parseInt(editTextCurrentWeight.getText().toString());
        goalWeight = Integer.parseInt(editTextGoalWeight.getText().toString());
        goalDate = Integer.parseInt(editTextGoalDate.getText().toString());

        //Integer currentWeight = editTextCurrentWeight.getInputType();
        //Integer startDate = editTextStartDate.getInputType();
        //Integer goalWeight = editTextGoalWeight.getInputType();
        //Integer goalDate = editTextGoalDate.getInputType();


        intent.putExtra("currentWeight", currentWeight);
        intent.putExtra("startDate", startDate);
        intent.putExtra("goalWeight", goalWeight);
        intent.putExtra("goalDate", goalDate);
        startActivity(intent);
    }
}
