package com.example.leoto.hangmangame;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


// MARK :- Done with this as well
public class hintFragment extends Fragment {


    public hintFragment() {
        // Required empty public constructor
    }
    private TextView hint;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.hint,container,false);

        hint = (TextView) view.findViewById(R.id.hint);
        return view;
    }


    public void message(String hintTxt){
        hint.setText(hintTxt);

    }

}
