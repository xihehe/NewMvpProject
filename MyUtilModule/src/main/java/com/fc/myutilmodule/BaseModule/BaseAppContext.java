package com.fc.myutilmodule.BaseModule;

import android.content.Context;

/**
 * Created by Leo on 2017/12/22.
 */

public class BaseAppContext {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }


    public static Context getInstance() {
        if (mContext == null) {
            throw new NullPointerException("the context is null,please init AppContextUtil in Application first.");
        }
        return mContext;
    }
}
