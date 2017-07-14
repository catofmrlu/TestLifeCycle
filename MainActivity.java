package com.example.luxin.testactivitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("生命周期", "onCreate");
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期", "onResume");
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

        Log.i("service", "stopService");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期", "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期", "onDestroy");

        Intent intent = new Intent(this, MyService.class);
        startService(intent);


    }
}
