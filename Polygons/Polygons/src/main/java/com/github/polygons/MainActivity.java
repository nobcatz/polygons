package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.polygons.logic.CustomAudioManager;


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


    public void newGame(View v) {
        Intent intent = new Intent(this, LevelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        this.finish();
    }

    private void initializeAudioManager() {
  //      audioManager = CustomAudioManager.getInstance(this, R.raw.background_sound);
   //     audioManager.playBackgroundMusic();
    }
}
