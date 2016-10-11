package com.example.administrator.myservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BindActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG="BindActivity";
    private Button mOpenService;
    private Button mCloseService;
    private MyBindService mybindService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        init();
        addAction();
    }

    private void addAction() {
        mOpenService.setOnClickListener(this);
        mCloseService.setOnClickListener(this);
    }

    private void init() {
        mOpenService= (Button) findViewById(R.id.button3);
        mCloseService= (Button) findViewById(R.id.button3);

    }
    private final ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybindService= ((MyBindService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
          mybindService=null;
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                 this.bindService(new Intent(this,MyBindService.class),conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                this.unbindService(conn);
                break;
        }
    }
}
