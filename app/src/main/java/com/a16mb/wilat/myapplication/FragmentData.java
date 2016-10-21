package com.a16mb.wilat.myapplication;

final class FragmentData{
    private String mName, mDescription;
    public static final FragmentData[] STEST_FRAGMENTS = {
            new FragmentData("name1", "description1"),
            new FragmentData("name2", "description2"),
            new FragmentData("name3", "description3"),
            new FragmentData("name4", "description4")
    };
    private FragmentData(String name, String description) {
        this.mName = name;
        this.mDescription = description;
    }
    public String getName() {return mName;}
    public String getDescription(){return mDescription;}
    @Override
    public String toString() {return mName;}
}