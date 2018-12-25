package com.example.fc.newmvpproject.TestModule.NetworkModule.Http;

import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestRequest;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestResult;
import com.fc.myutilmodule.HttpModule.HttpBase.BaseObserver;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpResponse;
import com.fc.myutilmodule.HttpModule.HttpManager;
import com.fc.myutilmodule.HttpModule.RequestBodyType;
import com.fc.myutilmodule.HttpModule.Utils.GsonTools;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;

public class HttpUse_Test extends HttpManager{

    HttpInterface_Test testServie;

    public HttpUse_Test() {
        super();
        testServie = retrofit.create(HttpInterface_Test.class);
    }
    /**
     *
     * @param subscriber
     */
    public void RequestGetUserInfo( BaseObserver<TestResult> subscriber){
        Observable<HttpResponse<TestResult>> observable= testServie.RequestgetUserInfo();
        toSubscribe(observable, subscriber);
    }
    /**
     * 适用于Get
     * QueryMap 方式
     * ObServable 才需要用toSubscribe
     * @param userName
     * @param psw
     * @param subscriber
     */
    public void RequestOB(String userName,String psw, BaseObserver<TestResult> subscriber){
        Map<String, String> params = new HashMap<>();
        params.put("username", userName);
        params.put("userpsw", psw);

        Observable<HttpResponse<TestResult>> observable= testServie.RequestOB(params);
        toSubscribe(observable, subscriber);
    }

    /**
     * Object传
     * 适用于Post
     * @param testRequest
     * @param subscriber
     */
    public void RequestOBObject(TestRequest testRequest, BaseObserver<TestResult> subscriber){
        Observable<HttpResponse<TestResult>> observable= testServie.RequestObject(testRequest);
        toSubscribe(observable, subscriber);
    }

    /**
     * 用于结构比较复杂的请求数据
     * 适用于Post
     * @param testRequest
     * @param subscriber
     */
    public void RequestOBRequestBody(TestRequest testRequest,BaseObserver<TestResult> subscriber){
        String toJson = GsonTools.getGsonForObject(testRequest);
        RequestBody requestBody = RequestBody.create(RequestBodyType.MEDIA_TYPE_JSONUTF8, toJson);

        Observable<HttpResponse<TestResult>> observable= testServie.RequestRequestBody(requestBody);
        toSubscribe(observable, subscriber);
    }


    /**
     *
     * 请求体请求  非url后面挂参数
     * Map内不允许有空值
     * @param testRequest
     * @param subscriber
     */
    public void RequestOBFielMap(TestRequest testRequest, BaseObserver<TestResult> subscriber){
        Map<String, String> params = new HashMap<>();
        params.put("username", testRequest.getUserName());
        params.put("userpsw", testRequest.getUserPsw());
        params.put("userphone", testRequest.getUserPhone());


        Observable<HttpResponse<TestResult>> observable= testServie.RequestFieldMap(params);
        toSubscribe(observable, subscriber);
    }

}
