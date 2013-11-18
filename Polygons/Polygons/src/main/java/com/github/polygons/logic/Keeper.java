package com.github.polygons.logic;

/**
 * Created by Marta on 18/11/2013.
 */
public class Keeper {
    private static Keeper instance = null;

    private Keeper() {
    }

    public static Keeper getInstance() {
        if (instance == null) {
            instance = new Keeper();
        }

        return instance;
    }
}
