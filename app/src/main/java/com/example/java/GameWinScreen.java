package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameWinScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_win_screen);
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
    public void moveToStartScreen() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
