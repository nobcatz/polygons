package com.github.polygons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Marta on 03/11/2013.
 */
public class Oval extends View {

    private Paint paint=new Paint();

    public Oval(Context context) {
        super(context);
        setDrawingCacheEnabled(true);
    }

    public Oval(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawingCacheEnabled(true);
    }

    public Oval(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDrawingCacheEnabled(true);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint2 = new Paint();
        paint2.setColor(Color.WHITE);
        paint2.setTextSize(10);
        paint2.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("TEST", 0, 0, paint2);

        int myColor = getResources().getColor(R.color.base3);

        paint.setColor(myColor);


        canvas.drawOval(new RectF(0,0,canvas.getWidth(),canvas.getHeight()),this.paint);

        // canvas.drawCircle(200,200,100,this.paint);
        Log.e("EEEEEEIIIIIIIII", canvas.getHeight() + " HEIGHT");
        Log.e("EEEEEEIIIIIIIII", canvas.getWidth() + " WIDTH");


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x = (int) event.getX();
        int y = (int) event.getY();

        // ignores touches on transparent background
        if (isPixelTransparent(x, y))
            return true;
            // if(isPixelColor(x,y))
            //   return false;
        else
            return super.onTouchEvent(event);
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
}
