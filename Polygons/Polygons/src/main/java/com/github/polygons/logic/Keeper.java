package com.github.polygons.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 18/11/2013.
 */
public class Keeper {
    private static Keeper instance = null;

    private List<Integer> figuresId = new ArrayList<Integer>();

    private Keeper() {
    }

    public static Keeper getInstance() {
        if (instance == null) {
            instance = new Keeper();
        }

        return instance;
    }

    public void addFigureId(int id){
        figuresId.add(id);
    }
}
