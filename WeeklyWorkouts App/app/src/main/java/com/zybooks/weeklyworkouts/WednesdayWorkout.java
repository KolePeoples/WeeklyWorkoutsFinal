package com.zybooks.weeklyworkouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WednesdayWorkout extends AppCompatActivity {

    private TextView LegsTextView;
    DatabaseReference kRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference legsRef = kRootRef.child("LegsB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday_workout);

        LegsTextView = findViewById(R.id.legsTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Determine which menu option was chosen
        if (item.getItemId() == R.id.beginner) {
            changeDifficulty(1);
            return true;
        }
        else if (item.getItemId() == R.id.intermediate) {
            changeDifficulty(2);
            return true;
        }
        else if (item.getItemId() == R.id.advanced) {
            changeDifficulty(3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeDifficulty(int level) {
        if (level == 1) {
            legsRef = kRootRef.child("LegsB");
            legsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    LegsTextView.setText(text);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        else if (level == 2) {
            legsRef = kRootRef.child("LegsI");
            legsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    LegsTextView.setText(text);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        else if (level == 3) {
            legsRef = kRootRef.child("LegsA");
            legsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    LegsTextView.setText(text);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        legsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String legsText = snapshot.getValue(String.class);
                LegsTextView.setText(legsText);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}