package com.github.polygons;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(getResources().getInteger(R.integer.orientation));
        setContentView(R.layout.activity_main);

    }


    public void newGame(View v) {

        Context context = getApplicationContext();
        CharSequence text = "I want a new game ^^";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
