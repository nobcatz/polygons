package com.github.polygons;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.github.polygons.figures.Figure;
import com.github.polygons.logic.FigureGenerator;
import com.github.polygons.logic.Keeper;
import com.nobcatz.android.polygons.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Set<Integer> ids = placeChallengeFigures();

        placeFigures(ids);
    }


    private void placeFigures(Set<Integer> ids) {
        Resources res = getResources();
        for (int i = 1; i < 16; i++) {
            if (!ids.contains(i)) {
                Log.e("pitoPrueba", "NUUUUUUU" + i);
                int idfigure = res.getIdentifier("view" + i, "id", getApplicationContext().getPackageName());


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
        }
    }

    private Set<Integer> placeChallengeFigures() {
        Resources res = getResources();
        List<Integer> ids = Keeper.getInstance().getFiguresId();
        List<Figure> figures = new ArrayList<Figure>();

        for (Integer id : ids) {
            figures.add(Figure.createFigure(id, getApplicationContext()));
        }
        Iterator<Figure> iter = figures.iterator();

        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < ids.size()) {
            int i = 1 + (int) (Math.random() * (15 - 1) + 1);
            // As we're adding to a set, this will automatically do a containment check
            generated.add(i);
        }
        for (Integer id : generated) {
            int idfigure = res.getIdentifier("view" + id, "id", getApplicationContext().getPackageName());

            View figure = findViewById(idfigure);
            RelativeLayout rl = (RelativeLayout) findViewById(R.id.relative_layout_game);

            ViewGroup.LayoutParams lp = figure.getLayoutParams();
            figure.setVisibility(View.INVISIBLE);

            figure = iter.next();
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
        return generated;
    }

    public void checkFigure(Figure figure) {
        if (Keeper.getInstance().isClickCorrect(figure.getId())) {
            if (Keeper.getInstance().removeFirstFigure())
                newLevel();
            figure.setVisibility(View.INVISIBLE);

        } else {
            lostGame();

        }
    }

    public void newLevel() {
        Keeper.getInstance().levelUp();
        Intent intent = new Intent(this, LevelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        this.finish();

    }

    public void lostGame(){

    new Handler().post(new Runnable() {
        @Override
        public void run() {

            //Create an intent that will start the main activity.
            Intent mainIntent = new Intent(GameActivity.this, LostActivity.class);
            GameActivity.this.startActivity(mainIntent);

            //Finish splash activity so user cant go back to it.
            GameActivity.this.finish();

            //Apply splash exit (fade out) and main entry (fade in) animation transitions.
            overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);
        }
    });

    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setPositiveButton(getResources().getString(R.string.accept), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Keeper.getInstance().lostGame();
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        GameActivity.this.finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
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
