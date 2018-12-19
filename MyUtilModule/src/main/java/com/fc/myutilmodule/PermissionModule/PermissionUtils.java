package com.fc.myutilmodule.PermissionModule;

import android.content.Context;



public class PermissionUtils  {

    private static PermissionManager permissionManager;
    public static PermissionManager getInstance(Context context){

        if (permissionManager == null) {
            synchronized (PermissionManager.class) {
                if (permissionManager == null) {
                    permissionManager = new PermissionManager(context);
                }
            }
        }else{
            permissionManager.setContext(context);
        }

        return permissionManager;
    }

}
