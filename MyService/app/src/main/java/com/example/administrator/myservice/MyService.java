package com.example.administrator.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class MyService extends Service {

    public static final String TAG="MyService";  //创建一个TAG 显示日志信息

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    /*实现以下的几个重要方法*/

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w(TAG,"in onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG,"in onstartCommand");
        Log.w(TAG,"MyService :"+this);
        String name=intent.getStringExtra("name");
        Log.w(TAG,"name:"+name);

              //START_STICKY                会重新创建intent,回调此方法，但是intent返回的是null
             //START_REDELIVER_INTENT        同上面的区别是，intent返回的不是null
           return START_NOT_STICKY;  //表示Service因为内存不足，被系统杀掉的时候。接下来的时间，即使系统足够内存也不会重新重建Service
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"onDestroy");
    }
}
