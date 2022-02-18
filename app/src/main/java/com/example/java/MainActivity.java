package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


<<<<<<< HEAD
        Button startButton = findViewById(R.id.startButton);
        Button quitButton = findViewById(R.id.quitButton);
=======
        Button startButton = findViewById(R.id.button);
        Button quitButton = findViewById(R.id.button2);
>>>>>>> bc4910b76ec3017af9da61c5153873fe2929e322
        startButton.setOnClickListener(l -> { //Switches to config screen
            Intent i = new Intent(this, ConfigScreen.class);
            startActivity(i);
            finish();
        });
        quitButton.setOnClickListener(l -> { // Closes out of app
            MainActivity.this.finish();
            System.exit(0);
        });
    }
}