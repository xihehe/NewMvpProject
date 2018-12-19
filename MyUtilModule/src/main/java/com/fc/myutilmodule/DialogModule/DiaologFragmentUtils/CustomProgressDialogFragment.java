package com.fc.myutilmodule.DialogModule.DiaologFragmentUtils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fc.myutilmodule.R;

public class CustomProgressDialogFragment extends CustomDialogFragement{


    private TextView progressText;


    public static CustomProgressDialogFragment newInstance(String msg) {

        CustomProgressDialogFragment frag = new CustomProgressDialogFragment();
        Bundle b = new Bundle();
        b.putString("msg", msg);
        frag.setArguments(b);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        initView();
        return super.onCreateDialog(savedInstanceState);
    }

    public void initView(){
        String msg = getArguments().getString("msg");
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.view_progress_dialog, null, false);
        progressText = (TextView) dialogView.findViewById(R.id.message);
        progressText.setText(msg);
        setContentView(dialogView);
        setTitleAndMsg(null,null);
    }

    public void setMessage(String msg){
        if(!TextUtils.isEmpty(msg)){
            if(progressText!=null) {
                progressText.setText(msg);
            }
        }
    }
}
