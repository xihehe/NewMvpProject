package com.fc.myutilmodule.ImageLoadModule;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GlideForObjUtils {

    static GlideForObjUtils glideForObjUtils;
    static Context mContext;

    public static GlideForObjUtils  getInstence(Context context){

        mContext = context;
        if (glideForObjUtils == null) {
            synchronized (GlideForObjUtils.class) {
                if (glideForObjUtils == null) {
                    glideForObjUtils = new GlideForObjUtils();
                }
            }
        }
        return glideForObjUtils;

    }


    //=============显示图片方法===================================================================================
    public void loadImgReSize(Object url, ImageView imageView, int with, int heigt){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.override(with,heigt);
        if(imageView!=null) {
            Glide.with(mContext)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }
    }

    public void loadImg(Object url, ImageView imageView){
        if(imageView!=null) {
            Glide.with(mContext)
                    .load(url)
                    .into(imageView);
        }
    }
    public void loadImgHasLoading(Object url, ImageView imageView, int res){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(res);
         requestOptions.fallback(res);
        requestOptions.error(res);
        if(imageView!=null) {
            Glide.with(mContext)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }
    }
    public void loadImgHead(Object url, ImageView imageView){
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        if(imageView!=null) {
            Glide.with(mContext)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }
    }

    public void loadImgHeadHasLoading(Object url, ImageView imageView, int res){
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        requestOptions.placeholder(res);
        requestOptions.fallback(res);
        requestOptions.error(res);
        if(url!=null) {
//            Globals.log("imageurl", url.toString());
        }
        if(imageView!=null) {
            Glide.with(mContext)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }
    }


}
