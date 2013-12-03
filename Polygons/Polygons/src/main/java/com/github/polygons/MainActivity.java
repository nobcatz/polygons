package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.polygons.logic.CustomAudioManager;

import com.nobcatz.polygons.R;

import com.google.analytics.tracking.android.EasyTracker;


public class MainActivity extends Activity {
    private CustomAudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection MagicConstant
        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_main);
        initializeAudioManager();

    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }


    public void newGame(View v) {
        Intent intent = new Intent(this, LevelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void initializeAudioManager() {
  //      audioManager = CustomAudioManager.getInstance(this, R.raw.background_sound);
   //     audioManager.playBackgroundMusic();
    }
}
