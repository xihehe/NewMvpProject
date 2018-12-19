package com.fc.myutilmodule.DialogBottomModule;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBoottomShareFragment;

public interface IDialogBottomPresenter {

    void showTxtDialog(String title, String msg, String positive, DialogInterface.OnClickListener positiveListener, String negative, DialogInterface.OnClickListener negativceListener, FragmentManager manager);
    void dismissTxtDialog();
    //View.OnClickListener WxClick, View.OnClickListener PyqClick, View.OnClickListener QQClick, View.OnClickListener WeiboClick
    void showShareDialog(CustomDialogBoottomShareFragment.DialogClick dialogClick, FragmentManager manager);
    void dismissShareDialog();

}
