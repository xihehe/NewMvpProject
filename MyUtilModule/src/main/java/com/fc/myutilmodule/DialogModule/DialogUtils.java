package com.fc.myutilmodule.DialogModule;

public class DialogUtils {

    private static DialogPresenterCompl mInstance;
    public static DialogPresenterCompl getInstance(){

        if (mInstance == null) {
            synchronized (DialogPresenterCompl.class) {
                if (mInstance == null) {
                    mInstance = new DialogPresenterCompl();
                }
            }
        }
        return mInstance;
    }


}
