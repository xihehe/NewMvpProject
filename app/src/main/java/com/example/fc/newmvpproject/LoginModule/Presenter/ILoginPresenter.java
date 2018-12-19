package com.example.fc.newmvpproject.LoginModule.Presenter;

public interface ILoginPresenter {

    void doLogin(String username,String psw);
    void getUserInfo();
    void doLoginFielMap(String username,String psw);
    void doLoginObject(String username,String psw);
    void CleanPsw();

}
