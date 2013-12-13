package com.github.polygons.logic;

import android.content.Context;

import com.github.polygons.figures.Figure;

/**
 * Created by Marta on 18/11/2013.
 */
public class FigureGenerator {

    private static int figuresNum = 3;

    public static Figure createChallengeFigure(Context context){
        int idRandom = (int)(Math.random() * figuresNum);

        Keeper.getInstance().addFigureId(idRandom);

        return Figure.createFigure(idRandom, context);
    }

    public static Figure newFigure(Context context){
     int idRandom = (int)(Math.random() * figuresNum);
        return Figure.createFigure(idRandom, context);
    }
}
