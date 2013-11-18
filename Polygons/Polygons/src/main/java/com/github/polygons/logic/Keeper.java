package com.github.polygons.logic;

import android.content.Intent;

import com.github.polygons.FigureListActivity;
import com.github.polygons.GameActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 18/11/2013.
 */
public class Keeper {

    private int level;
    private static Keeper instance = null;

    private List<Integer> figuresId = new ArrayList<Integer>();

    private Keeper() {
        this.level = 1;
    }

    public static Keeper getInstance() {
        if (instance == null) {
            instance = new Keeper();
        }

        return instance;
    }

    public void levelUp(){
        this.level++;
    }

    public void addFigureId(int id){
        figuresId.add(id);
    }

    public boolean isClickCorrect(int idClicking){
        return figuresId.get(0) == idClicking;
    }

    public boolean removeFirstFigure(){
        figuresId.remove(0);
        return figuresId.isEmpty();
    }

    public void resetFigures(){
        figuresId.clear();
    }


}
