package com.fc.myutilmodule.RxJavaModule;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fc.myutilmodule.R;
import com.fc.myutilmodule.Utils.TimeUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxCountDown {

    private static final long MAX_TIME = 59000;
    /**
     * 取消
     */
    private Disposable mDisposable;
    private Observable mObservable;
    private Observer mObserver;
    private  TextView textView;

    public RxCountDown(TextView textView) {
        this.textView = textView;
        initRxJava();
    }

    public void initRxJava() {
        /**
         * RxJava 方式实现
         */
        mObservable = Observable.interval(0, 1000, TimeUnit.MILLISECONDS)//它在指定延迟之后先发射一个零值，然后再按照指定的时间间隔发射递增的数字,设置0延迟，每隔1000毫秒发送一条数据
                .take(MAX_TIME / 1000 + 1)//设置总共发送的次数
                .map(new Function<Long, Long>() {//long 值是从0到最大，倒计时需要将值倒置
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return MAX_TIME - aLong * 1000;
                    }
                })
                .subscribeOn(Schedulers.io())//倒计时放在io线程中
                .observeOn(AndroidSchedulers.mainThread());//显示放在主线程。

        mObserver = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Long value) {
                try {
                    RxTextView.text(textView).accept(TimeUtils.getCountTimeByLong(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("TAG","onComplete");
                if (mDisposable != null) {
                    mDisposable.dispose();
                    try {
                        RxTextView.text(textView).accept("发送验证码");
                        RxTextView.textRes(textView).accept(R.drawable.circle_half_dialog_bg);
                        RxView.enabled(textView).accept(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        };
//        mObservable.subscribe(mObserver);
    }

    public void startTime(){
        if(mObservable!=null){
            if(mObserver!=null){
                mObservable.subscribe(mObserver);
                try {
                    RxView.enabled(textView).accept(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void cancelTime(){
        if (mDisposable != null) {
            mDisposable.dispose();
            try {
                RxTextView.text(textView).accept("发送验证码");
                RxView.enabled(textView).accept(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
