package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class songActivity2 extends AppCompatActivity {
    int time=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song2);
        MediaPlayer audio1,audio2,audio3;
        Button play,pause,stop;
        ProgressBar songprogress;
        LottieAnimationView roundanimatin;
        ImageView image1;
        image1=findViewById(R.id.image1);
        play=findViewById(R.id.playbtn);
        pause=findViewById(R.id.pausebtn);
        stop=findViewById(R.id.stopbtn);
        TextView currentpositiondisplay;
        TextView songdurationdisplay;
        currentpositiondisplay=findViewById(R.id.tvcurrentposition);
        songdurationdisplay=findViewById(R.id.tvsonglength);


        songprogress=findViewById(R.id.songprogressBar);



        roundanimatin=findViewById(R.id.backanim);


        Intent intent=getIntent();
        int x=intent.getIntExtra("number",0);
        audio1=MediaPlayer.create(songActivity2.this,R.raw.sampleaudio1);
        audio2=MediaPlayer.create(songActivity2.this,R.raw.sampleaudio2);
        audio3=MediaPlayer.create(songActivity2.this,R.raw.sampleaudio3);

        // making an audio database(music library)//

        ArrayList<MediaPlayer> audiodata=new ArrayList<>();
        audiodata.add(audio1);
        audiodata.add(audio2);
        audiodata.add(audio3);

        MediaPlayer newaudio=audiodata.get(x);

        int songduration= newaudio.getDuration();
        songprogress.setMax(songduration);
        long durationminutes=TimeUnit.MILLISECONDS.toMinutes(songduration);
        long durationseconds=TimeUnit.MILLISECONDS.toSeconds(songduration);
        String stringduration=Long.toString(durationminutes)+":"+Long.toString(durationseconds);
        songdurationdisplay.setText(stringduration);

        // *******************************************************//
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundanimatin.setVisibility(View.VISIBLE);
                image1.setVisibility(View.VISIBLE);
                roundanimatin.playAnimation();
                newaudio.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundanimatin.setVisibility(View.INVISIBLE);
                image1.setVisibility(View.VISIBLE);
                newaudio.pause();

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundanimatin.setVisibility(View.INVISIBLE);
                image1.setVisibility(View.VISIBLE);
                newaudio.stop();
            }

        });

        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                if(newaudio.isPlaying()) {
                    time += 100;
                    songprogress.setProgress(time);
                }
                long minutes= TimeUnit.MILLISECONDS.toMinutes(time);
                long seconds=TimeUnit.MILLISECONDS.toSeconds(time);
                String stringtime=Long.toString(minutes)+":"+Long.toString(seconds);
                currentpositiondisplay.setText(stringtime);
            }
        };
        timer.schedule(timerTask,0,100);

        if(!newaudio.isPlaying()) {
            roundanimatin.setVisibility(View.INVISIBLE);
        }






    }
}