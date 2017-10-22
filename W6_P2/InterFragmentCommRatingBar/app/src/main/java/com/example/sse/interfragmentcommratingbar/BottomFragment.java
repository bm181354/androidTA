package com.example.sse.interfragmentcommratingbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bikenmaharjan on 10/21/17.
 */

public class BottomFragment extends Fragment {

    ArrayList<Drawable> drawables;
    RatingBar rbar;
    static ArrayList <Float> rating =  new ArrayList<Float>();
    ImageView iv;
    int state;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bottom_fragment,container,false);

        rbar = (RatingBar) view.findViewById(R.id.ratingBr);
        iv = (ImageView) view.findViewById(R.id.iv);

        // populating the arrayList
        getDrawables();
        getValues();

        ratingListener();

        return view;
    }

    //MARK: when rating is changed
    public void ratingListener(){

        rbar.setOnRatingBarChangeListener(

                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                        changeRating(v);

                    }
                }

        );


    }


    public void changePicture(int currDrawableIndex) {

        iv.setImageDrawable(drawables.get(currDrawableIndex));
        state = currDrawableIndex;

        Log.i("State: ",""+state);
        rbar.setRating(rating.get(currDrawableIndex));


    }

    public void changeRating(float newRating){

        rating.set(state,newRating);
        Log.i("Newrating: ",""+ newRating);
        Log.i("ratingArray",""+rating.get(state));


    }









    //REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources
    public void getDrawables() {
        Field[] drawablesFields = com.example.sse.interfragmentcommratingbar.R.drawable.class.getFields();
        drawables = new ArrayList<>();

        String fieldName;
        for (Field field : drawablesFields) {
            try {
                fieldName = field.getName();
                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);

                if (fieldName.startsWith("animals_"))  //only add drawable resources that have our prefix.

                    drawables.add(getResources().getDrawable(field.getInt(null)));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void getValues(){

        for (int i = 0; i<10;i++){
            float n = i % 5;
            rating.add(n);

        }



    }


}
