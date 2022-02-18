package com.example.java;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameScreen extends Activity {
    private int health; //Player health

    @SuppressLint("SetTextI18n")
    //Takes in health text field and sets it to current health value
    private void updateHealth(TextView healthCounter) {
        healthCounter.setText("Health: " + health);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        TextView healthCounter = findViewById(R.id.healthCounter); //Initializes health display
        Bundle extras = getIntent().getExtras(); //Pulls all variables passed from config screen
        int diff = extras.getInt("diff"); // Pulls difficulty from config screen
        switch (diff) { //initializes game parameters based on difficulty parameter
            case 0:
                health = 150; //Easy health = 150
                break;
            case 1:
                health = 100; //Normal health = 100
                break;
            case 2:
                health = 50; //Hard health = 50
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + diff);
        }
        updateHealth(healthCounter); //sets health display to starting health
    }
}