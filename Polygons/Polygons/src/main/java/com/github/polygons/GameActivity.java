package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.polygons.figures.Figure;
import com.github.polygons.logic.FigureGenerator;

public class GameActivity extends Activity {


    private Handler handler = new Handler();
    private boolean run = true;
    private int i = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        handler.postDelayed(runnable, 1000);



    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                /* do what you need to do */
            if (run) {
                placeFigures(i);
                i--;
                run = i >0;
                /* and here comes the "trick" */
                handler.postDelayed(this, 1000);
            } else {
                /* Create new Activity */
                Context context = getApplicationContext();
                CharSequence text = "NO MOAR!!";
                int duration = Toast.LENGTH_SHORT;

            }


        }
    };

    private void placeFigures(int i){
        Resources res = getResources();
        int idfigure = res.getIdentifier("view"+i, "id", getApplicationContext().getPackageName());


        View figure = findViewById(idfigure);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relative_layout_game);

        ViewGroup.LayoutParams lp = figure.getLayoutParams();
        figure.setVisibility(View.INVISIBLE);

        figure = FigureGenerator.newFigure(getApplicationContext());
        figure.setVisibility(View.VISIBLE);
        figure.setLayoutParams(lp);
            figure.setId(idfigure);
        figure.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkFigure((Figure) v);
            }
        });
        rl.addView(figure);
    }

    public void checkFigure(Figure figure) {

    }

}
