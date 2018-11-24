package com.example.jiaodian.frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Objects {
    Pos pos;
    Boolean toLeft;
    Boolean copied;

    public abstract void draw (Canvas c, Paint p);
}
