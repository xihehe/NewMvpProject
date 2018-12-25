package com.example.fc.newmvpproject.TestModule.NetworkModule.View;

import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestResult;

public interface ITestNetWork {

    void Request_Result(TestResult testResult);

    void Request_fail(String failmsg);

}
