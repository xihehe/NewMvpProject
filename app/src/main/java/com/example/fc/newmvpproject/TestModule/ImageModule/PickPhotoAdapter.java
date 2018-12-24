package com.example.fc.newmvpproject.TestModule.ImageModule;

import android.content.Context;
import android.widget.ImageView;

import com.example.fc.newmvpproject.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class PickPhotoAdapter  extends CommonAdapter<String>{

    public PickPhotoAdapter(Context context,List<String> datas) {
        super(context, R.layout.item_recycler_img, datas);
    }

    public void setList(List<String> datas){
      this.mDatas = datas;
      this.notifyDataSetChanged();
    }


    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        ImageView imageView = (ImageView)holder.getView(R.id.selected_list_img);
        if(this.mContext instanceof PickPhotoActivity){
            ((PickPhotoActivity)this.mContext).loadImg(s,imageView);
        }
    }
}
