package com.example.keto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editTextCurrentWeight;
    private EditText editTextStartDate;
    private EditText editTextGoalWeight;
    private EditText editTextGoalDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editTextCurrentWeight = findViewById(R.id.editTextCurrentWeight);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextGoalWeight = findViewById(R.id.editTextGoalWeight);
        editTextGoalDate = findViewById(R.id.editTextGoalDate);
    }

    public void pressSubmit(View view){
        Integer currentWeight = editTextCurrentWeight.getInputType();
        Integer startDate = editTextStartDate.getInputType();
        Integer goalWeight = editTextGoalWeight.getInputType();
        Integer goalDate = editTextGoalDate.getInputType();

        Intent intent = new Intent(this, Plan.class);
        intent.putExtra("currentWeight", currentWeight);
        intent.putExtra("startDate", startDate);
        intent.putExtra("goalWeight", goalWeight);
        intent.putExtra("goalDate", goalDate);
        startActivity(intent);
    }
}
