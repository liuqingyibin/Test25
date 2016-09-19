package com.example.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.LocaleList;
import android.util.Log;

public class MyService extends Service {

    private final static String Tag="MyTag";
    private LocalBinder myBinder=new LocalBinder();

    public class LocalBinder extends Binder{
        MyService getService() {
            return MyService.this;
        }
    }

    public MyService() {
    }

    public double add(double number1,double number2){
        return number1+number2;
    }

    public void onCreate()
    {
        Log.v(Tag,"onCreate()");
        super.onCreate();
    }

    public int onStartCommand(Intent intent,int flags,int start){
        Log.v(Tag,"onStartCommand()");
        return super.onStartCommand(intent,flags,start);
    }

    public void onDestroy(){
        Log.v(Tag,"onDestroy()");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(Tag,"onBind()");
        return myBinder;
    }

    public boolean onUnbind(Intent intent){
        Log.v(Tag,"onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent){
        Log.v(Tag,"onRebind()");
        super.onRebind(intent);
    }
}
