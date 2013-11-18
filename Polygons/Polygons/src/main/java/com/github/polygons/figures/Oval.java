package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.github.polygons.R;

/**
 * Created by Marta on 03/11/2013.
 */
public class Oval extends Figure {

    public Oval(Context context) {
        super(context);
        this.id = 0;
    }

    public Oval(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.id = 0;
    }

    public Oval(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.id = 0;
    }

    public void drawFigure(Canvas canvas) {
        canvas.drawOval(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), this.paint);

        paint.setColor(getResources().getColor(R.color.base3));

        canvas.drawOval(new RectF(10,10, canvas.getWidth()-10, canvas.getHeight()-10), this.paint);
    }
}
