package com.github.polygons;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Marta on 13/11/2013.
 */
public class GameActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection MagicConstant
        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_game);
    }
}
