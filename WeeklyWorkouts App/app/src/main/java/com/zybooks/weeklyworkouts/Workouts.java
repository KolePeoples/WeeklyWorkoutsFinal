package com.zybooks.weeklyworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Workouts extends AppCompatActivity {

    //Initializing image views
    private ImageButton mondayButton;
    private ImageButton tuesdayButton;
    private ImageButton wednesdayButton;
    private ImageButton thursdayButton;
    private ImageButton fridayButton;
    private ImageButton saturdayButton;
    private ImageButton sundayButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

       //connecting image buttons
        mondayButton = findViewById(R.id.mondayButton);
        tuesdayButton = findViewById(R.id.tuesdayButton);
        wednesdayButton = findViewById(R.id.wednesdayButton);
        thursdayButton = findViewById(R.id.thursdayButton);
        fridayButton = findViewById(R.id.fridayButton);
        saturdayButton = findViewById(R.id.saturdayButton);
        sundayButton = findViewById(R.id.sundayButton);

        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mondayWorkout(view);
            }
        });

        tuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tuesdayWorkout(view);
            }
        });

        wednesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wednesdayWorkout(view);
            }
        });

        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thursdayWorkout(view);
            }
        });

        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fridayWorkout(view);
            }
        });

        saturdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saturdayWorkout(view);
            }
        });

        sundayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sundayWorkout(view);
            }
        });
    }

    public void mondayWorkout(View view) {
        Intent intent = new Intent(this, MondayWorkout.class);
        startActivity(intent);
    }

    public void tuesdayWorkout(View view) {
        Intent intent = new Intent(this, TuesdayWorkout.class);
        startActivity(intent);
    }

    public void wednesdayWorkout(View view) {
        Intent intent = new Intent(this, WednesdayWorkout.class);
        startActivity(intent);
    }

    public void thursdayWorkout(View view) {
        Intent intent = new Intent(this, ThursdayWorkout.class);
        startActivity(intent);
    }

    public void fridayWorkout(View view) {
        Intent intent = new Intent(this, FridayWorkout.class);
        startActivity(intent);
    }

    public void saturdayWorkout(View view) {
        Intent intent = new Intent(this, SaturdayWorkout.class);
        startActivity(intent);
    }

    public void sundayWorkout(View view) {
        Intent intent = new Intent(this, SundayWorkout.class);
        startActivity(intent);
    }

}