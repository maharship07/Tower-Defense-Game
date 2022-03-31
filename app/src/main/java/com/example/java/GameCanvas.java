package com.example.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

// Custom View Class for use in drawing Towers using Canvas class
public class GameCanvas extends View {
    private final Bitmap tower1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.tower_1_bitmap), 150, 150, true);
    private final Bitmap tower2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.tower_2_bitmap), 150, 150, true);
    private final Bitmap tower3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.tower_3_bitmap), 150, 150, true);
    private final Bitmap enemy1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.enemy_1), 75, 75, true);
    private final Bitmap enemy2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.enemy_2), 75, 75, true);
    private final Bitmap enemy3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
            getResources(), R.drawable.enemy_3), 75, 75, true);
    private List<Integer> towerArray = new ArrayList<Integer>();
    private List<Enemy> enemyArray = new ArrayList<Enemy>();
    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                invalidate();
            }
        }, 1000);
    }
    //Draw tower at xy coordinates
    public void drawTower(int x, int y, int tower, Canvas canvas) {
        switch (tower) {
        case 1:
            canvas.drawBitmap(tower1, (float) x, (float) y, null);
            break;
        case 2:
            canvas.drawBitmap(tower2, (float) x, (float) y, null);
            break;
        case 3:
            canvas.drawBitmap(tower3, (float) x, (float) y, null);
            break;
        default:
            break;
        }
    }
    //Add new tower to drawing array
    public void addTower(int x, int y, int tower) {
        towerArray.add(x);
        towerArray.add(y);
        towerArray.add(tower);
        invalidate(); //Redraw canvas when tower is added
    }
    public void setEnemyArray(List<Enemy> enemyArray) {
        this.enemyArray = enemyArray;
        invalidate();
    }
    public List<Enemy> getEnemyArray() {
        return this.enemyArray;
    }
    public void drawEnemy(List<Enemy> enemyArray, Canvas canvas) {
        for (int i = 0; i < enemyArray.size(); i++) {
            Enemy curr = enemyArray.get(i);
            float x = curr.getxLoc();
            float y = curr.getyLoc();
            if (curr instanceof Enemy1) {
                canvas.drawBitmap(enemy1, x, y, null);
            } else if (curr instanceof Enemy2) {
                canvas.drawBitmap(enemy2, x, y, null);
            } else {
                canvas.drawBitmap(enemy3, x, y, null);
            }
            switch (curr.getPathDir()) {
            case 1:
                if ((x - 37.5) == 0 || (x - 37.5) == 900 || (x - 37.5) == 1500) {
                    curr.setPathDir(2);
                } else if ((curr.getxLoc() - 37.5) == 450 || (curr.getxLoc() - 37.5) == 1200) {
                    curr.setPathDir(3);
                }
                curr.setxLoc(x + 150);
                break;
            case 2:
                if ((y - 37.5) == 450 || ((y - 37.5) == 300 && (x - 37.5) == 1650)) {
                    curr.setPathDir(1);
                }
                curr.setyLoc(y + 150);
                break;
            case 3:
                if ((y - 37.5) == 300) {
                    curr.setPathDir(1);
                }
                curr.setyLoc(y - 150);
                break;
            default:
                break;
            }
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < towerArray.size(); i += 3) { //Draw each tower player has placed
            drawTower(towerArray.get(i), towerArray.get(i + 1), towerArray.get(i + 2), canvas);
        }
        drawEnemy(enemyArray, canvas);

    }
}

