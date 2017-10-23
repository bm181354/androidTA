package com.example.leoto.hangmangame;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {
    private static final String MyFlag = "Hangman_Game";

    Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ, btnNew;
    private boolean[] correctInput;
    Button btnClicked;
    String btnValue;

    // this are require in heres
    Button[] btnlist;
    boolean[] alreadyClicked;
    int index;


    private String[]words = {"APPLE","SHARK","DREAM","WHITE","EAGLE"};
    private String[]hints = {"FRUIT","SEA CREATURE","SLEEP", "COLOR", "BIRD"};

    String preSelectedWord;
    String preSelectedHint;


    public ButtonsFragment() {
        // Required empty public constructor
    }
    public interface ButtonsFragmentListener {            //this is just an interface definition.
         //it could live in its own file.  placed here for convenience.
        public void sendMessageToMain(View v, String hint, String Word);
    }

    ButtonsFragmentListener BFL;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        BFL = (ButtonsFragmentListener) context;  //context is a handle to the main activity, let's bind it to our interface.
    }


    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.buttons,container,false);

        Button btnA = (Button) view.findViewById(R.id.btnA);
        Button btnB = (Button) view.findViewById(R.id.btnB);
        Button btnC = (Button) view.findViewById(R.id.btnC);
        Button btnD = (Button) view.findViewById(R.id.btnD);
        Button btnE = (Button) view.findViewById(R.id.btnE);
        Button btnF = (Button) view.findViewById(R.id.btnF);
        Button btnG = (Button) view.findViewById(R.id.btnG);
        Button btnH = (Button) view.findViewById(R.id.btnH);
        Button btnI = (Button) view.findViewById(R.id.btnI);
        Button btnJ = (Button) view.findViewById(R.id.btnJ);
        Button btnK = (Button) view.findViewById(R.id.btnK);
        Button btnL = (Button) view.findViewById(R.id.btnL);
        Button btnM = (Button) view.findViewById(R.id.btnM);
        Button btnN = (Button) view.findViewById(R.id.btnN);
        Button btnO = (Button) view.findViewById(R.id.btnO);
        Button btnP = (Button) view.findViewById(R.id.btnP);
        Button btnQ = (Button) view.findViewById(R.id.btnQ);
        Button btnR = (Button) view.findViewById(R.id.btnR);
        Button btnS = (Button) view.findViewById(R.id.btnS);
        Button btnT = (Button) view.findViewById(R.id.btnT);
        Button btnU = (Button) view.findViewById(R.id.btnU);
        Button btnV = (Button) view.findViewById(R.id.btnV);
        Button btnW = (Button) view.findViewById(R.id.btnW);
        Button btnX = (Button) view.findViewById(R.id.btnX);
        Button btnY = (Button) view.findViewById(R.id.btnY);
        Button btnZ = (Button) view.findViewById(R.id.btnZ);

        Button btnNew = (Button) view.findViewById(R.id.btnNew);

        btnA.setOnClickListener(onClickListener);
        btnB.setOnClickListener(onClickListener);
        btnC.setOnClickListener(onClickListener);
        btnD.setOnClickListener(onClickListener);
        btnE.setOnClickListener(onClickListener);
        btnF.setOnClickListener(onClickListener);
        btnG.setOnClickListener(onClickListener);
        btnH.setOnClickListener(onClickListener);
        btnI.setOnClickListener(onClickListener);
        btnJ.setOnClickListener(onClickListener);
        btnK.setOnClickListener(onClickListener);
        btnL.setOnClickListener(onClickListener);
        btnM.setOnClickListener(onClickListener);
        btnN.setOnClickListener(onClickListener);
        btnO.setOnClickListener(onClickListener);
        btnP.setOnClickListener(onClickListener);
        btnQ.setOnClickListener(onClickListener);
        btnR.setOnClickListener(onClickListener);
        btnS.setOnClickListener(onClickListener);
        btnT.setOnClickListener(onClickListener);
        btnU.setOnClickListener(onClickListener);
        btnV.setOnClickListener(onClickListener);
        btnW.setOnClickListener(onClickListener);
        btnX.setOnClickListener(onClickListener);
        btnY.setOnClickListener(onClickListener);
        btnZ.setOnClickListener(onClickListener);
        btnNew.setOnClickListener(onClickListener);

        btnlist = new Button[]{
                btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ
        };


        // uniformly pick a number between 0 - 4
        Random A = new Random();
        index = A.nextInt(5);
        preSelectedWord = words[index];
        preSelectedHint = hints[index];

        alreadyClicked = new boolean[26];
        for(int i = 0;i<26;i++){
            alreadyClicked[i] = false;
        }


        return view;
    }
    public final View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {


            preSelectedWord = words[index];
            preSelectedHint = hints[index];
            sendMessage(v, preSelectedHint, preSelectedWord);
        }
    };

    public void sendMessage(View v, String hint, String word){
        BFL.sendMessageToMain(v,hint,word);
    }

}
