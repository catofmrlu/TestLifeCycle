package com.example.luxin.testactivitylife;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text;

    static String saveString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("生命周期", "onCreate");
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_intent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        text = (EditText) findViewById(R.id.et_test);

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


        saveString = text.getText().toString();
        Log.i("切换屏幕", "text为：" + saveString);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期", "onRestart");

    }

    @Override
    protected void onDestroy() {
        Log.i("生命周期", "onDestroy");

        Intent intent = new Intent(this, MyService.class);
        startService(intent);

        super.onDestroy();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){

            text.setText(saveString);

        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            text.setText(saveString);
        }
    }
}
