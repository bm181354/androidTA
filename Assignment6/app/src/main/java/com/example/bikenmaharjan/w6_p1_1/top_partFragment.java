package com.example.bikenmaharjan.w6_p1_1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bikenmaharjan on 10/21/17.
 */


public class top_partFragment extends Fragment{

    private TextView tvTop;
    private Button btnSend;

    private String FLAGTEXT = "TopFragment";


    // MARK :-  Interface
    TopPartFragmentListener activityComd;
    public interface TopPartFragmentListener{
        // will be implemented by middleware
        public void createMessage(String msg);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{

            activityComd = (TopPartFragmentListener) context;

        }catch(Exception e){
            throw new ClassCastException(context.toString());

        }

    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.top_part_fragment,container,false);

        tvTop = (TextView) view.findViewById(R.id.topInputText);
        btnSend = (Button) view.findViewById(R.id.btnSendMessage);


        btnSend.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        sendMessage(view);
                    }
                }
        );

        return view;
    }

    public void sendMessage(View view){
        Log.i(FLAGTEXT,"Button works fine");

        // activityComnd is MainActivity here in this context
        activityComd.createMessage(tvTop.getText().toString());

    }
}
