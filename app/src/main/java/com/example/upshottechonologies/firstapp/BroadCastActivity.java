package com.example.upshottechonologies.firstapp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BroadCastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Context broadcast recieved", Toast.LENGTH_LONG).show();
            }
        };

        IntentFilter intentFilter = null;
        try {
            intentFilter = new IntentFilter("com.example.sendbraidcast", Manifest.permission.READ_SMS);
        } catch (IntentFilter.MalformedMimeTypeException e) {
            e.printStackTrace();
        }

        //IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        this.registerReceiver(br, intentFilter);
    }

}
