package com.example.leoto.hangmangame;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class imageFragment extends Fragment {


    // GOOD

    private static final String MyFlag = "Hangman_Game";

    private TextView txtInput0;
    private TextView txtInput1;
    private TextView txtInput2;
    private TextView txtInput3;
    private TextView txtInput4;

    private TextView txtDash0;
    private TextView txtDash1;
    private TextView txtDash2;
    private TextView txtDash3;
    private TextView txtDash4;

    private Button btnClicked;
    private String btnValue;
    Button[] btnlist;


    private ImageView hangman;

    //
    private int count = 0;

    private int score = 0;

    private String preSelectedWord;  ///// CHECK THIS OUTPUT

    public imageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.imgae,container,false);


        txtInput0 = (TextView)view.findViewById(R.id.txtInput0);
        txtInput1 = (TextView)view.findViewById(R.id.txtInput1);
        txtInput2 = (TextView)view.findViewById(R.id.txtInput2);
        txtInput3 = (TextView)view.findViewById(R.id.txtInput3);
        txtInput4 = (TextView)view.findViewById(R.id.txtInput4);

        txtDash0 = (TextView)view.findViewById(R.id.txtDash0);
        txtDash1 = (TextView)view.findViewById(R.id.txtDash1);
        txtDash2 = (TextView)view.findViewById(R.id.txtDash2);
        txtDash3 = (TextView)view.findViewById(R.id.txtDash3);
        txtDash4 = (TextView)view.findViewById(R.id.txtDash4);

        hangman = (ImageView) view.findViewById(R.id.hangman);


        return view;
    }


    public void logicPart(View v, String word ){


        preSelectedWord = word;
        int done_flag = 0;

        btnClicked = (Button) v;
        btnValue = btnClicked.getText().toString();

        //////////


        if (count < 6) {

            btnClicked.setClickable(false);
            btnClicked.setEnabled(false);
            btnClicked.setBackgroundColor(Color.WHITE);

            if (showCorrectInput(btnValue) != 1) {
                switch(count) {
                    case 0:
                        hangman.setImageResource(R.drawable.h1);
                        break;
                    case 1:
                        hangman.setImageResource(R.drawable.h2);
                        break;
                    case 2:
                        hangman.setImageResource(R.drawable.h3);
                        break;
                    case 3:
                        hangman.setImageResource(R.drawable.h4);
                        break;
                    case 4:
                        hangman.setImageResource(R.drawable.h5);
                        break;
                    case 5:
                        hangman.setImageResource(R.drawable.h6);
                        break;
                }
                count ++;
                Log.i(MyFlag, "count++");
                if (score == 5) {
                    done_flag = 1;
                    Toast.makeText(getActivity().getApplicationContext(), "Play Again? Hit NEW", Toast.LENGTH_SHORT).show();
                }
            }

    }
        //////////

    }

    //// image // preSelectedWord will be sent from Main Activity
    public int showCorrectInput(String x){
        int o_flag = 0;
       // Log.i(MyFlag, "preSelectedWord: " + preSelectedWord);
        if(preSelectedWord.contains(x)){
            Toast.makeText(getActivity().getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            o_flag = 1;
            for (int i = 0; i < preSelectedWord.length(); i++) {
                if (x.equals(String.valueOf(preSelectedWord.charAt(i)))) {
                    switch(i) {
                        case 0:
                            txtInput0.setText(String.valueOf(x));
                            break;
                        case 1:
                            txtInput1.setText(String.valueOf(x));
                            break;
                        case 2:
                            txtInput2.setText(String.valueOf(x));
                            break;
                        case 3:
                            txtInput3.setText(String.valueOf(x));
                            break;
                        case 4:
                            txtInput4.setText(String.valueOf(x));
                            break;
                    }
                }
            }
            score++;
            if (score == 5) {
                Toast.makeText(getActivity().getApplicationContext(), "Win!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity().getApplicationContext(), "Play Again?", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
        }
        Log.i(MyFlag, "o_flag: " + String.valueOf(o_flag));

        return o_flag;
    }

}
