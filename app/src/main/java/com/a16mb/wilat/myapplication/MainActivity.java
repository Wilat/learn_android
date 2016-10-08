package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonSendOnClick(View view) {
        Spinner changeActivity = (Spinner) findViewById(R.id.changeActivity);
        Intent intent;
        switch(changeActivity.getSelectedItemPosition()) {
            case 0:
                intent = new Intent(this, TimerActivity.class);
                break;
            case 1:
                intent = new Intent(this, SendActivity.class);
                break;
            default:
               intent = null;
        }
        if (intent != null) startActivity(intent);
    }
}
