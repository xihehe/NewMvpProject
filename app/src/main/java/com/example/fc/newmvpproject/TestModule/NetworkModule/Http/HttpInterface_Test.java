package com.example.fc.newmvpproject.TestModule.NetworkModule.Http;


import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestRequest;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestResult;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HttpInterface_Test {

    @GET("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<TestResult>> RequestgetUserInfo();

    @GET("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<TestResult>> RequestOB(@QueryMap Map<String, String> maps);

    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<TestResult>> RequestObject(@Body TestRequest testRequest);

    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<TestResult>> RequestRequestBody(@Body RequestBody requestBody);

    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    @FormUrlEncoded
    Observable<HttpResponse<TestResult>> RequestFieldMap(@FieldMap Map<String, String> maps);

}
