package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestSecondFragment extends ListFragment {
    private Listener mListener;

    public TestSecondFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mListener = (Listener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] list = new String[FragmentData.testFragments.length];
        for(int i = 0; i < list.length; i++) {
            list[i] = FragmentData.testFragments[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
        //View view = inflater.inflate(R.layout.fragment_layout, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (mListener != null) {
            mListener.itemClicked(position);
        }
    }

    interface Listener {
        void itemClicked(int mode);
    }
}
