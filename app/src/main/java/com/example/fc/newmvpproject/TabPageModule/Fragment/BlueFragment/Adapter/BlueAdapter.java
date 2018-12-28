package com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;



import com.example.fc.newmvpproject.TestModule.ImageModule.PickPhotoActivity;
import com.example.fc.newmvpproject.TestModule.NetworkModule.TestNetWorkActivity;
import com.example.fc.newmvpproject.TestModule.SimpleCountDownActivity;
import com.example.fc.newmvpproject.TestModule.TestDialogActivity;
import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;
import com.example.fc.newmvpproject.TestModule.PhotoShowModule.PhotoShowActivity;
import com.example.fc.newmvpproject.TestModule.PhotoShowModule.PhotoShowItem;
import com.fc.myutilmodule.RxJavaModule.RxJavaUtils;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

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

        RxJavaUtils.RxClick(TxtItemTitle, new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                if(context instanceof BaseActivity) {
                    if (position == 0) {
                        ((BaseActivity) context).IntentToActivity(context, TestDialogActivity.class,null);
                    }else if(position==1){
                        ((BaseActivity) context).IntentToActivity(context, SimpleCountDownActivity.class,null);
                    }else if(position==2){
                        ((BaseActivity) context).IntentToActivity(context, PickPhotoActivity.class, null);
                    }else if(position==3){
                        ((BaseActivity) context).IntentToActivity(context, TestNetWorkActivity.class, null);
                    }else if(position==4){

                        Bundle bundle = new Bundle();
                        List<PhotoShowItem> imgRes = new ArrayList<>();
                        PhotoShowItem photoShowItem1 = new PhotoShowItem();
                        photoShowItem1.setUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545888202406&di=66c3d36b4d7902e784303d89ee8a4fa3&imgtype=0&src=http%3A%2F%2Fww3.sinaimg.cn%2Forj360%2F90dad067gw1fbixslohxtj20go23fwt1.jpg");
                        PhotoShowItem photoShowItem2 = new PhotoShowItem();
                        photoShowItem2.setUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545888236170&di=c138138dbd387d1065ffb2aeb9007172&imgtype=0&src=http%3A%2F%2Fwx1.sinaimg.cn%2Forj360%2F9cacf6efgy1fjtigh0bmrj20qo5s11kx.jpg");
                        imgRes.add(photoShowItem1);
                        imgRes.add(photoShowItem2);
                        bundle.putSerializable(PhotoShowActivity.SHOW_IMGS_DATA,(Serializable)imgRes);
                        ((BaseActivity) context).IntentToActivity(context, PhotoShowActivity.class, bundle);

                    }else{

                    }
                }
            }
        });

        RxJavaUtils.RxClick(TxtItemContent, new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                if(context instanceof BaseActivity) {
                    if (position == 0) {
                        ((BaseActivity) context).IntentToActivity(context, TestDialogActivity.class,null);
                    }else if(position==1){
                        ((BaseActivity) context).IntentToActivity(context, SimpleCountDownActivity.class,null);
                    }else if(position==2){
                        ((BaseActivity) context).IntentToActivity(context, PickPhotoActivity.class, null);
                    }else if(position==3){
                        ((BaseActivity) context).IntentToActivity(context, TestNetWorkActivity.class, null);
                    }else if(position==4){
                        Bundle bundle = new Bundle();
                        List<PhotoShowItem> imgRes = new ArrayList<>();
                        PhotoShowItem photoShowItem1 = new PhotoShowItem();
                        photoShowItem1.setUri(R.drawable.page1);
                        PhotoShowItem photoShowItem2 = new PhotoShowItem();
                        photoShowItem2.setUri(R.drawable.page3);
                        imgRes.add(photoShowItem1);
                        imgRes.add(photoShowItem2);
                        bundle.putSerializable(PhotoShowActivity.SHOW_IMGS_DATA,(Serializable)imgRes);
                        ((BaseActivity) context).IntentToActivity(context, PhotoShowActivity.class, bundle);
                    }else{

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