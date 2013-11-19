package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.github.polygons.logic.Keeper;

import java.util.logging.Level;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        placeFigures();

    }



    private void placeFigures(){
        Resources res = getResources();
        for(int i=1;i<16;i++){
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
    }

    public void checkFigure(Figure figure) {
        if(Keeper.getInstance().isClickCorrect(figure.getId())){
            Keeper.getInstance().removeFirstFigure();
            figure.setVisibility(View.INVISIBLE);

        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "YOU LOST";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }

    public void newLevel() {
        Keeper.getInstance().levelUp();
        Intent intent = new Intent(this, FigureListActivity.class);
        Intent intent = new Intent(this, LevelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        this.finish();

    }

}
