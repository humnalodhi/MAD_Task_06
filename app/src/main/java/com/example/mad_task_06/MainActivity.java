package com.example.mad_task_06;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editURL;
    Button btnURL;

    EditText editLoc;
    Button btnLoc;

    EditText editShare;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnURL = findViewById(R.id.btn_url);
        editURL = (EditText) findViewById(R.id.edit_url);

        btnLoc = findViewById(R.id.btn_loc);
        editLoc = (EditText) findViewById(R.id.edit_loc);

        btnShare = findViewById(R.id.btn_share);
        editShare = (EditText) findViewById(R.id.edit_share);

        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_text = editURL.getText().toString();
                //Uri webpage = Uri.parse(url_text);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_text));
                startActivity(intent);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("", "Cannot handle url intent");
                }


            }
        });
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Google Maps with a location
                String location = editLoc.getText().toString();
                Uri gmIntentUri = Uri.parse("geo:0,0?q=" + location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
                startActivity(mapIntent);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Log.d("", "Cannot handle location intent");
                }
//
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create sharing intent
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareText = editShare.getText().toString();
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }
}