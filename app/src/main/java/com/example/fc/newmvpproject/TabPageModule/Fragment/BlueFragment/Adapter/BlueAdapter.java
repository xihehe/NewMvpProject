package com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;



import com.example.fc.newmvpproject.TestModule.ImageModule.PickPhotoActivity;
import com.example.fc.newmvpproject.TestModule.SimpleCountDownActivity;
import com.example.fc.newmvpproject.TestModule.TestDialogActivity;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;
import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBoottomShareFragment;
import com.fc.myutilmodule.DialogModule.IInputDialog;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class BlueAdapter extends CommonAdapter<BlueItem> {

    Context context;
    List<BlueItem> mlist;

    public BlueAdapter(Context context, int layoutId, List<BlueItem> datas) {
        super(context, layoutId, datas);
        this.context = context;
        this.mlist = datas;
    }


    public void setMDatas(List<BlueItem> datas) {
        mlist = datas;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(ViewHolder holder, BlueItem s,final int position) {

        TextView TxtItemTitle  = (TextView) holder.getView(R.id.textItem_title);
        TextView TxtItemContent  = (TextView) holder.getView(R.id.textItem_content);
        TxtItemTitle.setText(s.getTitle());
        TxtItemContent.setText(s.getName());

        TxtItemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(context instanceof BaseActivity) {
                    if (position == 0) {
                        ((BaseActivity) context).IntentToActivity(context, TestDialogActivity.class,null);
                    }else if(position==1){
                        ((BaseActivity) context).IntentToActivity(context, SimpleCountDownActivity.class,null);
                    }else if(position==2){
                        ((BaseActivity) context).IntentToActivity(context, PickPhotoActivity.class, null);
                    }else if(position==3){

                    }else if(position==4){

                    }
                }
            }
        });
        TxtItemContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof BaseActivity) {
                    if (position == 0) {
                        ((BaseActivity) context).IntentToActivity(context, TestDialogActivity.class,null);
                    }else if(position==1){
                        ((BaseActivity) context).IntentToActivity(context, SimpleCountDownActivity.class,null);
                    }else if(position==2){
                        ((BaseActivity) context).IntentToActivity(context, PickPhotoActivity.class, null);
                    }else if(position==3){

                    }else if(position==4){

                    }
                }
            }
        });
//        homeTxtItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(context instanceof HomeActivity){
//                    ((HomeActivity)context).homePresent.onItemClick(position);
//                }
//            }
//        });
    }
}