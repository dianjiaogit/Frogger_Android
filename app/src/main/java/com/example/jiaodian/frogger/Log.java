package com.example.jiaodian.frogger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Log extends Objects {
    public static int LOGWIDTH;
    public static int LOGHEIGHT;
    public Pos pos;
    public boolean toLeft;
    public boolean copied;
    Bitmap myimage;

    public Log (int x, int y, boolean toLeft, int logwidth, int logheight, Boolean onTest) {
        LOGWIDTH = logwidth;
        LOGHEIGHT = logheight;
        this.pos = new Pos (x, y);
        this.toLeft = toLeft;
        this.copied = false;
        if (!onTest) {
            myimage = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/log.png"));
        }
    }
    public void draw(Canvas c, Paint p) {
        Bitmap log = Bitmap.createScaledBitmap(myimage, LOGWIDTH, LOGHEIGHT, true);
        int xc = pos.x;
        int yc = pos.y;
        c.drawBitmap(log,xc,yc,p);
    }
}
