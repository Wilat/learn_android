package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.ACTION_SEND;

public class SendActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }

    public void sendButtonOnClick(View view) {
        TextView subject = (TextView)findViewById(R.id.send_subject),
                message = (TextView)findViewById(R.id.send_message),
                email = (TextView)findViewById(R.id.send_email);
        String subj = subject.getText().toString(),
                mess = message.getText().toString(),
                mail = email.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, mail);
        intent.putExtra(Intent.EXTRA_SUBJECT, subj);
        intent.putExtra(Intent.EXTRA_TEXT, mess);
        Intent.createChooser(intent, "message?");
        startActivity(intent);
    }
}
