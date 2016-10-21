package com.a16mb.wilat.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// TODO: Добавить вложенную активность, являющуюся меняющим цвета кругом/квадратом.

public class TestFirstFragment extends Fragment {

    private int mMode = 0;

    public TestFirstFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mMode = savedInstanceState.getInt("mode");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle save) {
        super.onSaveInstanceState(save);
        save.putInt("mode", mMode);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        LinearLayout layout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText(FragmentData.STEST_FRAGMENTS[mMode].getDescription());
        layout.addView(textView);
        return layout;
    }

    public void setMode(int mode) {
        this.mMode = mode;
    }


}
