package com.example.upshottechonologies.firstapp;

import android.Manifest;
import android.app.Notification;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    private Button mNextScreen;
    private static final String TAG ="MainActivtiy";
    private EditText mEditText;
    private  String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:  oncreate");
        setContentView(R.layout.activity_main);
        mNextScreen = findViewById(R.id.nextScreen);
        mEditText = findViewById(R.id.editText);

        mNextScreen.setText("Next");
        mNextScreen.setEnabled(true);
        mNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = mEditText.getText().toString();
               Intent intentObject = new Intent(MainActivity.this, SecondActivity.class);
               intentObject.putExtra("Key", text);
               startActivity(intentObject);
            }
        });

    }
    @Override
    protected void onStart()
    {
        System.out.println("Onstart");
        Log.d(TAG, "onStart: OnStart()");
        super.onStart();
    }
    @Override
    protected void onResume()
    {
        System.out.println("onResume");
        Log.d(TAG, "onStart: onResume()");
        super.onResume();
    }
    @Override
    protected void onStop()
    {
        System.out.println("onStop");
        Log.d(TAG, "onStart: onStop()");
        super.onStop();
    }
    @Override
    protected void onPause()
    {
        Log.d(TAG, "onStart: onPause()");
        super.onPause();
    }
    @Override
    protected void onDestroy()
    {
        Log.d(TAG, "onStart: onDestroy()");
        super.onDestroy();
    }
    @Override
    protected void onRestart()
    {
        Log.d(TAG, "onStart: onRestart()");
        super.onRestart();
    }
}
