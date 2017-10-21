package com.example.bikenmaharjan.w6_p1_2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bikenmaharjan on 10/21/17.
 */

public class BottonPartFragment extends Fragment {

    private TextView tv;
    private View view;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.botton_part_fragment,container,false);
        tv = (TextView) view.findViewById(R.id.tvMessage);

        view.setBackgroundResource(R.drawable.burger); // DEFAULT IMAGE
        return view;

    }


    // image drawable should be sent as well here
    public void setFoodText(String txt){

        tv.setText(txt);


    }

    public  void setDraw(int i){


        if (i == 1) {
            view.setBackgroundResource(R.drawable.burger);
        }
        else if (i == 2) {
            view.setBackgroundResource(R.drawable.donuts);
        }
        else if (i == 3) {
            view.setBackgroundResource(R.drawable.hotdog);
        }
        else if (i == 4) {
            view.setBackgroundResource(R.drawable.tacos);
        }
        else if (i == 0) {
            view.setBackgroundResource(R.drawable.bbq);
        }


    }

}
