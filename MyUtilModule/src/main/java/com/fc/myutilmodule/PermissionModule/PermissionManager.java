package com.fc.myutilmodule.PermissionModule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;

import java.util.List;

/**
 * Created by fengfengchen on 2018/1/29.
 */

public class PermissionManager {

    Context context;
    private Rationale mRationale;
    private PermissionSetting mSetting;


    public PermissionManager(Context context) {
        this.context = context;
        mRationale = new DefaultRationale();
        mSetting = new PermissionSetting(context);
    }
    public void setContext(Context context){
        this.context = context;
    }

    public void initPermission(){
        requestPermission(

                Permission.CAMERA,
//                Permission.CALL_PHONE,
                Permission.READ_PHONE_STATE,

                Permission.ACCESS_FINE_LOCATION,
                Permission.ACCESS_COARSE_LOCATION,

                Permission.READ_EXTERNAL_STORAGE,
                Permission.WRITE_EXTERNAL_STORAGE
        );
    }

    private void requestPermission(String... permissions) {
        AndPermission.with(context)
                .permission(permissions)
                .rationale(mRationale)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
//                        toast(R.string.successfully);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
//                        toast(R.string.failure);
                        if (!AndPermission.hasAlwaysDeniedPermission(context, permissions)) {
                            mSetting.showSetting(permissions);
                        }
                    }
                })
                .start();
    }

    public boolean hasPermisson(List<String> permissions){
        boolean hasNo = false;
        Log.d("AndPermission","AndPermission::"+permissions.get(0)+"::"+AndPermission.hasAlwaysDeniedPermission(context, permissions.get(0)));
        Log.d("AndPermission","AndPermission::"+permissions.get(1)+"::"+AndPermission.hasAlwaysDeniedPermission(context, permissions.get(1)));
        if (!AndPermission.hasAlwaysDeniedPermission(context, permissions)) {
            mSetting.showSetting(permissions);
            hasNo = true;
        }
        return hasNo;
    }

}
