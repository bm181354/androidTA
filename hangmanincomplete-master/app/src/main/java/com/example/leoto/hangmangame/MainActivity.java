package com.example.leoto.hangmangame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


// MARK :- Done with this as well

public class MainActivity extends AppCompatActivity implements ButtonsFragment.ButtonsFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }


    @Override
    public void sendMessageToMain(View v, String hint, String word) {

        // send Hint to hintFragment
        // send v and Word to imageFragment

        // parse all the logic of the game.
        imageFragment imgFrag = (imageFragment) getSupportFragmentManager().findFragmentById(R.id.imageFragment);
        imgFrag.logicPart(v,word);


        hintFragment hintFrag = (hintFragment) getSupportFragmentManager().findFragmentById(R.id.hintFragment);
        hintFrag.message(hint);


    }
}
