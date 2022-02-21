package com.example.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class ConfigScreen extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        TextView diffText = findViewById(R.id.diffText);
        TextView moneyText = findViewById(R.id.starting_money);
        Button easyButton = findViewById(R.id.easyButton);
        Button normalButton = findViewById(R.id.normalButton);
        Button hardButton = findViewById(R.id.hardButton);
        EditText playerName = findViewById(R.id.playerName);
        String name = playerName.getText().toString();
        diffText.setTextColor(Color.parseColor("#fcca03"));
        AtomicInteger currDiff = new AtomicInteger(1);
        AtomicInteger currMoney = new AtomicInteger(1);
        easyButton.setOnClickListener(l -> { //Sets difficulty to easy
            currDiff.set(0);
            currMoney.set(0);
            moneyText.setText("Starting Money: 200");
            diffText.setText("Current Difficulty: Easy");
        });
        normalButton.setOnClickListener(l -> { //Sets difficulty to normal
            currDiff.set(1);
            currMoney.set(1);
            moneyText.setText("Starting Money: 150");
            diffText.setText("Current Difficulty: Normal");
        });
        hardButton.setOnClickListener(l -> { //Sets difficulty to hard
            currDiff.set(2);
            currMoney.set(2);
            moneyText.setText("Starting Money: 100");
            diffText.setText("Current Difficulty: Hard");
        });

        //have something that controls behaviour of not accepted field for name

        Button startButton = findViewById(R.id.startGame);
        startButton.setOnClickListener(l -> { //Switches to game screen and passes difficulty
            Intent i = new Intent(this, GameScreen.class);
            i.putExtra("diff", currDiff.get());
            i.putExtra("money", currMoney.get());
            startActivity(i);
            finish();
        });
    }
}