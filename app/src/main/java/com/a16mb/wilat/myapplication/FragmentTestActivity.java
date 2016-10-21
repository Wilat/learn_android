package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

// TODO: Сдлеть отделюную активность для телефона, отдельную - для планшета.
public class FragmentTestActivity extends Activity implements TestSecondFragment.Listener {
    private int mode = -1;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        itemClicked(savedInstanceState.getInt("mode"), false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        if (mode == -1) itemClicked(0);
    }

    @Override
    public void itemClicked(int mode) {
        itemClicked(mode, true);
    }
    public void itemClicked(int mode, boolean addToStack) {
        // TODO: Исправить. При повороте в стек заносится лишний фрагмент.
        if (this.mode == mode) return;
        this.mode = mode;
        TestFirstFragment fragment = new TestFirstFragment();
        fragment.setMode(mode);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_first, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (addToStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("mode", mode);
    }
}