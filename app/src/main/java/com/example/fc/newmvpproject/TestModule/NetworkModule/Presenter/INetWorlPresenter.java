package com.example.fc.newmvpproject.TestModule.NetworkModule.Presenter;

import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestRequest;

public interface INetWorlPresenter {


    void RequestGetUserInfo();
    void RequestOB(TestRequest testRequest);
    void RequestOBObject(TestRequest testRequest);
    void RequestOBRequestBody(TestRequest testRequest);
    void RequestOBFielMap(TestRequest testRequest);



}
