package com.example.alan.ch7_33;

import android.graphics.Point;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private String x1;
    private String x2;
    private String x3;
    private String x4;
    private String x5;
    private String x6;
    private boolean sensor = false;
    private boolean flag = true;
    RelativeLayout.LayoutParams lprams;

    private int count = 1;
    private String scoreList[] = {"","","","",""};

    private GridLayout gridl;
    //private TextView txtCard1;
    //private TextView txtCard2;
    private TextView txtCard3;
    private TextView txtCard4;
    private TextView txtCard5;
    private TextView txtScore;
    private GestureDetectorCompat A;
    private String tenList[] = {"10♠","10♣","10♦","10♥"};
    private String cardlist[] = {"A♠","2♠","3♠","4♠","5♠","6♠","7♠","8♠","9♠","10♠","J♠","Q♠","K♠","A♥","2♥","3♥","4♥","5♥","6♥","7♥","8♥","9♥","10♥","J♥","Q♥","K♥"
    ,"A♣","2♣","3♣","4♣","5♣","6♣","7♣","8♣","9♣","10♣","J♣","Q♣","K♣","A♦","2♦","3♦","4♦","5♦","6♦","7♦","8♦","9♦","10♦","J♦","Q♦","K♦"};


    Point size;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A = new GestureDetectorCompat(this, this);
        A.setOnDoubleTapListener(this);

        //
        txtCard3 = new TextView(this);
        txtCard4 = new TextView(this);
        txtCard5 = new TextView(this);

        // change this
        txtScore = (TextView)findViewById(R.id.txtScore);


        // getting layout info from the activity_main.xml file
        gridl = (GridLayout) findViewById(R.id.gl);
        lprams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        gridl.setColumnCount(2);
        gridl.setRowCount(3);


        // TEXT modification
        txtCard3.setLayoutParams(lprams);
        txtCard3.offsetTopAndBottom(10);
        txtCard3.setTextSize(52);
        txtCard3.setPadding(170,0,0,0);

        txtCard4.setLayoutParams(lprams);
        txtCard4.offsetTopAndBottom(10);
        txtCard4.setTextSize(52);
        txtCard4.setPadding(170,0,0,0);

        txtCard5.setLayoutParams(lprams);
        txtCard5.offsetTopAndBottom(10);
        txtCard5.setTextSize(52);
        txtCard5.setPadding(170,0,0,0);

        for(int i = 0; i < scoreList.length; i++){
            scoreList[i] = "0";
        }


    }

    @Override
    public  boolean onTouchEvent(MotionEvent event){
        this.A.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // TODO: DISABLE onDOUBLETAP
    @Override
    public boolean onDoubleTap(MotionEvent e) {

       //////////////////////////////
        if (flag || sensor) {
            Random n = new Random();
            int x = n.nextInt(52);
            int y = n.nextInt(52);

            x1 = cardlist[x];
            x2 = cardlist[y];

            gridl.removeAllViews();
            for (int i = 0; i < scoreList.length; i++) {
                scoreList[i] = "0";
            }

            TextView txtCard1 = new TextView(this);
            TextView txtCard2 = new TextView(this);

            txtCard1.setLayoutParams(lprams);
            txtCard1.offsetTopAndBottom(10);
            txtCard1.setTextSize(52);
            txtCard1.setPadding(170, 0, 0, 0);

            txtCard2.setLayoutParams(lprams);
            txtCard2.offsetTopAndBottom(10);
            txtCard2.setTextSize(52);
            txtCard2.setPadding(170, 0, 0, 0);

            txtCard1.setText(x1);
            txtCard2.setText(x2);

            scoreList[0] = x1;
            scoreList[1] = x2;


            // adding subview when double pressed
            gridl.addView(txtCard1, size.x / 2, 300);
            gridl.addView(txtCard2, size.x / 2, 300);

            // calculation is being done here for two numbers

            sensor = calculateScore(scoreList);
            flag = false;

        }
        return false;
        //////////////////////////


    }

    public boolean calculateScore(String[] B) {
        int r = 0;
        boolean result;


        for (int i = 0; i < B.length; i++) {
            int checker = 0;

            if (B[i].length() > 2) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("K")) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("Q")) {
                r += 10;
                checker = 1;
            }
            if (B[i].contains("J")) {
                r += 10;
                checker = 1;
            }
            if(B[i] == ""){
                checker = 1;
            }
            if(B[i].contains( "A" )){
                r += 11;
                checker = 1;
            }

            if (checker == 0) {
                r += Integer.parseInt(B[i].replaceAll("[^0-9]",""));
            }
        }
            //card2value += Integer.parseInt(x2.replace("[\\D]",""));
            // score are being set here
            String test = String.valueOf(r);
            Log.i("check11",test);

            txtScore.setText("Your Score:" + " " + test);

            int res = Integer.parseInt(test);

            if (res > 17 && res <= 21) {
                Toast.makeText(getBaseContext(), "You Win!", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if(res > 21){
                Toast.makeText(getBaseContext(), "Busted!", Toast.LENGTH_SHORT).show();
                return true;
            }

        return false;

        }



    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        return true;
    }

    // TODO: create a method that draws a card and increase the total of the card
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {

        /* FOR SINGLE TAP CODE GOES HERE */

        Log.i("Check","single tapped");
        Random n = new Random();


        if (!calculateScore(scoreList)) {

            switch (count) {
                case 1:
                    int z = n.nextInt(52);
                    x3 = cardlist[z];
                    txtCard3.setText(x3);
                    gridl.addView(txtCard3, size.x / 2, 300);
                    scoreList[2] = x2;
                    break;
                case 2:
                    int h = n.nextInt(52);
                    x4 = cardlist[h];
                    txtCard4.setText(x4);
                    gridl.addView(txtCard4, size.x / 2, 300);
                    scoreList[3] = x3;
                    break;
                case 3:

                    int q = n.nextInt(52);
                    x5 = cardlist[q];
                    txtCard5.setText(x5);
                    gridl.addView(txtCard5, size.x / 2, 300);
                    scoreList[4] = x4;
                    break;

                default:
                    count = 0;

            }
            calculateScore(scoreList);
        }
///////////////
        else{
            Toast.makeText(getBaseContext(), "SingleTap Disable!", Toast.LENGTH_SHORT).show();
        }

        if (calculateScore(scoreList)){
            flag = true;
          
            Toast.makeText(getBaseContext(), "DoubleTap To Restart!", Toast.LENGTH_SHORT).show();
            sensor = true;
        }


        count++;
        return true;
    }


    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {


        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
