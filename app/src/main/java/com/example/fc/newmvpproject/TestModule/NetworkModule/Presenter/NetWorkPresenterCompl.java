package com.example.fc.newmvpproject.TestModule.NetworkModule.Presenter;

import com.example.fc.newmvpproject.TestModule.NetworkModule.Http.HttpUse_Test;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestRequest;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestResult;
import com.example.fc.newmvpproject.TestModule.NetworkModule.View.ITestNetWork;
import com.fc.myutilmodule.HttpModule.HttpBase.BaseObserver;

public class NetWorkPresenterCompl implements INetWorlPresenter{

    HttpUse_Test testService;
    ITestNetWork iTestNetWork;

    public NetWorkPresenterCompl(ITestNetWork iTestNetWork) {
        testService = new HttpUse_Test();
        this.iTestNetWork = iTestNetWork;
    }


    @Override
    public void RequestGetUserInfo() {
        testService.RequestGetUserInfo(new BaseObserver<TestResult>() {
            @Override
            public void onSuccess(TestResult testResult) {
                iTestNetWork.Request_Result(testResult);
            }
            @Override
            public void onFailure(int code, String message) {

                super.onFailure(code, message);
                iTestNetWork.Request_fail("code::"+code + "\n"+ " msg::" +  message);
            }
       }
        );
    }

    @Override
    public void RequestOB(TestRequest testRequest) {
        testService.RequestOB(testRequest.getUserName(), testRequest.getUserPsw(), new BaseObserver<TestResult>() {
            @Override
            public void onSuccess(TestResult testResult) {
                iTestNetWork.Request_Result(testResult);
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                iTestNetWork.Request_fail("code::"+code + "\n"+ " msg::" +  message);
            }
        });
    }

    @Override
    public void RequestOBObject(TestRequest testRequest) {
        testService.RequestOBObject(testRequest, new BaseObserver<TestResult>() {
            @Override
            public void onSuccess(TestResult testResult) {
                iTestNetWork.Request_Result(testResult);
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                iTestNetWork.Request_fail("code::"+code + "\n"+ " msg::" +  message);
            }
        });
    }

    @Override
    public void RequestOBRequestBody(TestRequest testRequest) {
        testService.RequestOBRequestBody(testRequest, new BaseObserver<TestResult>() {
            @Override
            public void onSuccess(TestResult testResult) {
                iTestNetWork.Request_Result(testResult);
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                iTestNetWork.Request_fail("code::"+code + "\n"+ " msg::" +  message);
            }
        });
    }

    @Override
    public void RequestOBFielMap(TestRequest testRequest) {
        testService.RequestOBFielMap(testRequest, new BaseObserver<TestResult>() {
            @Override
            public void onSuccess(TestResult testResult) {
                iTestNetWork.Request_Result(testResult);
            }
            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                iTestNetWork.Request_fail("code::"+code + "\n"+ " msg::" +  message);
            }
        });
    }
}
