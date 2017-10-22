package com.example.bikenmaharjan.c9_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LeftFragment.LeftFragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void changeState(int index) {

        RightFragment fv = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fv.lightChanged(index);

    }
}
