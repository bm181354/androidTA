package com.example.bikenmaharjan.c9_20;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bikenmaharjan on 10/22/17.
 */

public class RightFragment extends Fragment {

    private TextView tvLight;

    int [] light = {0,1,2};

    public RightFragment(){


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.right_fragment,container,false);
        tvLight = (TextView) view.findViewById(R.id.tvLight);

        defaultValue();
        return view;

    }

    public void lightChanged(int index){


        if (index == 2){

            tvLight.setText("Red");
            tvLight.setBackgroundColor(Color.RED);
        }
        else
        if (index == 1){

            tvLight.setText("Yellow");
            tvLight.setBackgroundColor(Color.YELLOW);
        }
        else
        if (index == 0){

            tvLight.setText("Green");
            tvLight.setBackgroundColor(Color.GREEN);
        }


    }

    private void defaultValue(){

        //
        tvLight.setText("Red");
        tvLight.setBackgroundColor(Color.RED);

    }





}
