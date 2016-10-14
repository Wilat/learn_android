package com.a16mb.wilat.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
    }
}

class FragmentTest{
        private String name, description;
        public static final FragmentTest[] testFramgents = {
                new FragmentTest("name1", "description1"),
                new FragmentTest("name1", "description1"),
                new FragmentTest("name1", "description1"),
                new FragmentTest("name1", "description1")
        };
    private FragmentTest(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {return name;}
    public String getDescription(){return description;}
    @Override
    public String toString() {return name;}
}