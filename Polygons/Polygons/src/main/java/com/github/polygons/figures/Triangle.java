package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.nobcatz.android.polygons.R;

/**
 * Created by Marta on 18/11/2013.
 */
public class Triangle extends Figure {

    public Triangle(Context context) {
        super(context);
        id=2;
    }

    public Triangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        id=2;
    }

    public Triangle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        id=2;
    }

    @Override
    public void drawFigure(Canvas canvas) {

        Point point1_draw = new Point(0,canvas.getHeight());
        Point point2_draw = new Point(canvas.getWidth() / 2, 0);
        Point point3_draw = new Point(canvas.getWidth(),canvas.getHeight());

        Path pathOutside = new Path();
        pathOutside.setFillType(Path.FillType.EVEN_ODD);
        pathOutside.moveTo(point1_draw.x,point1_draw.y);
        pathOutside.lineTo(point2_draw.x,point2_draw.y);
        pathOutside.lineTo(point3_draw.x,point3_draw.y);
        pathOutside.lineTo(point1_draw.x,point1_draw.y);
        pathOutside.close();

        canvas.drawPath(pathOutside, paint);
        paint.setColor(getResources().getColor(R.color.base3));

        point1_draw = new Point(20,canvas.getHeight()-10);
        point2_draw = new Point(canvas.getWidth() / 2, 20);
        point3_draw = new Point(canvas.getWidth()-20,canvas.getHeight()-10);

        Path pathInside = new Path();
        pathInside.setFillType(Path.FillType.EVEN_ODD);
        pathInside.moveTo(point1_draw.x,point1_draw.y);
        pathInside.lineTo(point2_draw.x,point2_draw.y);
        pathInside.lineTo(point3_draw.x,point3_draw.y);
        pathInside.lineTo(point1_draw.x,point1_draw.y);
        pathInside.close();

        canvas.drawPath(pathInside,paint);
    }
}
