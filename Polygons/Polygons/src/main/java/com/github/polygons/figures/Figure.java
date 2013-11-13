package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.github.polygons.R;

/**
 * Created by Marta on 13/11/2013.
 */
public abstract class Figure extends View{

    protected Paint paint = new Paint();
    protected int id;

    public Figure(Context context) {
        super(context);
        setDrawingCacheEnabled(true);
    }

    public Figure(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawingCacheEnabled(true);
    }

    public Figure(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDrawingCacheEnabled(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int myColor = getResources().getColor(R.color.base3);

        paint.setColor(myColor);

        drawFigure(canvas);
    }

    public abstract void drawFigure(Canvas canvas);



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        // ignores touches on transparent background
        return isPixelTransparent(x, y) || super.onTouchEvent(event);
    }

    /**
     * @return true if pixel from (x,y) is transparent
     */
    private boolean isPixelTransparent(int x, int y) {
        Bitmap bmp = Bitmap.createBitmap(getDrawingCache());
        int color = Color.TRANSPARENT;
        try {
            color = bmp.getPixel(x, y);
        } catch (IllegalArgumentException e) {
            // x or y exceed the bitmap's bounds.
            // Reverts the View's internal state from a previously set "pressed" state.
            setPressed(false);
        }

        // Ignores touches on transparent background.
        if (color == Color.TRANSPARENT)
            return true;
        else
            return false;
    }

    public int getId(){
        return this.id;
    }
}

