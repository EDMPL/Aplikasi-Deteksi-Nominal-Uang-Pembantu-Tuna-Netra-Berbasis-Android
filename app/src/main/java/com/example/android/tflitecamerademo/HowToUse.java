package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by USER on 9/7/2019.
 */

public class HowToUse extends Activity {

    MediaPlayer instruction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);
        instruction = MediaPlayer.create(HowToUse.this, R.raw.howtouse);
        instruction.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        instruction.release();
        finish();
    }

    /**
     * Back to CameraActivity when image was clicked.
     */
    public void backToCamera(View view) {
        finish();
    }
}
