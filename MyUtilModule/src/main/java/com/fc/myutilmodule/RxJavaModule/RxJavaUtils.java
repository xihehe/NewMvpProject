package com.fc.myutilmodule.RxJavaModule;


import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.fc.myutilmodule.PayModule.WxPay.WxPayModle;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxAdapterView;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;
import com.jakewharton.rxbinding2.widget.RxTextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxJavaUtils {

    /**
     * 搜索
     * @param editText
     * @param observer
     */
    public static void RxTextSearch(EditText editText,Observer<CharSequence> observer){
        /*
         * 说明
         * 1. 此处采用了RxBinding：RxTextView.textChanges(name) = 对对控件数据变更进行监听（功能类似TextWatcher），需要引入依赖：compile 'com.jakewharton.rxbinding2:rxbinding:2.0.0'
         * 2. 传入EditText控件，输入字符时都会发送数据事件（此处不会马上发送，因为使用了debounce（））
         * 3. 采用skip(1)原因：跳过 第1次请求 = 初始输入框的空字符状态
         **/
        RxTextView.textChanges(editText)
                .debounce(1, TimeUnit.SECONDS).skip(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }

    /**
     * 按钮防抖
     * @param view
     * @param consumer
     */
    public static void RxClick(final View view, Consumer consumer) {
        RxView.clicks(view)
                .throttleFirst(2, TimeUnit.SECONDS)  // 才发送 2s内第1次点击按钮的事件
                .subscribe(consumer);

//        Subscription mSubscription = null;
//        mSubscription = (Subscription) Observable.create(new ObservableOnSubscribe<View>() {
//            @Override
//            public void subscribe(ObservableEmitter<View> emitter) throws Exception {
//                emitter.onNext(view);
//            }
//        })
//                .buffer(2, TimeUnit.SECONDS) // 缓存0.5s内的点击
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
//
//        return mSubscription;
    }


    /**
     * checkbox监听
     * @param checkBox
     * @param consumer
     */
    public static void RxCheckChange(CheckBox checkBox,Consumer<Boolean> consumer){
        RxCompoundButton.checkedChanges(checkBox)
                .subscribe(consumer);
    }

 
}
