package com.github.polygons;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.polygons.logic.Keeper;

import com.nobcatz.android.polygons.R;

public class LevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        startAnimations();


    }

    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                createNewActivity();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        TextView tv = (TextView) findViewById(R.id.logo);
        String level = getResources().getString(R.string.level) +"\n" + Keeper.getInstance().getLevel();
        tv.setText(level);
        tv.clearAnimation();
        tv.startAnimation(anim);


    }

    private void createNewActivity(){
        Intent intent = new Intent(this, FigureListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {/*Do nothing*/}

}
