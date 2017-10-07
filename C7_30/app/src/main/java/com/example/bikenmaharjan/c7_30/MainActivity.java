package com.example.bikenmaharjan.c7_30;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener,
        GestureDetector.OnGestureListener {

    private ConstraintLayout cl;
    private GestureDetectorCompat gestureDector;
    private GestureDetectorCompat gd;
    private Addition ad ;
    TextView num1,num2,tvResult;
    int n1 = 1,n2 = 1;

    private TextView tv;

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    /* DOUBLE CHECK HANDLER */
    // TODO :  Generates Random number
    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {

        Log.i("ONDOUBLETAP","CHECK");

        n1 = ad.getRandom();
        n2 = ad.getRandom();

        num1.setText(""+n1);
        num2.setText(""+n2);

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = (ConstraintLayout) findViewById(R.id.layoutScreen);
        tv = (TextView) findViewById(R.id.tvMain);
        num1 = (TextView) findViewById(R.id.tvNumOne);
        num2 = (TextView) findViewById(R.id.tvNumTwo);
        tvResult = (TextView) findViewById(R.id.tvResult);

        // instantiating the model named Addition
        ad =  new Addition();

        this.gestureDector = new GestureDetectorCompat(this,this);
        gestureDector.setOnDoubleTapListener(this);

        this.gd = new GestureDetectorCompat(this, new AnotherGesture());
        gd.setOnDoubleTapListener(new AnotherGesture());



       tv.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               gd.onTouchEvent(motionEvent);
               return true;
           }
       });

    }

    // UNNECESSARY methods /////////
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
    ////////////////


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    public class AnotherGesture implements GestureDetector.OnDoubleTapListener,
            GestureDetector.OnGestureListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }


        /////////////////// For '+' ////////////////////////////
        // TODO: CALCULATE the outcome
        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {

            Log.i("ONDOUBLETAP1","CHECK1");

            int result = ad.add(n1,n2);
            tvResult.setText(""+result);
            return true;

        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }
    }

}
