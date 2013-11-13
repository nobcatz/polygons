package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.github.polygons.R;

/**
 * Created by Marta on 02/11/2013.
 */
public class Circle extends View {

    private Paint paint = new Paint();

    public Circle(Context context) {
        super(context);
        //This is for the bitmap
        setDrawingCacheEnabled(true);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        //This is for the bitma
        setDrawingCacheEnabled(true);
    }

    public Circle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //This is for the bitma
        setDrawingCacheEnabled(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int myColor = getResources().getColor(R.color.base3);
        paint.setColor(myColor);

        canvas.drawCircle(100, 100, 100, this.paint);

        // canvas.drawCircle(200,200,100,this.paint);
        Log.e("EEEEEEIIIIIIIII", canvas.getHeight() + " HEIGHT");
        Log.e("EEEEEEIIIIIIIII", canvas.getWidth() + " WIDTH");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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