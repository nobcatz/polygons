package com.github.polygons;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.github.polygons.figures.Figure;
import com.github.polygons.logic.FigureGenerator;
import com.github.polygons.logic.Keeper;
import com.nobcatz.android.polygons.R;


/**
 * Created by Marta on 13/11/2013.
 */
public class FigureListActivity extends Activity {

    private boolean run = true;
    private int figNum = 0;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection MagicConstant
        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_figure_list);
        Keeper.getInstance().resetFigures();

        handler.postDelayed(runnable, 1000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                /* do what you need to do */
            if (run) {
                generateFigures("1", figNum + 1);
                figNum++;
                run = figNum < 3;
                /* and here comes the "trick" */
                handler.postDelayed(this, 500);
            } else {
                /* Create new Activity */
                startGameActivity();
            }


        }
    };

    private void startGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        this.finish();
    }

    public void generateFigures(String layoutNum, int figureNum) {
        Resources res = getResources();
        int idfigure = res.getIdentifier("figure_" + layoutNum + "_" + figureNum, "id", getApplicationContext().getPackageName());
        int idLayout = res.getIdentifier("linear_layout_" + layoutNum, "id", getApplicationContext().getPackageName());


        Figure figure = (Figure) findViewById(idfigure);
        LinearLayout ll = (LinearLayout) findViewById(idLayout);

        ViewGroup.LayoutParams lp = figure.getLayoutParams();
        figure.setVisibility(View.GONE);

        figure = FigureGenerator.createChallengeFigure(getApplicationContext());
        figure.setVisibility(View.VISIBLE);
        figure.setLayoutParams(lp);
        ll.addView(figure);
    }


    public void onBackPressed() {
        handler.removeCallbacks(runnable);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setPositiveButton(getResources().getString(R.string.accept), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Keeper.getInstance().reset();
                        Intent intent = new Intent(FigureListActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        FigureListActivity.this.finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        handler.postDelayed(runnable,125);
                    }
                });
        final FrameLayout frameView = new FrameLayout(this);
        builder.setView(frameView);
        final AlertDialog alertDialog = builder.create();
        LayoutInflater inflater = alertDialog.getLayoutInflater();
        inflater.inflate(R.layout.dialog_exitin, frameView);
        alertDialog.show();
    }
}
