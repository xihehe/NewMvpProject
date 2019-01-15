package com.example.fc.newmvpproject;

import android.content.Context;
import android.util.Log;

import com.example.fc.newmvpproject.TestModule.RePluginModule.ITestCmpl;
import com.liulishuo.filedownloader.FileDownloader;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;

public class MyApplication extends RePluginApplication {

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
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        RePlugin.App.attachBaseContext(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        FileDownloader.setupOnApplicationOnCreate(this);
        //这里必须在super.onCreate方法之后，顺序不能变

        boolean isinit = RePlugin.registerGlobalBinder("host", new ITestCmpl());

        Log.d("adillog", "onCreate: "+ isinit);
//        try {
//            SDKManager.initSDK(this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //初始化皮肤管理器
//        SkinManager.getInstance().init(this);
    }


    // ----------
    // 自定义行为
    // ----------

    /**
     * RePlugin允许提供各种“自定义”的行为，让您“无需修改源代码”，即可实现相应的功能
     */
    @Override
    protected RePluginConfig createConfig() {
        RePluginConfig c = new RePluginConfig();

        // 允许“插件使用宿主类”。默认为“关闭”
        c.setUseHostClassIfNotFound(true);

        // FIXME RePlugin默认会对安装的外置插件进行签名校验，这里先关掉，避免调试时出现签名错误
        c.setVerifySign(!BuildConfig.DEBUG);
//        // 针对“安装失败”等情况来做进一步的事件处理
////        c.setEventCallbacks(new HostEventCallbacks(this));
        // FIXME 若宿主为Release，则此处应加上您认为"合法"的插件的签名，例如，可以写上"宿主"自己的。
        // RePlugin.addCertSignature("AAAAAAAAA");
        // 在Art上，优化第一次loadDex的速度
        // c.setOptimizeArtLoadDex(true);
        return c;
    }




    public static Context getContext() {
        return mContext;
    }

    //获取应用的data/data/....Cache目录
    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }
}