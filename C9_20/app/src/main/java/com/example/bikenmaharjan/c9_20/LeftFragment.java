package com.example.bikenmaharjan.c9_20;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by bikenmaharjan on 10/22/17.
 */

public class LeftFragment extends Fragment {


    private Button btn;
    private LeftFragmentInterface activityComd;

    int n = 0;
    public LeftFragment(){


    }


    public interface LeftFragmentInterface{
        public void changeState(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{

            activityComd = (LeftFragmentInterface) context;

        }catch(Exception e){
            throw new ClassCastException(context.toString());

        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.left_fragment,container,false);

         btn = (Button) view.findViewById(R.id.btn);


        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (n < 3) {
                            sendMessageToMain(n);
                            n++;
                        }
                        else{
                            n = 0;
                            sendMessageToMain(n);
                            n++;
                        }

                    }
                }


        );

        return view;
    }

    // Sending message to the main activities
    public void sendMessageToMain(int n){
        activityComd.changeState(n);
    }


}
