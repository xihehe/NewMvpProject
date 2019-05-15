package com.fc.myutilmodule.ThreadModule;

import android.os.Handler;
//异步线程无锁 页面更行ui Thread
//后期更行一个backGroundListener  可以放入事件操作 TODO
//最后加入Lock模式，使得可以线程安全 以及规避内存大量泄露 TODO
public class MyThreadHandler extends Thread {

    private Handler handler;
    private Object object;
    private int what;
    private boolean isRun = false;
    private boolean isCancel = false;


    public MyThreadHandler() {
        isCancel = false;
    }

    public void setHandler(Handler handler, Object object, int what){
        this.handler = handler;
        this.object = object;
        this.what = what;
    }
    @Override
    public void run() {
        if(handler!=null) {
            android.os.Message message = android.os.Message.obtain();
            message.obj = object;
            message.what = what;
            handler.sendMessage(message);
        }

    }

    public void startTread(Handler handler, Object object, int what){
        setHandler(handler,object,what);
        if(isRun==false) {
           if(!isCancel) {
               start();
               isRun = true;
           }
        }else{
            if(!isCancel) {
                run();
            }
        }
    }

    public void CancelThread(){
        isCancel = true;
        isRun = false;
        if(handler!=null){
            handler=null;
        }
    }
}
