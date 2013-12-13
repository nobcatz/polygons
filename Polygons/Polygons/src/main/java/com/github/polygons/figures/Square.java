package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.nobcatz.android.polygons.R;

/**
 * Created by Marta on 13/11/2013.
 */
public class Square extends Figure{


    public Square(Context context) {
        super(context);
        this.id = 1;
    }

    public Square(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.id = 0;
    }

    public Square(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.id = 0;
    }

    @Override
    public void drawFigure(Canvas canvas) {
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getWidth(), this.paint);

        paint.setColor(getResources().getColor(R.color.base3));

        canvas.drawRect(10,10, canvas.getWidth()-10, canvas.getWidth()-10, this.paint);
    }


}
