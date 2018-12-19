package com.example.fc.newmvpproject;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static Context mContext;

    protected static MyApplication  mInstance;
    public MyApplication(){
        mInstance = this;
    }
    public static MyApplication getApp() {
        if (mInstance != null && mInstance instanceof MyApplication) {
            return mInstance;
        } else {
            mInstance = new MyApplication();
            mInstance.onCreate();
            return mInstance;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

    //获取应用的data/data/....Cache目录
    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }
}