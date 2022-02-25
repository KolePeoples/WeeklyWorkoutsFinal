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

public class FridayWorkout extends AppCompatActivity {

    private TextView ChestTextView;
    DatabaseReference kRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference ChestRef = kRootRef.child("ChestB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday_workout);

        ChestTextView = findViewById(R.id.chestTextView);
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
            ChestRef = kRootRef.child("ChestB");
            ChestRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    ChestTextView.setText(text);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        else if (level == 2) {
            ChestRef = kRootRef.child("ChestI");
            ChestRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    ChestTextView.setText(text);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        else if (level == 3) {
            ChestRef = kRootRef.child("ChestA");
            ChestRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String text = snapshot.getValue(String.class);
                    ChestTextView.setText(text);
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

        ChestRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue(String.class);
                ChestTextView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}