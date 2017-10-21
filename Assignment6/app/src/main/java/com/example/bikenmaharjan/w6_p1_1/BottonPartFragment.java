package com.example.bikenmaharjan.w6_p1_1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bikenmaharjan on 10/21/17.
 */

public class BottonPartFragment extends Fragment {

    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.botton_part_fragment,container,false);
        tv = (TextView) view.findViewById(R.id.tvMessage);
        return view;
    }


    public void setFoodText(String txt){

        tv.setText(txt);

    }

}
