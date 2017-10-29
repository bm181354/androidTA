package com.example.sse.customlistview_sse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by bikenmaharjan on 10/29/17.
 */

public class VideoActivity extends AppCompatActivity {

    private VideoView vv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_main);

        vv = (VideoView) findViewById(R.id.videoView);
        playVideo();
    }

    private void playVideo(){

        String path = "android.resource://"+getPackageName()+"/"+R.raw.kahn;
        Uri uri = Uri.parse(path);
        vv.setVideoURI(uri);

        vv.setMediaController(new MediaController(this));
        vv.requestFocus();
        vv.setZOrderOnTop(true);
        //vv.requestFocus();
        vv.setKeepScreenOn(true);
        vv.start();

    }


    public void playAgain(View v){
        playVideo();

    }




}
