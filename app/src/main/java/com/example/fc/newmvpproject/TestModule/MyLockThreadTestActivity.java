package com.example.fc.newmvpproject.TestModule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fc.newmvpproject.R;
import com.fc.myutilmodule.ThreadModule.MyLockThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockThreadTestActivity extends AppCompatActivity {

    MyLockThread myLockThread1;
    MyLockThread myLockThread2;
    MyLockThread myLockThread3;
    MyLockThread myLockThread4;

    Condition con1;
    Condition con2;
    Condition con3;
    Condition con4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lock lock = new ReentrantLock();


        con1 = lock.newCondition();
        con2 = lock.newCondition();
        con3 = lock.newCondition();
        con4 = lock.newCondition();

        myLockThread1 = new MyLockThread(lock,con1 ,new MyLockThread.BackgroundListener() {
            @Override
            public Object doingBackground() {
                myLockThread1.awaitThread(0);
                return null;
            }
        });

        myLockThread1.setName("11:==");
        myLockThread1.start();

        myLockThread2 = new MyLockThread(lock,con2, new MyLockThread.BackgroundListener() {
            @Override
            public Object doingBackground() {
                myLockThread2.awaitThread(0);

                return null;
            }
        });

        myLockThread2.setName("22:==");
        myLockThread2.start();

        myLockThread3 = new MyLockThread(lock,con3, new MyLockThread.BackgroundListener() {
            @Override
            public Object doingBackground() {
                myLockThread3.awaitThread(1000);
                myLockThread1.wakeUpThread();

                return null;
            }
        });

        myLockThread3.setName("33:==");
        myLockThread3.start();


        myLockThread4 = new MyLockThread(lock,con4, new MyLockThread.BackgroundListener() {
            @Override
            public Object doingBackground() {
                myLockThread4.awaitThread(3000);
                myLockThread2.wakeUpThread();

                return null;
            }
        });

        myLockThread4.setName("44:==");
        myLockThread4.start();




    }
}
