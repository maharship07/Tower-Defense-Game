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
<<<<<<< Updated upstream
=======
        updateMoney(moneyCounter);
        tower1button.setOnClickListener(l -> {
            currentTower = 1; //Tower 1 now placeable
        });
        tower2button.setOnClickListener(l -> {
            currentTower = 2; //Tower 2 now placeable
        });
        tower3button.setOnClickListener(l -> {
            currentTower = 3; //Tower 3 now placeable
        });
        towermap.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) { //When play area is clicked
                    int x = (int) event.getX(); //Get x value of click
                    x = x - (x % 150);  // Move x value to top-left corner of nearest box
                    int y = (int) event.getY(); //Get y value of click
                    y = y - (y % 150); // Move y value to top-left corner of nearest box
                    for (int i = 0; i < towerArray.size(); i++) {
                        if (x == towerArray.get(i).getxLoc()
                                && y == towerArray.get(i).getyLoc()) {
                            currentTower = 0; //If tower exists in box, do not place tower
                        }
                    }
                    System.out.println(x);
                    System.out.println(y);
                    int pathCheck = 0;
                    if (y == 300 && (x == 0 || x == 150 || x == 300 || x == 450)) {
                        pathCheck = 1;
                    } else if (x == 450 && (y == 450 || y == 600)) {
                        pathCheck = 1;
                    } else if (y == 600 && (x == 600 || x == 750 || x == 900)) {
                        pathCheck = 1;
                    } else if (x == 900 && (y == 450 || y == 300 || y == 150)) {
                        pathCheck = 1;
                    } else if (y == 150 && (x == 1050 || x == 1200 || x == 1350)) {
                        pathCheck = 1;
                    } else if (x == 1350 && (y == 300 || y == 450 || y == 600)) {
                        pathCheck = 1;
                    } else if (y == 600 && (x == 1500 || x == 1650)) {
                        pathCheck = 1;
                    } else if (x == 1650 && (y == 450 || y == 300 || y == 150)) {
                        pathCheck = 1;
                    } else if (y == 150 && (x == 1800 || x == 1950)) {
                        pathCheck = 1;
                    } else if (x == 1950 && (y == 300 || y == 450)) {
                        pathCheck = 1;
                    } else if (x == 2100 && y == 450) {
                        pathCheck = 1;
                    }
                    System.out.println(pathCheck);
                    if (pathCheck == 0) {
                        switch (currentTower) { //View tower selected, check money, add tower if enough
                            case 1:
                                if (money >= Tower1.initCost(diff)) {
                                    System.out.println("x" + x);
                                    System.out.println("y" + y);
                                    money = money - Tower1.initCost(diff);
                                    updateMoney(moneyCounter);
                                    towermap.addTower(x, y, 1);
                                    Tower1 newTower = new Tower1(x, y);
                                    towerArray.add(newTower);
                                }
                                currentTower = 0;
                                break;
                            case 2:
                                if (money >= Tower2.initCost(diff)) {
                                    money = money - Tower2.initCost(diff);
                                    updateMoney(moneyCounter);
                                    towermap.addTower(x, y, 2);
                                    Tower2 newTower = new Tower2(x, y);
                                    towerArray.add(newTower);
                                }
                                currentTower = 0;
                                break;
                            case 3:
                                if (money >= Tower3.initCost(diff)) {
                                    money = money - Tower3.initCost(diff);
                                    updateMoney(moneyCounter);
                                    towermap.addTower(x, y, 3);
                                    Tower3 newTower = new Tower3(x, y);
                                    towerArray.add(newTower);
                                }
                                currentTower = 0;
                                break;
                            default:
                                break;
                        }
                    }
                }
                return true;
            }
        });
>>>>>>> Stashed changes
    }
}