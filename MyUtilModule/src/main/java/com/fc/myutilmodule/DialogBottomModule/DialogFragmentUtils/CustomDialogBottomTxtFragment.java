package com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fc.myutilmodule.R;

public class CustomDialogBottomTxtFragment extends CustomDialogBottomFragment{

    TextView txt_msg;

    public static CustomDialogBottomTxtFragment newInstance(String title,String msg){
        CustomDialogBottomTxtFragment frag = new CustomDialogBottomTxtFragment();
        Bundle b = new Bundle();
        b.putString("title", title);
        b.putString("message", msg);
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
        String  titleStr = getArguments().getString("title");
        String  messageStr = getArguments().getString("message");

        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.view_bottom_txt_dialog, null, false);
        txt_msg = (TextView) dialogView.findViewById(R.id.bottom_message);
        txt_msg.setText(messageStr);
        setContentView(dialogView);
        setTitle(titleStr);

     }


}
