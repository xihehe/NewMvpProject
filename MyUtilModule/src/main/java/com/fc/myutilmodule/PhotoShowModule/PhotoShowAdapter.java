package com.fc.myutilmodule.PhotoShowModule;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.myutilmodule.R;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class PhotoShowAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter  {

    Context context;
    List<PhotoShowItem> datas;

    public PhotoShowAdapter(FragmentManager fragmentManager,Context context, List<PhotoShowItem> datas) {
        super(fragmentManager);
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_photoshow, container, false);
        }
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        Bundle bundle = new Bundle();
        PhotoShowFragment fragment = (PhotoShowFragment) Fragment.instantiate(context,PhotoShowFragment.class.getName());
        bundle.putSerializable(PhotoShowFragment.PHOTO_ITEM_URI,datas.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }
}
