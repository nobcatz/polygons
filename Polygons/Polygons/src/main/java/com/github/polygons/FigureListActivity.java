package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.polygons.figures.Figure;
import com.github.polygons.figures.Oval;


/**
 * Created by Marta on 13/11/2013.
 */
public class FigureListActivity extends Activity {

    private int level = 1;
    private boolean run = true;
    private int i = 0;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection MagicConstant
        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_figure_list);

        handler.postDelayed(runnable, 1000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                /* do what you need to do */
            if (run) {
                generateFigures("1", i + 1);
                i++;
                run = i < 3;
                /* and here comes the "trick" */
                handler.postDelayed(this, 1000);
            } else {
                /* Create new Activity */
                Context context = getApplicationContext();
                CharSequence text = "NO MOAR!!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }


        }
    };

    public void generateFigures(String layoutNum, int figureNum) {
        Resources res = getResources();
        int idfigure = res.getIdentifier("figure_" + layoutNum + "_" + figureNum, "id", getApplicationContext().getPackageName());
        int idLayout = res.getIdentifier("linear_layout_" + layoutNum, "id", getApplicationContext().getPackageName());


        Figure figure = (Figure) findViewById(idfigure);
        LinearLayout ll = (LinearLayout) findViewById(idLayout);

        ViewGroup.LayoutParams lp = figure.getLayoutParams();
        figure.setVisibility(View.GONE);

        figure = new Oval(getApplicationContext());
        figure.setVisibility(View.VISIBLE);
        figure.setLayoutParams(lp);
        figure.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkFigure((Figure)v);
            }
        });
        ll.addView(figure);
    }

    public void checkFigure(Figure figure){

    }
}
