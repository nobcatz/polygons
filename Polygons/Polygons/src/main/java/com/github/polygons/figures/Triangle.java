package com.github.polygons.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

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

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point1_draw.x,point1_draw.y);
        path.lineTo(point2_draw.x,point2_draw.y);
        path.lineTo(point3_draw.x,point3_draw.y);
        path.lineTo(point1_draw.x,point1_draw.y);
        path.close();

        canvas.drawPath(path, paint);
    }
}
