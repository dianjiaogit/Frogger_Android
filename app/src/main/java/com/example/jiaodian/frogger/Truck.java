package com.example.jiaodian.frogger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Truck extends Objects {
    public static int TRUCKWIDTH;
    public static int TRUCKHEIGHT;
    Bitmap myimage;

    public Truck (int x, int y, boolean toLeft, int truckwidth, int truckheight, Boolean onTest) {
        TRUCKWIDTH = truckwidth;
        TRUCKHEIGHT = truckheight;
        this.pos = new Pos (x, y);
        this.toLeft = toLeft;
        this.copied = false;
        if (!onTest) {
            myimage = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/truck.png"));
        }
    }

    public void draw(Canvas c, Paint p) {
        Bitmap truck = Bitmap.createScaledBitmap(myimage, TRUCKWIDTH, TRUCKHEIGHT, true);
        int xc = pos.x;
        int yc = pos.y;
        c.drawBitmap(truck,xc,yc,p);
    }
}
