package com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;


import com.example.fc.newmvpproject.ImageModule.PickPhotoActivity;
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
                        ((BaseActivity) context).dialogPresenterCompl.showCheckDialog_OneBtn("123123", "1111", "2222", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((BaseActivity) context).dialogPresenterCompl.dissCheckDialog();
                                ((BaseActivity) context).IntentToActivity(context, PickPhotoActivity.class, null);

                            }
                        },((BaseActivity) context).getSupportFragmentManager());
                    }else if(position==1){
                        ((BaseActivity) context).dialogPresenterCompl.showInputDialog("输入框","123","请输入", "确定", "取消", new IInputDialog() {
                            @Override
                            public void getEditContent(String content) {
                                if(!TextUtils.isEmpty(content)){
                                    ToastUtil.showText(content);
                                    ((BaseActivity) context).dialogPresenterCompl.dissInputDialog();
                                }else{
                                    ToastUtil.showText("还没有输入");
                                }
                            }
                        },((BaseActivity) context).getSupportFragmentManager());
                    }else if(position==2){
                        ((BaseActivity) context).dialogBottomPresenterCompl.showShareDialog(new CustomDialogBoottomShareFragment.DialogClick() {
                            @Override
                            public View.OnClickListener setWxClick() {
                                return new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ((BaseActivity) context).dialogBottomPresenterCompl.dismissShareDialog();
                                    }
                                };
                            }
                            @Override
                            public View.OnClickListener setPyqClick() {
                                return new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                };
                            }
                            @Override
                            public View.OnClickListener setQQClick() {
                                return new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ((BaseActivity) context).dialogBottomPresenterCompl.dismissShareDialog();
                                    }
                                };
                            }
                            @Override
                            public View.OnClickListener setWeiboClick() {
                                return new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                };
                            }
                        }, ((BaseActivity) context).getSupportFragmentManager());
                    }else if(position==3){
                        ((BaseActivity) context).dialogBottomPresenterCompl.showTxtDialog("测试", "更新", "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        },((BaseActivity) context).getSupportFragmentManager());
                    }
                }

            }
        });

        TxtItemContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof BaseActivity) {
                    ((BaseActivity) context).dialogPresenterCompl.showCheckDialog_TwoBtn("123123", "1111", "2222", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((BaseActivity) context).dialogPresenterCompl.dissCheckDialog();
                        }
                    }, "3333", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((BaseActivity) context).dialogPresenterCompl.dissCheckDialog();
                        }
                    },((BaseActivity) context).getSupportFragmentManager());
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