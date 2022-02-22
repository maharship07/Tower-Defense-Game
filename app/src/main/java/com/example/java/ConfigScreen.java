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
        Button easyButton = findViewById(R.id.easyButton);
        Button normalButton = findViewById(R.id.normalButton);
        Button hardButton = findViewById(R.id.hardButton);
        EditText playerName = findViewById(R.id.playerName);
        String name = playerName.getText().toString();
        TextView errorText = findViewById(R.id.errorText);
        AtomicInteger currDiff = new AtomicInteger(1);
        easyButton.setOnClickListener(l -> { //Sets difficulty to easy
            currDiff.set(0);
            diffText.setText("Current Difficulty: Easy");
        });
        normalButton.setOnClickListener(l -> { //Sets difficulty to normal
            currDiff.set(1);
            diffText.setText("Current Difficulty: Normal");
        });
        hardButton.setOnClickListener(l -> { //Sets difficulty to hard
            currDiff.set(2);
            diffText.setText("Current Difficulty: Hard");
        });
        Button startButton = findViewById(R.id.startGame);
        startButton.setOnClickListener(l -> { //Switches to game screen and passes difficulty
            if (playerName.getText() == null) {
                errorText.setTextColor(Color.RED);
                errorText.setText("Player name cannot be null");
            } else if (playerName.getText().length() == 0) {
                errorText.setTextColor(Color.RED);
                errorText.setText("Player name cannot be empty");
            } else {
                Intent i = new Intent(this, GameScreen.class);
                i.putExtra("diff", currDiff.get());
                startActivity(i);
                finish();
            }
        });
    }
}