package com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fc.myutilmodule.R;


public class CustomDialogBoottomShareFragment extends CustomDialogBottomFragment {

    LinearLayout layout_Wx;
    LinearLayout layout_Pyq;
    LinearLayout layout_QQ;
    LinearLayout layout_Weibo;

    View.OnClickListener clickWx;
    View.OnClickListener clickPyq;
    View.OnClickListener clickQQ;
    View.OnClickListener clickWeibo;



    public static CustomDialogBoottomShareFragment newInstance(){
        CustomDialogBoottomShareFragment frag = new CustomDialogBoottomShareFragment();
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        initView();
        return super.onCreateDialog(savedInstanceState);
    }

    public void initView(){
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.view_bottom_share_dialog, null, false);
        layout_Wx = (LinearLayout) dialogView.findViewById(R.id.dialog_iconWx);
        layout_Pyq = (LinearLayout) dialogView.findViewById(R.id.dialog_iconPyq);
        layout_QQ = (LinearLayout) dialogView.findViewById(R.id.dialog_iconQQ);
        layout_Weibo = (LinearLayout) dialogView.findViewById(R.id.dialog_iconWeibo);

        if(clickWx!=null){
            layout_Wx.setVisibility(View.VISIBLE);
            setViewListener(layout_Wx,clickWx);
        }else{
            layout_Wx.setVisibility(View.GONE);
        }
        if(clickPyq!=null){
            layout_Pyq.setVisibility(View.VISIBLE);
             setViewListener(layout_Pyq,clickPyq);
        }else{
            layout_Pyq.setVisibility(View.GONE);
        }

        if(clickQQ!=null){
            layout_QQ.setVisibility(View.VISIBLE);
             setViewListener(layout_QQ,clickQQ);
        }else{
            layout_QQ.setVisibility(View.GONE);
        }

        if(clickWeibo!=null){
            layout_Weibo.setVisibility(View.VISIBLE);
             setViewListener(layout_Weibo,clickWeibo);
        }else{
            layout_Weibo.setVisibility(View.GONE);
        }

        setContentView(dialogView);
        setTitle("分享到");
        setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public void setClick(DialogClick dialogClick){

        this.clickWx = dialogClick.setWxClick();
        this.clickPyq = dialogClick.setPyqClick();
        this.clickQQ = dialogClick.setQQClick();
        this.clickWeibo = dialogClick.setWeiboClick();

    }


    private void setViewListener(LinearLayout layout, View.OnClickListener onClickListener){
        layout.setOnClickListener(onClickListener);
        for(int i=0;i<layout.getChildCount();i++){
            View view = layout.getChildAt(i);
            view.setOnClickListener(onClickListener);
        }
    }


    public static interface DialogClick{
        View.OnClickListener setWxClick();
        View.OnClickListener setPyqClick();
        View.OnClickListener setQQClick();
        View.OnClickListener setWeiboClick();
        }

}
