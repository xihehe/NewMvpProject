package com.example.fc.newmvpproject.HttpModule;


import com.example.fc.newmvpproject.LoginModule.Model.LoginRequest;
import com.example.fc.newmvpproject.LoginModule.Model.LoginResult;
import com.fc.myutilmodule.HttpModule.HttpBase.BaseObserver;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpResponse;
import com.fc.myutilmodule.HttpModule.HttpManager;
import com.fc.myutilmodule.HttpModule.RequestBodyType;
import com.fc.myutilmodule.HttpModule.Utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;


public class HttpUse_Login extends HttpManager {

    HttpInterface_Login LoginService;

    public HttpUse_Login() {
        super();
        LoginService = retrofit.create(HttpInterface_Login.class);
    }


    /**
     *
     * @param subscriber
     */
    public void GetUserInfo( BaseObserver<LoginResult> subscriber){
        Observable<HttpResponse<LoginResult>> observable= LoginService.getUserInfo();
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
     public void OBLogin(String userName,String psw, BaseObserver<LoginResult> subscriber){
         Map<String, String> params = new HashMap<>();
         params.put("username", userName);
         params.put("userpsw", psw);

         Observable<HttpResponse<LoginResult>> observable= LoginService.OBLogin(params);
         toSubscribe(observable, subscriber);
     }

    /**
     * Object传
     * 适用于Post
     * @param loginRequest
     * @param subscriber
     */
     public void OBLoginObject(LoginRequest loginRequest,BaseObserver<LoginResult> subscriber){
         Observable<HttpResponse<LoginResult>> observable= LoginService.LoginObject(loginRequest);
         toSubscribe(observable, subscriber);
     }

    /**
     * 用于结构比较复杂的请求数据
     * 适用于Post
     * @param loginRequest
     * @param subscriber
     */
     public void OBLoginRequestBody(LoginRequest loginRequest,BaseObserver<LoginResult> subscriber){
         String toJson = GsonUtils.GsonString(loginRequest);
         RequestBody requestBody = RequestBody.create(RequestBodyType.MEDIA_TYPE_JSONUTF8, toJson);

         Observable<HttpResponse<LoginResult>> observable= LoginService.LoginRequestBody(requestBody);
         toSubscribe(observable, subscriber);
     }


    /**
     *
     * 请求体请求  非url后面挂参数
     * Map内不允许有空值
     * @param loginRequest
     * @param subscriber
     */
     public void OBLoginFielMap(LoginRequest loginRequest,BaseObserver<LoginResult> subscriber){
         Map<String, String> params = new HashMap<>();
         params.put("username", loginRequest.getUserName());
         params.put("userpsw", loginRequest.getUserPsw());
         params.put("userphone", loginRequest.getUserPhone());


         Observable<HttpResponse<LoginResult>> observable= LoginService.LoginFieldMap(params);
         toSubscribe(observable, subscriber);
     }
































    //    // 发送网络请求（同步）
//    Response<Reception> response = call.execute();
//    // 对返回数据进行处理
//  response.body().show();
//    public void login(String userName,String psw) {
//        Map<String, String> params = new HashMap<>();
//        params.put("username", userName);
//        params.put("userpsw", psw);
//
//        Call<LoginResult> loginResultCall = LoginService.Login(params);
//
//        loginResultCall.enqueue(new Callback<LoginResult>() {
//            @Override
//            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
//
//            }
//            @Override
//            public void onFailure(Call<LoginResult> call, Throwable t) {
//
//            }
//        });
//     }

}
