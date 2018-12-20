package com.example.fc.newmvpproject.CountDownModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.fc.newmvpproject.R;
import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.RxJavaModule.RxCountDown;
import com.fc.myutilmodule.RxJavaModule.RxJavaUtils;
import com.fc.myutilmodule.Utils.TimeUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SimpleCountDownActivity extends BaseToolBarActivity {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.btn_send_sms)
    Button btnSendSms;
    @BindView(R.id.btn_sms_submit)
    Button btnSmsSubmit;



    RxCountDown rxCountDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplecountdown);
        ButterKnife.bind(this);
        rxCountDown = new RxCountDown(btnSendSms);


        RxJavaUtils.RxClick(btnSendSms, new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                rxCountDown.startTime();
            }
        });
        RxJavaUtils.RxClick(btnSmsSubmit, new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                rxCountDown.cancelTime();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rxCountDown.cancelTime();
    }
}
