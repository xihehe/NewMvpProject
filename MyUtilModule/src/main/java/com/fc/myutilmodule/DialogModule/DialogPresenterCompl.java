package com.fc.myutilmodule.DialogModule;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;

import com.fc.myutilmodule.DialogModule.DiaologFragmentUtils.CustomDialogFragement;
import com.fc.myutilmodule.DialogModule.DiaologFragmentUtils.CustomInputDialogFragment;
import com.fc.myutilmodule.DialogModule.DiaologFragmentUtils.CustomProgressDialogFragment;

public class DialogPresenterCompl implements IDialogPresenter {

    CustomDialogFragement customDialog;
    CustomInputDialogFragment customInputDialog;
    CustomProgressDialogFragment customProgressDialog;

    public DialogPresenterCompl() {

    }

    @Override
    public void showCheckDialog_OneBtn(final String txt,final String msg, final String positive, final DialogInterface.OnClickListener positiveClick,FragmentManager manager) {
        customDialog = CustomDialogFragement.newInstance(txt,msg);
        customDialog.setPositiveButton(positive,positiveClick);
        customDialog.show(manager,"oneBtn");
    }

    @Override
    public void showCheckDialog_TwoBtn(final String txt ,final String msg , final String positive,  final DialogInterface.OnClickListener positiveClick, final  String negative, final DialogInterface.OnClickListener negativeListener,FragmentManager manager) {
        customDialog = CustomDialogFragement.newInstance(txt,msg);
        customDialog.setPositiveButton(positive,positiveClick);
        customDialog.setNegativeButton(negative,negativeListener);
        customDialog.show(manager,"twoBtn");    }

    @Override
    public void dissCheckDialog() {
        if(customDialog!=null ){
            customDialog.dismiss();
            customDialog = null;
        }
    }

    @Override
    public void showProgressDialog(final String txt, final boolean canCancel, final DialogInterface cancelListener,FragmentManager manager) {
        customProgressDialog = CustomProgressDialogFragment.newInstance(txt);
        customProgressDialog.setCancelable(true);
        customProgressDialog.onCancel(cancelListener);
        customProgressDialog.show(manager,"progress");
    }

    @Override
    public void setProgressDialogTxt(final String txt) {
        if(customProgressDialog!=null) {
            customProgressDialog.setMessage(txt);
        }
    }

    @Override
    public void dissProgressDialog() {
        if(customProgressDialog!=null ){
            customProgressDialog.dismiss();
            customProgressDialog = null;
        }
    }

    @Override
    public void showInputDialog(final String title,final String editContent,final String editHint,final String positive,final String negative,final IInputDialog iInputDialog,FragmentManager manager) {
        customInputDialog = CustomInputDialogFragment.newInstance(title,null,editContent,editHint);
        customInputDialog.setInputListener(iInputDialog);
        customInputDialog.show(manager,"input");
    }


    @Override
    public void dissInputDialog() {

        if(customInputDialog!=null ){
            customInputDialog.dismiss();
            customInputDialog = null;
        }
    }
}
