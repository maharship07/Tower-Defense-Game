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
    private final Bitmap tower1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_1_bitmap), 150, 150, true);
    private final Bitmap tower2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_2_bitmap), 150, 150, true);
    private final Bitmap tower3 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
            R.drawable.tower_3_bitmap), 150, 150, true);
    List<Integer> towerArray = new ArrayList<Integer>();
    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //Draw tower at xy coordinates
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
    //Add new tower to drawing array
    public void addTower (int x, int y, int tower) {
        towerArray.add(x);
        towerArray.add(y);
        towerArray.add(tower);
        invalidate(); //Redraw canvas when tower is added
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < towerArray.size(); i+=3) { //Draw each tower player has placed
            drawTower(towerArray.get(i), towerArray.get(i+1), towerArray.get(i+2), canvas);
        }
    }
}

