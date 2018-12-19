package com.example.fc.newmvpproject.HttpModule;

import com.fc.myutilmodule.HttpModule.HttpBase.HttpDefulatResult;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface HttpInterface_UpLoadPic {

    @Multipart
    @POST("visits/")
    Observable<HttpResponse<HttpDefulatResult>> UploadPicS(@PartMap Map<String, RequestBody> files);


    @Multipart
    @POST("app/head_portrait_img")
    Observable<HttpResponse<HttpDefulatResult>> UploadPicS(@Part List<MultipartBody.Part> partList);
}
