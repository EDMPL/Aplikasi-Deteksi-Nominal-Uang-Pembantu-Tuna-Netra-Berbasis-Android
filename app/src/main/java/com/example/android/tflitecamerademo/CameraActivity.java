/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {

  static TextToSpeech tts;
  static SoundPool soundPool;
  static int sound1, sound2, sound3, sound4, sound5, sound6, sound7;
  //cek flashlight
  static boolean flashAvailable;
  boolean hasCameraFlash = false;
  //-----
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    System.out.println("CameraActivity FUNGSI : onCreate()");
    //jika flashlight ada
    hasCameraFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    if(hasCameraFlash) {
      flashAvailable = true;
      Toast.makeText(this,"Flashlight available!",Toast.LENGTH_LONG).show();
    }
    //-----
    tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int i) {
        tts.setLanguage(Locale.ENGLISH);
      }
    });

    AudioAttributes audioAttributes = new AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build();

    soundPool = new SoundPool.Builder()
            .setMaxStreams(7)
            .setAudioAttributes(audioAttributes)
            .build();

    sound1 = soundPool.load(getApplicationContext(), R.raw.seribu, 1);
    sound2 = soundPool.load(getApplicationContext(), R.raw.duaribu, 1);
    sound3 = soundPool.load(getApplicationContext(), R.raw.limaribu, 1);
    sound4 = soundPool.load(getApplicationContext(), R.raw.sepuluhribu, 1);
    sound5 = soundPool.load(getApplicationContext(), R.raw.duapuluhribu, 1);
    sound6 = soundPool.load(getApplicationContext(), R.raw.limapuluhribu, 1);
    sound7 = soundPool.load(getApplicationContext(), R.raw.seratusribu, 1);

    setContentView(R.layout.activity_camera);
    if (null == savedInstanceState) {
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container, Camera2BasicFragment.newInstance())
          .commit();
    }
  }

  public void openHowToUsePage(View view){
    Intent intent = new Intent(CameraActivity.this, HowToUse.class);
    startActivity(intent);
  }
}
