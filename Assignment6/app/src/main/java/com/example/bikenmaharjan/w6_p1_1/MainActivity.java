package com.example.bikenmaharjan.w6_p1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements top_partFragment.TopPartFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void createMessage(String msg) {

        BottonPartFragment bottonFragment = (BottonPartFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottonFragment.setFoodText(msg);

    }
}
