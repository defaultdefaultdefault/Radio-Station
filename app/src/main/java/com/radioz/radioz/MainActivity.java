package com.radioz.radioz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton facebook, whatsapp, youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}