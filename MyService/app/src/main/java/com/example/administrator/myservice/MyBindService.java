package com.example.administrator.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class MyBindService extends Service {

    private static final String TAG="MyBindService";

    private LocalBinder myBinder=new LocalBinder();

    public class LocalBinder extends Binder{
        MyBindService getService(){
            return MyBindService.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
