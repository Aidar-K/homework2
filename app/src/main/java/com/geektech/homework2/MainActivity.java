package com.geektech.homework2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.geektech.homework2.databinding.ActivityMainBinding;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 303;
    ImageView camera, contacts, google;
    Button button;
    TextView txt312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.Camera);
        contacts = findViewById(R.id.Contacts);
        google = findViewById(R.id.Google);
        button = findViewById(R.id.button);
        button = findViewById(R.id.button);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent1);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: (+996) 558 787968"));
                startActivity(intent2);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {

            String colosseum = "The Colosseum";

            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_WEB_SEARCH);
                intent3.putExtra(SearchManager.QUERY, colosseum);
                startActivity(intent3);
            }
        });

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,ActivityTwo.class);
                 startActivityForResult(intent, REQUEST_CODE);
             }
         });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String text;

            text = data.getStringExtra("key1");
            txt312.setText(text);

        }
    }
}
