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
    public void generateFigures(String layoutNum, int figureNum){
        Resources res = getResources();
        int idfigure = res.getIdentifier("figure_" + layoutNum + "_" + figureNum, "id", getApplicationContext().getPackageName());
        int idLayout= res.getIdentifier("linear_layout_"+layoutNum, "id", getApplicationContext().getPackageName());


        Figure figure = (Figure)findViewById(idfigure);
        LinearLayout ll = (LinearLayout)findViewById(idLayout);

        ViewGroup.LayoutParams lp = figure.getLayoutParams();
        figure.setVisibility(View.GONE);

        figure = new Oval(getApplicationContext());
        figure.setVisibility(View.VISIBLE);
        figure.setLayoutParams(lp);
        ll.addView(figure);
    }
    }
}
