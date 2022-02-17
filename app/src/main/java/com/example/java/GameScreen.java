package com.example.java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {
    private int health;

    @SuppressLint("SetTextI18n")
    private void updateHealth(TextView healthCounter) {
        healthCounter.setText("Health: " + health);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        TextView healthCounter = findViewById(R.id.healthCounter);
        Bundle extras = getIntent().getExtras();
        int diff = extras.getInt("diff");
        switch (diff) {
            case 0:
                health = 150;
                break;
            case 1:
                health = 100;
                break;
            case 2:
                health = 50;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + diff);
        }
        updateHealth(healthCounter);
    }
}