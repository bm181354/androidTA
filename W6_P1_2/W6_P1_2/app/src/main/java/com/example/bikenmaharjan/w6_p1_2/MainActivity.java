package com.example.bikenmaharjan.w6_p1_2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends AppCompatActivity implements top_partFragment.TopPartFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void createMessage(String msg, int dr) {

        BottonPartFragment bottonFragment = (BottonPartFragment) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        bottonFragment.setFoodText(msg);
        bottonFragment.setDraw(dr);

    }
}
