package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentTestNonStackActivity extends Activity implements TestSecondFragment.Listener {
    private int mode = -1;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        itemClicked(savedInstanceState.getInt("mode"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        if (mode == -1) itemClicked(0);
    }

    @Override
    public void itemClicked(int mode) {
        if (this.mode == mode) return;
        this.mode = mode;
        TestFirstFragment fragment = new TestFirstFragment();
        fragment.setMode(mode);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_first, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("mode", mode);
    }
}