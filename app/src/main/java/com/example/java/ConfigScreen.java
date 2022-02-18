package com.example.java;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.java.R;

import java.util.concurrent.atomic.AtomicInteger;

public class ConfigScreen extends AppCompatActivity{
=======
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class ConfigScreen extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
>>>>>>> bc4910b76ec3017af9da61c5153873fe2929e322
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        TextView diffText = findViewById(R.id.diffText);
        Button easyButton = findViewById(R.id.easyButton);
        Button normalButton = findViewById(R.id.normalButton);
        Button hardButton = findViewById(R.id.hardButton);
<<<<<<< HEAD
        EditText playerName = findViewById(R.id.playerName);
        String name = playerName.getText().toString();
        AtomicInteger currDiff = new AtomicInteger(1);
        easyButton.setOnClickListener(l -> {
            currDiff.set(0);
            diffText.setText("Current Difficulty: Easy");
        });
        normalButton.setOnClickListener(l -> {
            currDiff.set(1);
            diffText.setText("Current Difficulty: Normal");
        });
        hardButton.setOnClickListener(l -> {
=======
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
>>>>>>> bc4910b76ec3017af9da61c5153873fe2929e322
            currDiff.set(2);
            diffText.setText("Current Difficulty: Hard");
        });

        Button startButton = findViewById(R.id.startGame);
<<<<<<< HEAD
        startButton.setOnClickListener(l -> {
            if (name != null && !name.trim().isEmpty() && diffText.getText().toString() != null && !diffText.getText().toString().trim().isEmpty()) {
                Intent i = new Intent(this, GameScreen.class);
                i.putExtra("diff", currDiff.get());
                startActivity(i);
                finish();
            }
=======
        startButton.setOnClickListener(l -> { //Switches to game screen and passes difficulty
            Intent i = new Intent(this, GameScreen.class);
            i.putExtra("diff", currDiff.get());
            startActivity(i);
            finish();
>>>>>>> bc4910b76ec3017af9da61c5153873fe2929e322
        });
    }
}
