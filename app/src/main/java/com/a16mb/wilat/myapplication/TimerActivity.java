package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends Activity {

    boolean start = false;
    int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        mProcess();
    }
    public void buttonStartOnClick(View view) {
        start = true;
    }
    public void buttonPauseOnClick(View view) {
        start = false;
    }
    public void buttonStopOnClick(View view) {
        start = false;
        time = 0;
    }
    private void mProcess() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run() {
                if (start) time++;
                int hours = time / 36000;
                int minutes = time % 36000 / 600 ;
                int seconds = time % 600 / 10;
                int milliseconds = time % 10;
                TextView timer = (TextView) findViewById(R.id.timerText);
                timer.setText(String.format("%dh:%dm:%ds:%dms", hours, minutes, seconds, milliseconds));
                mProcess();
            }
        }, 100);
    }
}
