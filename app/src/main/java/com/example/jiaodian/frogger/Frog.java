package com.example.jiaodian.frogger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;

public class Frog extends Objects{
    Bitmap forg = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/character_frog.png"));
    Bitmap Goat = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/character_goat.png"));
    Bitmap Pig = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/character_pig.png"));
    public static int id = 1;
    Matrix matrix = new Matrix();
    Bitmap chart;
    public static final int radius = 10;
    public int x = Game.WIDTH / 2;
    public int y  = (int) ((Game.STARTLOWER - Game.TRUCKLOWER) / 2 + Game.TRUCKLOWER);;

    public void draw(Canvas c, Paint p) {
        p.setColor(Color.GREEN);
        //c.drawCircle(x, y, radius, p);
        if (id==1){
            float scaleWidth =(float) radius / (float) forg.getWidth();
            float scaleHeight =(float) radius / (float) forg.getHeight();
            matrix.postScale(scaleWidth,scaleHeight);
            chart = Bitmap.createScaledBitmap(forg,radius * 2, radius * 2,true);
            c.drawBitmap(chart,x - radius,y - radius,p);
        }else if (id == 2){
            float scaleWidth =(float) radius / (float) Goat.getWidth();
            float scaleHeight =(float) radius / (float) Goat.getHeight();
            matrix.postScale(scaleWidth,scaleHeight);
            chart = Bitmap.createScaledBitmap(Goat, radius * 2, radius * 2,true);
            c.drawBitmap(chart,x - radius,y - radius,p);
        } else {
            float scaleWidth =(float) radius / (float) Pig.getWidth();
            float scaleHeight =(float) radius / (float) Pig.getHeight();
            matrix.postScale(scaleWidth,scaleHeight);
            chart = Bitmap.createScaledBitmap(Pig, radius * 2, radius * 2,true);
            c.drawBitmap(chart,x - radius,y - radius,p);
        }
    }

    public boolean hitby (Truck t) {
        return (t.pos.y < y && t.pos.y + Truck.TRUCKHEIGHT > y && x - t.pos.x <= Truck.TRUCKWIDTH && t.pos.x - x <= 10);
    }

    public void onLog (Logs list) {
        for (Log l : list) {
            if (y > l.pos.y && y < l.pos.y + Log.LOGHEIGHT && x >= l.pos.x && x <= l.pos.x + Log.LOGWIDTH) {
                if (l.toLeft && x - Logs.LOGSTEP > 0) {
                    x -= Logs.LOGSTEP;
                }
                else if (!l.toLeft && x + Logs.LOGSTEP < Logs.WIDTH){
                    x += Logs.LOGSTEP;
                }
            }
        }
    }

    public boolean fallLogs (Logs list) {
        Boolean sameRow = false;
        Boolean onLogs = false;
        for (Log l : list) {
            if (y > l.pos.y && y < l.pos.y + Log.LOGHEIGHT) {
                sameRow = true;
            }
            if (y > l.pos.y && y < l.pos.y + Log.LOGHEIGHT && x >= l.pos.x && x <= l.pos.x + Log.LOGWIDTH) {
                onLogs = true;
            }
        }
        return sameRow && !onLogs;
    }
}
