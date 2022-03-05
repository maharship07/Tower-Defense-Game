package com.example.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

// Custom View Class for use in drawing Towers using Canvas class
public class GameCanvas extends View {
    private Bitmap tower1 = BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_1);
    private Bitmap tower2 = BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_2);
    private Bitmap tower3 = BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_3);
    List<Integer> towerArray = new ArrayList<Integer>();
    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void drawTower(int x, int y, int tower, Canvas canvas) {
        switch(tower) {
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
        invalidate();
    }
    public void addTower (int x, int y, int tower) {
        towerArray.add(x);
        towerArray.add(y);
        towerArray.add(tower);
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < towerArray.size(); i+=3) {
            drawTower(towerArray.get(i), towerArray.get(i+1), towerArray.get(i+2), canvas);
        }
    }
}

