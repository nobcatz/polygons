package com.github.polygons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.polygons.logic.CustomAudioManager;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.nobcatz.android.polygons.R;


public class MainActivity extends BaseGameActivity implements View.OnClickListener{
    private CustomAudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection MagicConstant
        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_main);
        initializeAudioManager();

     //   findViewById(R.id.button_sign_in).setOnClickListener(this);
       // findViewById(R.id.button_sign_out).setOnClickListener(this);


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

    @Override
    public void onSignInFailed() {
        showSignInButton();
    }

    @Override
    public void onSignInSucceeded() {
        showSignOutButton();
    }

    private void showSignInButton() {
       // findViewById(R.id.button_sign_in).setVisibility(View.VISIBLE);
       // findViewById(R.id.button_sign_out).setVisibility(View.GONE);
    }

    private void showSignOutButton() {
       // findViewById(R.id.button_sign_in).setVisibility(View.GONE);
       // findViewById(R.id.button_sign_out).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
/*
        switch (v.getId()) {

            case R.id.button_sign_in:
                // user wants to sign in
                beginUserInitiatedSignIn();
                break;
            case R.id.button_sign_out:
                signOut();
                break;

        } */

    }
}
