package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>();
        list.add("Timer");
        list.add("Send");
        list.add("Error");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, list);
        ListView thisList = getListView();
        thisList.setAdapter(listAdapter);
    }

    public void onListItemClick(ListView listView,  View itemView, int position, long id) {
        Intent intent;
        switch(position) {
            case 0:
                intent = new Intent(this, TimerActivity.class);
                break;
            case 1:
                intent = new Intent(this, SendActivity.class);
                break;
            default:
                intent = null;
                Toast toast = Toast.makeText(this, "Oups! Error!" + id, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
        }
        if (intent != null) startActivity(intent);
    }
    /*public void buttonSendOnClick(View view) {
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
    }*/
}
