package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

// TODO: Реализовать как фрагмент??

public class TimerActivity extends Activity {

    private boolean mStart = false, mHide = false;
    private int mTime = 0;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mStart = savedInstanceState.getBoolean("start");
        mTime = savedInstanceState.getInt("time");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        mProcess();
    }

    @Override
    public void onStart() {
        super.onStart();
        mHide = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        mHide = true;
    }

    public void buttonStartOnClick(View view) {
        mStart = true;
    }
    public void buttonPauseOnClick(View view) {
        mStart = false;
    }
    public void buttonStopOnClick(View view) {
        mStart = false;
        mTime = 0;
    }
    private void mProcess() {
        final TextView timer = (TextView) findViewById(R.id.timerText);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            public void run() {
                if (mStart && !mHide) mTime++;
                int hours = mTime / 36000;
                int minutes = mTime % 36000 / 600 ;
                int seconds = mTime % 600 / 10;
                int milliseconds = mTime % 10;
                timer.setText(String.format("%dh:%dm:%ds:%dms", hours, minutes, seconds, milliseconds));
                handler.postDelayed(this, 100);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle save) {
        super.onSaveInstanceState(save);
        save.putBoolean("start", mStart);
        save.putInt("time", mTime);
    }
}
