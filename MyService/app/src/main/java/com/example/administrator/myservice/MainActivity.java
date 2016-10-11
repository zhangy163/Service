package com.example.administrator.myservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG="MainActivity";

    private Button mOpenService;
    private Button mCloseService;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addaction();
    }

    private void addaction() {
        mOpenService.setOnClickListener(this);
        mCloseService.setOnClickListener(this);
    }

    private void init() {
        mOpenService= (Button) findViewById(R.id.button);
        mCloseService= (Button) findViewById(R.id.button2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                intent=new Intent(MainActivity.this,MyService.class);
                startService(intent);
                break;
            case R.id.button2:
                intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"in Destroy");
    }
}
