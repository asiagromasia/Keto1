package com.example.keto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Plan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the Intent that started this activity and extract the string playerName
        Intent intent = getIntent();
      //  Integer currentWeight = intent.getIntExtra("currentWeight");

        setContentView(R.layout.activity_plan);
    }
    public void getsMondays(){}
}
