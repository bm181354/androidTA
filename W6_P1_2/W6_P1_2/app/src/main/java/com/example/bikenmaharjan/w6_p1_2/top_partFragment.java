package com.example.bikenmaharjan.w6_p1_2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by bikenmaharjan on 10/21/17.
 */


public class top_partFragment extends Fragment{

    private ListView lv;
    private Button btnSend;
    private String listvalue;

    private int index;
    private String FLAGTEXT = "TopFragment";


    // MARK :-  Interface
    TopPartFragmentListener activityComd;
    public interface TopPartFragmentListener{
        // will be implemented by middleware
        public void createMessage(String msg, int dr);

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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.top_part_fragment,container,false);

        lv = (ListView) view.findViewById(R.id.lv);
        btnSend = (Button) view.findViewById(R.id.btnSendMessage);

        int [] dr = {R.drawable.bbq,R.drawable.burger,R.drawable.donuts,R.drawable.hotdog,R.drawable.tacos};

        String[] foods = {"BBQ are Good","Burgers are bad","Donuts are nasty","Hotdogs are ok","Tacos are delicioso "};

        // not get context buy activity
        ListAdapter myList = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,foods);
        lv.setAdapter(myList);

        btnSend.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {

                        // pass that X and view
                        sendMessage(view);

                    }
                }
        );


        lv.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        // deference a value into a global variable X
                        listvalue = String.valueOf(adapterView.getItemAtPosition(i)) ;
                        index = i;

                    }
                }

        );

        return view;
    }

    public void sendMessage(View view){
        Log.i(FLAGTEXT,"Button works fine");

        // activityComnd is MainActivity here in this context
        activityComd.createMessage(listvalue,index);


    }
}
