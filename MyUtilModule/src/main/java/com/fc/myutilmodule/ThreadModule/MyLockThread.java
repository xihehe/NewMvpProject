package com.fc.myutilmodule.ThreadModule;

import android.util.Log;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自带锁的Thread 线程安全
 * 并且可以配合ReentrantLock结合Condition可以代替synchronized
 */
public  class MyLockThread extends Thread {

    private Lock lock ;
    private Condition con;//休眠或者唤醒类
    private BackgroundListener backgroundListener;

    public MyLockThread(Lock lock,BackgroundListener backgroundListener) {
        super();
        this.lock = lock;
        this.backgroundListener = backgroundListener;
    }

    /**
     *
     * @param lock 锁
     * @param con  等待类
     * @param backgroundListener 执行的数据操作
     */
    public MyLockThread(Lock lock, Condition con, BackgroundListener backgroundListener) {
        super();
        this.lock = lock;
        this.con = con;
        this.backgroundListener = backgroundListener;
    }



    @Override
    public void run() {
        try {
            lock.lock();
            backgroundListener.doingBackground();
            Log.e("myThread",getName());
        }catch (Exception  e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 唤醒被await的线程
     * 如果没有被await
     */
    public void wakeUpThread(){
         if(this.con!=null){
             try {
                 lock.lock();
                 this.con.signalAll();
             }finally {
                 lock.unlock();
             }
         }
    }

    /**
     * 使线程等待
     * time 0 无限等待
     * 必须写在 重写的doingBackground 方法里面
     */
    public void awaitThread(long time){
        if(this.con!=null){
            try {
                lock.lock();
                if(time==0) {
                    this.con.await();
                }else{
                    this.con.await(time, TimeUnit.MILLISECONDS);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public interface  BackgroundListener{
         Object doingBackground();
    }

}
