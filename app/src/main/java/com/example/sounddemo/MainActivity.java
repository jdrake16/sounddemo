package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;

    public void playAudio(View view) {

        mPlayer.start();

    }

    public void pauseAudio(View view){

        mPlayer.pause();

    }

    public void stopAudio(View view){

        mPlayer.stop();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.sq8_zero);


    }
}