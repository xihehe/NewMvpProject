package com.fc.myutilmodule.DialogModule;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;

public interface IDialogPresenter {

    /**
     * 显示一个按钮的展示框
     * @param txt
     * @param msg
     * @param positive
     * @param positiveClick
     */
    void showCheckDialog_OneBtn(String txt,String msg,String positive, DialogInterface.OnClickListener positiveClick,FragmentManager manager);

    /**
     * 显示两个按钮的展示框
     * @param txt
     * @param msg
     * @param positive
     * @param positiveClick
     * @param negative
     * @param negativeListener
     */
    void showCheckDialog_TwoBtn(String txt,String msg,String positive, DialogInterface.OnClickListener positiveClick,String negative,
                         DialogInterface.OnClickListener negativeListener,FragmentManager manager);

    /*关闭展示框
     */
    void dissCheckDialog();


    /**
     * 显示进度框
     * @param msg
     * @param canCancel
     * @param cancelListener
     */
    void showProgressDialog(String msg,boolean canCancel , final DialogInterface cancelListener,FragmentManager manager);

    /**
     * 设置进度框文字
     * @param msg
     */
    void setProgressDialogTxt(String msg);

    /**
     * 关闭进度框
     */
    void dissProgressDialog();


    /**
     * 展示带输入的框
     * @param title
     * @param editContent
     * @param editHint
     * @param positive
     * @param negative
     * @param iInputDialog
     */
    void showInputDialog(String title, String editContent, String editHint, String positive, String negative, IInputDialog iInputDialog,FragmentManager manager);

    /**
     * 关闭输入框
     */
    void dissInputDialog();
}
