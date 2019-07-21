package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;

/**
 * Created by AbhiAndroid
 */

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Vibrator v =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(1000);
                ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
                toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP,150);

                Intent intent=new Intent(SplashActivity.this,CameraActivity.class);
                startActivity(intent);
                finish();
            }
        },4*1000);

    }
}