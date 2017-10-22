package com.example.sse.interfragmentcommratingbar;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by bikenmaharjan on 10/21/17.
 */

public class TopFrament extends Fragment {


    private Button btnLeft;
    private Button btnRight;

    static int currDrawableIndex;
    // Interface section
    TopPartListner activityComd;
    public interface TopPartListner{

        public void messageToChange(int index);

    }
    // getting main activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{

            activityComd = (TopPartListner) context;

        }catch(Exception e){
            throw new ClassCastException(context.toString());

        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.top_fragment,container,false);

        btnLeft = (Button) view.findViewById(R.id.btnLeft);
        btnRight = (Button) view.findViewById(R.id.btnRight);

        int currDrawableIndex = 0;

        btnLeft.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // call interface method
                        if (TopFrament.currDrawableIndex == 0)
                            TopFrament.currDrawableIndex = 9 - 1;
                        else
                            TopFrament.currDrawableIndex--;
                        callChange(TopFrament.currDrawableIndex);

                    }
                }


        );

        btnRight.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // call interface
                        // n should be index of the values

                        if (TopFrament.currDrawableIndex == 9 - 1)
                            TopFrament.currDrawableIndex = 0;
                        else
                            TopFrament.currDrawableIndex++;
                        callChange(TopFrament.currDrawableIndex);


                    }
                }


        );


        return view;

    }


    // invoking inferace method through Main Activity -- activityComd
    public void callChange(int number){
        activityComd.messageToChange(number);
    }


}
