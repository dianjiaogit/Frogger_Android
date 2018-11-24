package com.example.jiaodian.frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    public static int HEIGHT;
    public static int WIDTH;
    public static float ENDLOWER; // LOG UPPER
    public static float LOGLOWER; // TRUCK UPPER
    public static float TRUCKLOWER; // START UPPER
    public static float STARTLOWER;
    public static float UNIT;

    static final int LOGROWS = 4;
    static final int LOGCOLUMNS = 3;
    static final int TRUCKROWS = 4;
    static final int TRUCKCOLUMNS = 2;

    public static int LOGSTEP;
    public static int TRUCKSTEP;

    public static Frog frog;
    private Logs logs;
    private Trucks trucks;

    private boolean frogDead;

    public Game(int h, int w) {
        HEIGHT = h;
        WIDTH = w;
        ENDLOWER = HEIGHT / 12; // LOG UPPER
        LOGLOWER = HEIGHT / 12 * 5; // TRUCK UPPER
        TRUCKLOWER = HEIGHT / 12 * 9; // START UPPER
        STARTLOWER = HEIGHT / 12 * 10;
        UNIT = HEIGHT / 12;
        frog = new Frog();
        logs = Logs.create(LOGCOLUMNS, LOGROWS, ENDLOWER, LOGLOWER, HEIGHT, WIDTH);
        trucks = Trucks.create(TRUCKCOLUMNS, TRUCKROWS, LOGLOWER, TRUCKLOWER, HEIGHT, WIDTH);
    }

    public void updateStep(int step) {
        LOGSTEP = step + 2;
        TRUCKSTEP = step;
        logs.updateStep(LOGSTEP);
        trucks.updateStep(TRUCKSTEP);
    }

    public void draw(Canvas canvas, Paint paint) {
        logs.draw(canvas, paint);
        trucks.draw(canvas, paint);
        frog.draw(canvas, paint);
    }

    public void step() {
        logs.step();
        trucks.step();
        frog.onLog(logs);
        for (Truck t : trucks) {
            if (frog.hitby(t)) {
                frogDead = true;
            }
        }
        frogDead = frogDead || frog.fallLogs(logs);
    }

    public boolean hasWon() {
        return !frogDead && frog.y < ENDLOWER;
    }

    public boolean isFrogDead() {
        return frogDead;
    }

    public static void moveUp() {
        if (frog.y - UNIT > 0) {
            frog.y -= UNIT;
        }
    }

    public static void moveDown() {
        if (frog.y + UNIT < STARTLOWER) {
            frog.y += UNIT;
        }
    }

    public static void moveLeft() {
        if (frog.x - 20 > 0) {
            frog.x -= 20;
        }
    }

    public static void moveRight() {
        if (frog.x + 20 < WIDTH) {
            frog.x += 20;
        }
    }
}
