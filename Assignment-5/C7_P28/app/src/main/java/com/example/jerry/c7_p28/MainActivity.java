package com.example.jerry.c7_p28;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private GestureDetector detector;
    private int max_velocity=5000;
    private RelativeLayout.LayoutParams params;
    private int startX;
    private int startY;
    private int startTouchX;
    private int startTouchY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv=new TextView(this);
        tv.setBackgroundColor(0xFFFF0000);
        RelativeLayout r1=new RelativeLayout(this);
        params=new RelativeLayout.LayoutParams(100,100);
        params.leftMargin=600;
        params.topMargin=900;
        r1.addView(tv,params);
        setContentView(r1);
        GestureHandler gh= new GestureHandler();
        detector=new GestureDetector(this,gh);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                switch(action){
                    case MotionEvent.ACTION_DOWN:
                        startX=params.leftMargin;
                        startY=params.topMargin;
                        startTouchX=(int)event.getX();
                        startTouchY=(int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        params.leftMargin = startX + (int) event.getX() - startTouchX;
                        params.topMargin = startY + (int) event.getY() - startTouchY;
                        tv.setLayoutParams(params);
                        break;
                }
                detector.onTouchEvent(event);
                return true;
            }
        }
);
    }
    private class GestureHandler implements GestureDetector.OnGestureListener{
        public boolean onScroll(MotionEvent e1,MotionEvent e2, float distanceX,float distanceY) {
            return true;
        }
        public void onShowPress(MotionEvent e){}
        public boolean onDown(MotionEvent e){
            return true;
        }
        public boolean onSingleTapUp(MotionEvent e){
            return true;
        }
        public void onLongPress(MotionEvent e){}
        public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX, float velocityY){
            if(Math.abs(velocityX)>max_velocity||Math.abs(velocityY)>max_velocity){
                Random ra=new Random();
                params.leftMargin= ra.nextInt(1100);
                params.topMargin=ra.nextInt(1600);
                tv.setLayoutParams(params);
            }
            return true;

        }



    }
}
