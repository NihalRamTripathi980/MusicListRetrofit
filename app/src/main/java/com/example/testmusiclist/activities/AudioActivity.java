package com.example.testmusiclist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.media.AudioManager;

import com.example.testmusiclist.R;

import java.io.IOException;


public class AudioActivity extends AppCompatActivity {

    Button playBtn, pauseBtn, forwardBtn,backwardBtn;
    MediaPlayer mediaPlayer;
    String audioUrl="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        playBtn = findViewById(R.id.idBtnPlay);
        pauseBtn = findViewById(R.id.idBtnPause);
        forwardBtn = findViewById(R.id.idBtnForward);
        backwardBtn = findViewById(R.id.idBtnBackword);


        audioUrl=getIntent().getStringExtra("audio");

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playAudio(audioUrl);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {


                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();


                    Toast.makeText(AudioActivity.this, "Audio has been paused", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(AudioActivity.this, "Audio has not played", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forwardAudio();
            }
        });

        backwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backwardAudio();
            }
        });
    }



    private void playAudio(String audioUrl) {


        mediaPlayer = new MediaPlayer();


        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        try {
            mediaPlayer.setDataSource(audioUrl);

            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
    }

    private void forwardAudio() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int forwardTime = 10000; // 10 seconds forward
            int newPosition = currentPosition + forwardTime;

            if (newPosition <= mediaPlayer.getDuration()) {
                mediaPlayer.seekTo(newPosition);
            } else {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }
    }
    private void backwardAudio() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int backwardTime = 10000; // 10 seconds backward
            int newPosition = currentPosition - backwardTime;

            if (newPosition >= 0) {
                mediaPlayer.seekTo(newPosition);
            } else {
                mediaPlayer.seekTo(0);
            }
        }
    }

}
