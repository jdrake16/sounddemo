package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    AudioManager audManager;

    public void playAudio(View view) {

        mPlayer.start();

    }

    public void pauseAudio(View view){

        mPlayer.pause();

    }

//    public void stopAudio(View view){
//
//        mPlayer.stop();
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.sq8_zero);

        audManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volControl = (SeekBar) findViewById(R.id.seekBar);
        volControl.setMax(maxVolume);
        volControl.setProgress(curVolume);



        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("seekBar value", Integer.toString(progress));

              audManager.setStreamVolume(audManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}