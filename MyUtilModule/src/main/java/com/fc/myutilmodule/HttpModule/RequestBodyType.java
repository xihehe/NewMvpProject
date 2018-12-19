package com.fc.myutilmodule.HttpModule;



import okhttp3.MediaType;

public class RequestBodyType {

    public static MediaType MEDIA_TYPE_TEXTPLAIN = MediaType.parse("text/plain");
    public static MediaType MEDIA_TYPE_MULTIPART_FORMDATA = MediaType.parse("multipart/form-data");
    public static MediaType MEDIA_TYPE_IMGAGE = MediaType.parse("image/*");
    public static MediaType MEDIA_TYPE_JSONUTF8 = MediaType.parse("application/json; charset=utf-8");



}
