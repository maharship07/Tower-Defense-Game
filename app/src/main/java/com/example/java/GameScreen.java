package com.example.java;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameScreen extends Activity {
    private int health; //Player health
    private int money; //Player money

    @SuppressLint("SetTextI18n")
    //Takes in health text field and sets it to current health value
    private void updateHealth(TextView healthCounter) {
        healthCounter.setText("Health: " + health);
    }

    //Takes in money text field and sets it to current money value
    @SuppressLint("SetTextI18n")
    private void updateMoney(TextView moneyCounter) {
        moneyCounter.setText("Money: " + money);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        TextView healthCounter = findViewById(R.id.healthCounter); //Initializes health display
        TextView moneyCounter = findViewById(R.id.moneyCounter); //Initialized starting money
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

        int m = extras.getInt("money"); // Pulls money from config screen
        switch (m) { //initializes game parameters based on money parameter
            case 0:
                money = 50; //Easy money
                break;
            case 1:
                money = 100; //Normal money
                break;
            case 2:
                money = 150; //Hard money
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + m);
        }
        updateMoney(moneyCounter); //sets money display to starting money
    }
}