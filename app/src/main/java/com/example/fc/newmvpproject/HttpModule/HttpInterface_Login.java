package com.example.fc.newmvpproject.HttpModule;

import com.example.fc.newmvpproject.LoginModule.Model.LoginRequest;
import com.example.fc.newmvpproject.LoginModule.Model.LoginResult;
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

public interface HttpInterface_Login  {


    @GET("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<LoginResult>> getUserInfo();

    @GET("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<LoginResult>> OBLogin(@QueryMap Map<String, String> maps);

    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<LoginResult>> LoginObject(@Body LoginRequest loginRequest);

    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    Observable<HttpResponse<LoginResult>> LoginRequestBody(@Body RequestBody requestBody);


    @POST("apis/soft/v1.0/game-info.html?uuid=42158DAF-FB7B-ED15-28EC-AF0C9ABD044B")
    @FormUrlEncoded
    Observable<HttpResponse<LoginResult>> LoginFieldMap(@FieldMap Map<String, String> maps);



}
