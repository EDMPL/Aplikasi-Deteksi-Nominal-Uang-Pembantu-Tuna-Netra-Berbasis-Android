package com.example.android.tflitecamerademo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HowToUse extends AppCompatActivity {

    MediaPlayer instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);
        instruction = MediaPlayer.create(HowToUse.this,R.raw.howtouse);
        instruction.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        instruction.release();
        finish();
    }
}
