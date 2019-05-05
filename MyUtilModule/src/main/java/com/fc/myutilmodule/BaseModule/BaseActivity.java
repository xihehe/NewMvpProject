package com.fc.myutilmodule.BaseModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fc.myutilmodule.DialogBottomModule.DialogBottomPresenterCompl;
import com.fc.myutilmodule.DialogBottomModule.DialogBottomUtils;
import com.fc.myutilmodule.DialogModule.DialogPresenterCompl;
import com.fc.myutilmodule.DialogModule.DialogUtils;
import com.fc.myutilmodule.PermissionModule.PermissionManager;
import com.fc.myutilmodule.PermissionModule.PermissionUtils;
import com.fc.myutilmodule.R;
import com.jaeger.library.StatusBarUtil;

public class BaseActivity extends AppCompatActivity {

    public DialogPresenterCompl dialogPresenterCompl;
    public DialogBottomPresenterCompl dialogBottomPresenterCompl;
    public PermissionManager permissionManager;
     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        BaseAppContext.init(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN );//| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }


        permissionManager = PermissionUtils.getInstance(this);
        dialogPresenterCompl = DialogUtils.getInstance();
        dialogBottomPresenterCompl = DialogBottomUtils.getInstance();
        initPremission();

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

      }

    @Override
    protected void onResume() {
        super.onResume();
        permissionManager = PermissionUtils.getInstance(this);

    }




    public void IntentToActivity(Context packageContext, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(packageContext, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        packageContext.startActivity(intent);


    }

    public void IntentToActivityResult(Activity packageContext, Class<?> cls, int code, Bundle bundle){
        Intent intent = new Intent();
        intent.setClass(packageContext, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        packageContext.startActivityForResult(intent,code);

    }


    //初始化权限
    public void initPremission(){
        permissionManager.initPermission();
    }


    /**
     * 改变状态栏的颜色
     */
    protected void setStatusBar(int color) {
        StatusBarUtil.setColor(this, getResources().getColor(color));
    }
    /**
     * 沉浸式
     * 写在onActivityFouckChange（）；
     * @param hasFocus
     */
    public void hide_Immersive(boolean hasFocus){
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        hide_Immersive(hasFocus);
//    }

    //=============显示图片方法===================================================================================
    public void loadImgReSize(Object url, ImageView imageView, int with, int heigt){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.override(with,heigt);
        Glide.with(BaseActivity.this)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    public void loadImg(Object url,ImageView imageView){
        Glide.with(BaseActivity.this)
                .load(url)
                .into(imageView);
    }
    public void loadImgHasLoading(Object url,ImageView imageView,int res){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(res);
        Glide.with(BaseActivity.this)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
    public void loadImgHead(Object url,ImageView imageView){
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(BaseActivity.this)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    public void loadImgHeadHasLoading(Object url,ImageView imageView,int res){
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        requestOptions.placeholder(res);
        Glide.with(BaseActivity.this)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

}

