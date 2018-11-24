package com.example.jiaodian.frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View implements Runnable{
    Game game;
    Paint paint;
    public static final int STEPDELAY = 100;
    float time = 0;
    Handler repaintHandler;
    ArrayList<GameOver> observers ;
    Boolean hasWon = false;
    String NAME;
    int WIDTH;
    int HEIGHT;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        observers = new ArrayList<>();
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, 100);
    }

    public void create() {
        game = new Game(HEIGHT, WIDTH);
    }

    public void getLevel (String s) {
        game.updateStep(Integer.parseInt(s));
    }

    public void getName (String name) {
        NAME = name;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, paint);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(20);
        canvas.drawText(String.format("%.1f", time), canvas.getWidth() - 100, 50, p);
    }

    public boolean step() {
        game.step();
        if (game.hasWon()) {
            hasWon = true;
            notifyGameOver();
            return false;
        }

        if (game.isFrogDead()) {
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }

    private void notifyGameOver() {
        for (GameOver o : observers) {
            o.gameOver();
        }
    }

    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, 100);
            time += 0.1;
        }
    }

    public void registerGameOver(GameOver gameover) {
        observers.add(gameover);
    }

    public void moveUp(){
        game.moveUp();
    }

    public void moveDown() {
        game.moveDown();
    }

    public void moveLeft() {
        game.moveLeft();
    }

    public void moveRight() {
        game.moveRight();
    }
}
