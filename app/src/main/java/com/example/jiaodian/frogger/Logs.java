package com.example.jiaodian.frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Logs extends ArrayList<Log> {
    public static Logs list;
    public static int WIDTH;
    public static int HEIGHT;
    public static int LOGWIDTH;
    public static int LOGHEIGHT;
    public static int LOGSTEP;
    public static Boolean onTest = false;

    public static Logs create (int cols, int rows, float upper, float lower, int height, int width) {
        list = new Logs();
        WIDTH = width;
        HEIGHT = height;
        float LOGGAP = WIDTH / 4 / cols; // x gap
        LOGWIDTH = WIDTH * 3 / 4 / cols; // x length
        float ROWGAP = (lower - upper) / rows / 3; // y gap
        LOGHEIGHT = (int) (lower - upper) / rows / 3 * 2; // y length
        float initialY = upper + ROWGAP / 2;
        boolean toLeft = true;
        for (int i = 0; i < rows; i++) {
            float initialX = 0;
            for (int j = 0; j < cols; j++) {
                list.add(new Log((int) initialX, (int) initialY, toLeft, LOGWIDTH, LOGHEIGHT, onTest));
                initialX = initialX + LOGWIDTH + LOGGAP;
            }
            initialY = initialY + ROWGAP + LOGHEIGHT;
            toLeft = !toLeft;
        }
        return list;
    }

    public void updateStep(int step) {
        LOGSTEP = step;
    }

    public void draw (Canvas canvas, Paint paint) {
        for (Log l : this) l.draw(canvas, paint);
    }

    public void step () {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).toLeft) {
                list.get(i).pos.x = list.get(i).pos.x - LOGSTEP;
                if (!list.get(i).copied && list.get(i).pos.x < 0) {
                    list.get(i).copied = true;
                    list.add(new Log(WIDTH, list.get(i).pos.y, list.get(i).toLeft, LOGWIDTH, LOGHEIGHT, onTest));
                }
                if (list.get(i).pos.x < 0 - LOGWIDTH) {
                    list.remove(i);
                }
                else {
                    i += 1;
                }
            } else {
                list.get(i).pos.x = list.get(i).pos.x + LOGSTEP;
                if (!list.get(i).copied && list.get(i).pos.x + Log.LOGWIDTH > WIDTH) {
                    list.get(i).copied = true;
                    list.add(new Log(0 - LOGWIDTH, list.get(i).pos.y, list.get(i).toLeft, LOGWIDTH, LOGHEIGHT, onTest));
                }
                if (list.get(i).pos.x > WIDTH) {
                    list.remove(i);
                }
                else {
                    i += 1;
                }
            }
        }
    }
}
