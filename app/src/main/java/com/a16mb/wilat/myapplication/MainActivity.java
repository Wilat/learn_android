package com.a16mb.wilat.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// TODO: Перенести пункты в отдельное меню. Сделать данную активность экраном приветствия.

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        // TODO: Перенести список в отдельный класс.
        list.add("Timer");
        list.add("Send");
        list.add("Fragments");
        list.add("Fragments without add to stack");
        list.add("Error");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, list);
        getListView().setAdapter(listAdapter);
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
            case 2:
                intent = new Intent(this, FragmentTestActivity.class);
                break;
            case 3:
                intent = new Intent(this, FragmentTestNonStackActivity.class);
                break;
            default:
                intent = null;
                Toast toast = Toast.makeText(this, "Oups! Error!" + id, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
        }
        if (intent != null) startActivity(intent);
    }
}
