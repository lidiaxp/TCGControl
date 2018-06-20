package com.example.lidiaxp.tcgcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Splah extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3500;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);

        linear = (LinearLayout)findViewById(R.id.linear);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        linear.startAnimation(animation);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splah.this, campo.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
