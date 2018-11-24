package com.example.jiaodian.frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Trucks extends ArrayList<Truck> {
    public static Trucks list;
    public static int WIDTH;
    public static int HEIGHT;
    public static int TRUCKWIDTH;
    public static int TRUCKHEIGHT;
    public static int TRUCKSTEP;
    public static Boolean onTest = false;

    public static Trucks create (int cols, int rows, float upper, float lower, int height, int width) {
        list = new Trucks();
        WIDTH = width;
        HEIGHT = height;
        float TRUCKGAP = WIDTH * 2 / 3 / cols; // x gap
        TRUCKWIDTH = WIDTH / 3 / cols; // x length
        float ROWGAP = (lower - upper) / rows / 3; // y gap
        TRUCKHEIGHT = (int) (lower - upper) / rows / 3 * 2; // y length
        float initialY = upper + ROWGAP / 2;
        boolean toLeft = true;
        for (int i = 0; i < rows; i++) {
            float initialX = 0;
            for (int j = 0; j < cols; j++) {
                list.add(new Truck((int) initialX, (int) initialY, toLeft, TRUCKWIDTH, TRUCKHEIGHT, onTest));
                initialX = initialX + TRUCKWIDTH + TRUCKGAP;
            }
            initialY = initialY + ROWGAP + TRUCKHEIGHT;
            toLeft = !toLeft;
        }
        return list;
    }

    public void updateStep(int step) {
        TRUCKSTEP = step;
    }

    public void draw (Canvas canvas, Paint paint) {
        for (Truck t : this) t.draw(canvas, paint);
    }

    public void step () {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).toLeft) {
                list.get(i).pos.x = list.get(i).pos.x - TRUCKSTEP;
                if (!list.get(i).copied && list.get(i).pos.x < 0) {
                    list.get(i).copied = true;
                    list.add(new Truck(WIDTH, list.get(i).pos.y, list.get(i).toLeft, TRUCKWIDTH, TRUCKHEIGHT, onTest));
                }
                if (list.get(i).pos.x < 0 - TRUCKWIDTH) {
                    list.remove(i);
                } else {
                    i += 1;
                }
            } else {
                list.get(i).pos.x = list.get(i).pos.x + TRUCKSTEP;
                if (!list.get(i).copied && list.get(i).pos.x + TRUCKWIDTH > WIDTH) {
                    list.get(i).copied = true;
                    list.add(new Truck(0 - TRUCKWIDTH, list.get(i).pos.y, list.get(i).toLeft, TRUCKWIDTH, TRUCKHEIGHT, onTest));
                }
                if (list.get(i).pos.x > WIDTH) {
                    list.remove(i);
                } else {
                    i += 1;
                }
            }
        }
    }
}
