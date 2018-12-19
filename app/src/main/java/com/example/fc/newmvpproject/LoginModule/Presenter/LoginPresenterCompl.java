package com.example.fc.newmvpproject.LoginModule.Presenter;


import android.os.Handler;
import android.text.TextUtils;

import com.example.fc.newmvpproject.HttpModule.HttpUse_Login;
import com.fc.myutilmodule.HttpModule.HttpBase.BaseObserver;
import com.example.fc.newmvpproject.LoginModule.Model.LoginRequest;
import com.example.fc.newmvpproject.LoginModule.Model.LoginResult;
import com.example.fc.newmvpproject.LoginModule.View.ILoginView;
import com.example.fc.newmvpproject.Utils.ToastUtil;

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    Handler handler;

    HttpUse_Login LoginService;



    public LoginPresenterCompl(ILoginView iLoginView) {
        handler = new Handler();
        this.iLoginView = iLoginView;
        LoginService = new HttpUse_Login();
    }

    @Override
    public void doLogin(final String username,final String psw) {

        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(psw) ){
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
                    LoginService.OBLogin(username, psw, new BaseObserver<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            iLoginView.LoginResult(loginResult);
                        }

                        @Override
                        public void onFailure(int code, String message) {
                            super.onFailure(code, message);
                            iLoginView.LoginResult(null);
                        }
                    });
//                }
//            }, 200);

            return;
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    iLoginView.LoginResult(null);
                }
            }, 2000);
        }
    }

    @Override
    public void getUserInfo() {
        LoginService.GetUserInfo(new BaseObserver<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                ToastUtil.showText(loginResult.getName());
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                ToastUtil.showText("getUserInfo::"+code+" "+message);
            }
        });
    }

    @Override
    public void doLoginFielMap(String username, String psw) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(username);
        loginRequest.setUserPsw(psw);
        loginRequest.setUserPhone("4444444");
        LoginService.OBLoginFielMap(loginRequest, new BaseObserver<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                ToastUtil.showText(loginResult.getName());
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                ToastUtil.showText("doLoginFielMap::"+code+" "+message);
            }
        });

    }

    @Override
    public void doLoginObject(String username, String psw) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(username);
        loginRequest.setUserPsw(psw);
        LoginService.OBLoginObject(loginRequest, new BaseObserver<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                ToastUtil.showText(loginResult.getName());
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                ToastUtil.showText("doLoginObject::"+code+" "+message);
            }
        });
    }

    @Override
    public void CleanPsw() {
        iLoginView.cleanContent();
    }
}
