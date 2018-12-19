package com.fc.myutilmodule.DialogBottomModule;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBoottomShareFragment;
import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBottomTxtFragment;
import com.fc.myutilmodule.DialogModule.IDialogPresenter;

public class DialogBottomPresenterCompl implements IDialogBottomPresenter {

    CustomDialogBoottomShareFragment customDialogBoottomShareFragment;
    CustomDialogBottomTxtFragment customDialogBottomTxtFragment;

    public DialogBottomPresenterCompl() {

    }

    @Override
    public void showTxtDialog(String title, String msg, String positive, DialogInterface.OnClickListener positiveListener, String negative, DialogInterface.OnClickListener negativceListener,FragmentManager manager) {
        customDialogBottomTxtFragment = CustomDialogBottomTxtFragment.newInstance(title,msg);
        customDialogBottomTxtFragment.setNegativeButton(negative,negativceListener);
        customDialogBottomTxtFragment.setPositiveButton(positive,positiveListener);
        customDialogBottomTxtFragment.show(manager,"txtDialog");
    }

    @Override
    public void dismissTxtDialog() {

        if(customDialogBottomTxtFragment!=null){
            customDialogBottomTxtFragment.dismiss();
            customDialogBottomTxtFragment = null;
        }
    }

    //View.OnClickListener WxClick, View.OnClickListener PyqClick, View.OnClickListener QQClick, View.OnClickListener WeiboClick
    @Override
    public void showShareDialog(CustomDialogBoottomShareFragment.DialogClick dialogClick,FragmentManager manager) {
        customDialogBoottomShareFragment = CustomDialogBoottomShareFragment.newInstance();
        customDialogBoottomShareFragment.setTitle("分享到..");
        customDialogBoottomShareFragment.setClick(dialogClick);
        customDialogBoottomShareFragment.show(manager,"ShareDialog");
    }

    @Override
    public void dismissShareDialog() {

        if(customDialogBoottomShareFragment!=null){
            customDialogBoottomShareFragment.dismiss();
            customDialogBoottomShareFragment = null;
        }
    }
}
