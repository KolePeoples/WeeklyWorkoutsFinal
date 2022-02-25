package com.zybooks.weeklyworkouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Click to start the app
    public void startClick(View view) {
        Intent intent = new Intent(this, Workouts.class);
        startActivity(intent);
    }
}