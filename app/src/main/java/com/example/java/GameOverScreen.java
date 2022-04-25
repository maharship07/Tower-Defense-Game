package com.example.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverScreen extends AppCompatActivity {
    private int money;
    private int health;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_screen);
        GameScreen gs = new GameScreen();
        if (gs.getHealth() == 0) {
            money = gs.getMoney();
            health = gs.getHealth();
            TextView healthCounter = findViewById(R.id.healthCounter);
            updateHealth(healthCounter);
            TextView moneyCounter = findViewById(R.id.moneyCounter);
            updateMoney(moneyCounter);
            Button restart = findViewById(R.id.restartButton);
            restart.setOnClickListener(l -> {
                moveToStartScreen();
            });
            Button quit = findViewById(R.id.quit);
            quit.setOnClickListener(l -> {
                finish();
                System.exit(0);
            });
        }
        Button restart = findViewById(R.id.restartButton);
        restart.setOnClickListener(l -> {
            moveToStartScreen();
        });
        Button quit = findViewById(R.id.quit);
        quit.setOnClickListener(l -> {
            finish();
            System.exit(0);
        });

    }

    @SuppressLint("SetTextI18n")
    private void updateHealth(TextView healthCounter) {
        healthCounter.setText("Health: " + health);
    }

    @SuppressLint("SetTextI18n")
    private void updateMoney(TextView moneyCounter) {
        moneyCounter.setText("Money: " + money);
    }

    public void moveToStartScreen() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
