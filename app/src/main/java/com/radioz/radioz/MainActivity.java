package com.radioz.radioz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton facebook, whatsapp, youtube, tiktok;

    ImageView button;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(mediaPlayer.isPlaying()){
                  handler.removeCallbacks(updater);
                  mediaPlayer.pause();
                  //button.setText("play");
                  button.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
              }
              else {
                  mediaPlayer.start();
                 // button.setText("pause");
                  button.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);

              }
            }


        });

        preparedMediaPlayer();

        facebook = (ImageButton) findViewById(R.id.facebook_button);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri facebook_link = Uri.parse("https://tr-tr.facebook.com/Galatasaray/");
                Intent intent = new Intent(Intent.ACTION_VIEW, facebook_link);
                startActivity(intent);
            }
        });

        whatsapp = (ImageButton) findViewById(R.id.whatsapp_button);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri whatsapp_link = Uri.parse("https://web.whatsapp.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, whatsapp_link);
                startActivity(intent);
            }
        });

        tiktok = (ImageButton) findViewById(R.id.tiktok_button);
        tiktok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri whatsapp_link = Uri.parse("https://www.tiktok.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, whatsapp_link);
                startActivity(intent);
            }
        });

        youtube = (ImageButton) findViewById(R.id.youtube_button);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri youtube_link = Uri.parse("https://www.youtube.com/watch?v=Ur0D4qBBwmk");
                Intent intent = new Intent(Intent.ACTION_VIEW, youtube_link);
                startActivity(intent);
            }
        });
    }

    private void preparedMediaPlayer(){

        /*mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build());*/
        try {
            //mediaPlayer.setDataSource(this, Uri.parse("http://199.180.75.118:80/stream"));
            mediaPlayer.setDataSource(this, Uri.parse("https://radyo.yayin.com.tr:6377"));
            mediaPlayer.prepare();
           // button.setText(mediaPlayer.getDuration());
        }catch (Exception exception){
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            long currentDuration = mediaPlayer.getCurrentPosition();

        }
    };

    private String milliSecondsToTimer(long milliSeconds){
        String timerString = "";
        String secondString;

        int hours = (int)(milliSeconds / (1000*60*60));
        int minutes = (int) (milliSeconds % (1000 *60*60)) / (1000*60);
        int seconds = (int) ((milliSeconds % (1000 * 60* 60)) % (1000*60) / 1000);

        if(hours > 0){
            timerString = hours + ":";
        }

        if(seconds < 10){
            secondString = "0" + seconds;
        }else {
            secondString = "" + seconds;
        }

        timerString = timerString + minutes + ":" + secondString;
        return timerString;
    }
}