package com.example.upshottechonologies.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoradCastActivity extends AppCompatActivity {

    Button sendBroadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borad_cast);
        sendBroadCast = findViewById(R.id.sendBroadcast);
        sendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.upshottechonologies");
                intent.putExtra("SB", "SendBroadCast");
                sendBroadcast(intent);
            }
        });
    }
}
