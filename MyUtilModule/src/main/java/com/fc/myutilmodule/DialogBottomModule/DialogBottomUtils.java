package com.fc.myutilmodule.DialogBottomModule;

import com.fc.myutilmodule.DialogModule.DialogPresenterCompl;

public class DialogBottomUtils {

    private static DialogBottomPresenterCompl mInstance;
    public static DialogBottomPresenterCompl getInstance(){

        if (mInstance == null) {
            synchronized (DialogBottomPresenterCompl.class) {
                if (mInstance == null) {
                    mInstance = new DialogBottomPresenterCompl();
                }
            }
        }
        return mInstance;
    }
}
