package com.example.keto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import java.util.*;


public class Plan<n, p> extends AppCompatActivity {

    //create an instance var
    LocalDate startDate;
    int currentWeight;
    int goalWeight;

    private TextView selectedWeeks;
    private TextView need;
    private TextView total;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);


        //get a reference to the text view
        selectedWeeks = (TextView) findViewById(R.id.selectedWeeks);
        need = (TextView) findViewById(R.id.need);
        total = (TextView) findViewById(R.id.total);

        Bundle bundle = getIntent().getExtras();
        int currentWeight = bundle.getInt("currentWeight");
        int startDate = bundle.getInt("startDate");
        int goalWeight = bundle.getInt("goalWeight");
        int goalDate = bundle.getInt("goalDate");

       /* // get the Intent that started this activity and extract the string from 1st activity
        Intent intent = getIntent();
        Integer currentWeight = intent.getIntExtra("currentWeight", 0);
        Integer startDate = intent.getIntExtra("startDate", 0);
        Integer goalWeight = intent.getIntExtra("goalWeight", 0);
        Integer goalDate = intent.getIntExtra("goalDate", 0);*/


        selectedWeeks.setText(String(k));
        need.setText(Integer.toString(p));
        total.setText(Integer.toString(t));


        //  }

       // LocalDate localDate1 = LocalDate.parse(Integer.toString(startDate));
      // LocalDate localDate2 = LocalDate.parse(Integer.toString(goalDate));
        // LocalDate localDate1 = LocalDate.parse(startDate);
        //LocalDate localDate2 = LocalDate.parse(goalDate);

        List<LocalDate> dates = getMondayDates(LocalDate.parse(Integer.toString(startDate)), LocalDate.parse(Integer.toString(goalDate)));
        //List<LocalDate> dates = getMondayDates(LocalDate.of(2019, Month.JULY, 31), LocalDate.of(2019, Month.NOVEMBER, 30));

        //  for (LocalDate date : dates) {
        //System.out.println(date);
        //  }

        List<Integer> weight = new ArrayList<Integer>();

        int g = currentWeight - goalWeight;
        String p = "You need " + g + " weeks to loose desired weight.";

        for (int i = currentWeight; i > goalWeight; i--) {
            weight.add(i);
            //System.out.println(i);
        }

        //  System.out.println("waga teraz" + weight);

        for (int n = 0; ((n <= weight.size()) || (n <= dates.size())); n++) {
            //if (dates.size() >= weight.size()){
            LocalDate d = dates.get(n);
            Integer w = weight.get(n);
            System.out.println("On this Monday " + d + " your weight should be " + w + "lbn");
          String  t = "On this Monday " + d + " your weight should be " + w + "lbn";
        }

    }

    private static List<LocalDate> getMondayDates(LocalDate startDate, LocalDate goalDate){
        List<LocalDate> result = new ArrayList<LocalDate>();
        for (LocalDate date = startDate; date.isBefore(goalDate); date = date.plusDays(1)){

            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.MONDAY) {

                result.add(date);
            }
        }
        //    System.out.print("Together: "+ result);
        long weeks = ChronoUnit.WEEKS.between(startDate, goalDate);
        System.out.println("You have selected " + weeks + " weeks");
        String  k = "You have selected " + weeks + " weeks";
        return result;
    }


}
