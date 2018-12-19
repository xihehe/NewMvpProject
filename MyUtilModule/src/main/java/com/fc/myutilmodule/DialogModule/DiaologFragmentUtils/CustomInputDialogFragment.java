package com.fc.myutilmodule.DialogModule.DiaologFragmentUtils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.fc.myutilmodule.DialogModule.IInputDialog;
import com.fc.myutilmodule.R;

public class CustomInputDialogFragment extends CustomDialogFragement {

    private  IInputDialog iInputDialog;
    private EditText editContent;

    public static CustomInputDialogFragment newInstance(String title, String message,String editMsg,String editHint) {

        CustomInputDialogFragment frag = new CustomInputDialogFragment();
        Bundle b = new Bundle();
        b.putString("title", title);
        b.putString("message", message);
        b.putString("editMsg",editMsg);
        b.putString("editHint",editHint);
        frag.setArguments(b);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        initView();
        return super.onCreateDialog(savedInstanceState);
    }

    /**
     * show 之前调用
     * @param inputDialog
     */
    public void setInputListener(IInputDialog inputDialog){
        this.iInputDialog = inputDialog;
    }

    public void initView(){

      String  titleStr = getArguments().getString("title");
      String  messageStr = getArguments().getString("message");
      String editMsg = getArguments().getString("editMsg");
      String editHint= getArguments().getString("editHint");

        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.view_input_dialog, null, false);
        editContent = (EditText)dialogView.findViewById(R.id.edit_content);

        if(!TextUtils.isEmpty(editMsg)){
            editContent.setText(editMsg);
        }else{
            if(!TextUtils.isEmpty(editHint)){
                editContent.setHint(editHint);
            }else{
                editContent.setHint("请输入");
            }
        }

        setContentView(dialogView);
        setTitleAndMsg(titleStr,messageStr);
        setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iInputDialog.getEditContent(editContent.getText().toString());
            }
        });
        setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }


}
