package com.example.fc.newmvpproject.HttpModule;

import com.fc.myutilmodule.HttpModule.HttpBase.BaseObserver;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpDefulatResult;
import com.fc.myutilmodule.HttpModule.HttpBase.HttpResponse;
import com.fc.myutilmodule.HttpModule.HttpManager;
import com.fc.myutilmodule.HttpModule.RequestBodyType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HttpUse_Upload  extends HttpManager {

    HttpInterface_UpLoadPic httpInterface_upLoadPic;

    public HttpUse_Upload() {
        super();
        this.httpInterface_upLoadPic = retrofit.create(HttpInterface_UpLoadPic.class);
    }


    /**
     * 利用Map RequestBody、上传多图
     * @param files  文件的key"files\";filename=\""+file.getName()
     *              params 数据不能为null
     *              params 数据不能为null
     *              params 数据不能为null
     * @param params Map 数据不能为null
     * @param subscriber
     */
    public void UploadPicMuch(List<File> files,Map<String,String> params,BaseObserver<HttpDefulatResult> subscriber){
        Map<String, RequestBody> images = new HashMap<String, RequestBody>();

        //除图片参数 一般参数
        for (String key : params.keySet()) {
            ////ParamKey.TOKEN 自定义参数key常量类，即参数名
            images.put(key, RequestBody.create(RequestBodyType.MEDIA_TYPE_TEXTPLAIN, params.get(key)));
        }
        //文件（注意与上面的不同）
        if(files != null && !files.isEmpty()) {
            for (File file:files){
                images.put("files\";filename=\""+file.getName(), RequestBody.create(RequestBodyType.MEDIA_TYPE_IMGAGE, file));
            }
        }
        Observable<HttpResponse<HttpDefulatResult>> observer = httpInterface_upLoadPic.UploadPicS(images);
        toSubscribe(observer,subscriber);
    }


    /**
     *
     * @param files 文件的key " imgfile
     * @param params  Map 数据不能为null
     *              params 数据不能为null
     *              params 数据不能为null
     *              params 数据不能为null
     * @param subscriber
     */
    public void UploadPicMuch2(List<File> files,Map<String,String> params ,BaseObserver<HttpDefulatResult> subscriber){
        // 图片上传的路径 使用MultipartBody.Part上
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);//表单类型

        List<MultipartBody.Part> parts = new ArrayList<>();
        //除图片参数 一般参数
        for (String key : params.keySet()) {
            ////ParamKey.TOKEN 自定义参数key常量类，即参数名
             builder.addFormDataPart(key,params.get(key));
        }
        //图片参数
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);//filePath 图片地址
            RequestBody imageBody = RequestBody.create(RequestBodyType.MEDIA_TYPE_MULTIPART_FORMDATA, file);
            builder.addFormDataPart("imgfile", file.getName(), imageBody);//"imgfile"+i 后台接收图片流的参数名
        }
         parts = builder.build().parts();

        Observable<HttpResponse<HttpDefulatResult>> observer = httpInterface_upLoadPic.UploadPicS(parts);
        toSubscribe(observer,subscriber);

    }
}
