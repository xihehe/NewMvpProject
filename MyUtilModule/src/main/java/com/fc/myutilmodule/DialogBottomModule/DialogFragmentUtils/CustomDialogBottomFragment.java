package com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fc.myutilmodule.DialogModule.DiaologFragmentUtils.CustomDialogFragement;
import com.fc.myutilmodule.R;

public class CustomDialogBottomFragment extends DialogFragment {

    private TextView title;

    private LinearLayout content;
    private LinearLayout btnLayout;
    private TextView positiveButton;
    private TextView negativeButton;

    private String positive;
    private String negative;
    private DialogInterface.OnClickListener positiveButtonClickListener;
    private DialogInterface.OnClickListener negativeButtonClickListener;
    private String titleStr;
    private Dialog alertDialog;
    private View contentView;


    public static CustomDialogFragement newInstance(String title) {
        CustomDialogFragement frag = new CustomDialogFragement();
        Bundle b = new Bundle();
        b.putString("title", title);
        frag.setArguments(b);
        return frag;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        alertDialog = new Dialog(getContext(), R.style.Dialog_Fullscreen_Bottom);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);


        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_myself_bottom, null, false);
        alertDialog.setContentView(dialogView);
        initDialogView(dialogView);
        View customView = contentView;

        if (customView != null) {
            content.removeAllViews();
            LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            content.addView(customView,contentParams);
        }

        if (!TextUtils.isEmpty(titleStr)) {
            title.setVisibility(View.VISIBLE);
            title.setText(titleStr);
        } else {
            title.setVisibility(View.GONE);
        }


        if (!TextUtils.isEmpty(positive)) {
            positiveButton
                    .setText(positive);
            if (positiveButtonClickListener != null) {
                positiveButton
                        .setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                positiveButtonClickListener.onClick(alertDialog,
                                        DialogInterface.BUTTON_POSITIVE);
                            }
                        });
            }
        } else {
            // if no confirm button just set the visibility to GONE
            positiveButton.setVisibility(
                    View.GONE);
        }


        if (!TextUtils.isEmpty(negative)) {
            negativeButton
                    .setText(negative);
            if (negativeButtonClickListener != null) {
                negativeButton
                        .setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                negativeButtonClickListener.onClick(alertDialog,
                                        DialogInterface.BUTTON_NEGATIVE);
                            }
                        });
            }
        } else {
            // if no confirm button just set the visibility to GONE
            negativeButton.setVisibility(
                    View.GONE);
        }

        if (TextUtils.isEmpty(negative) && TextUtils.isEmpty(titleStr)) {
            btnLayout.setVisibility(View.GONE);
        }else{
            btnLayout.setVisibility(View.VISIBLE);
        }


        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowParams = alertDialog.getWindow().getAttributes();
        windowParams.width = (int) (getResources().getDisplayMetrics().widthPixels);
        windowParams.gravity = Gravity.BOTTOM;
        alertDialog.getWindow().setAttributes(windowParams);

        return alertDialog;
    }


    //show的时候先设置
    public void setPositiveButton(String positiveButtonText,
                                  DialogInterface.OnClickListener listener) {
        this.positive = positiveButtonText;
        this.positiveButtonClickListener = listener;

    }

    //show的时候先设置
    public void setNegativeButton(String negativeButtonText,
                                  DialogInterface.OnClickListener listener) {
        this.negative = negativeButtonText;
        this.negativeButtonClickListener = listener;

    }

    public void setContentView(View contentView){
        this.contentView = contentView;
    }
    public void setTitle(String titleStr){

        this.titleStr = titleStr;
    }

    private void initDialogView(View view) {
        negativeButton = (TextView) view.findViewById(R.id.negativeButton);
        positiveButton = (TextView) view.findViewById(R.id.positiveButton);

        content = (LinearLayout) view.findViewById(R.id.content);
        btnLayout = (LinearLayout)view.findViewById(R.id.btn_layout);
        title = (TextView) view.findViewById(R.id.title);

    }


}
