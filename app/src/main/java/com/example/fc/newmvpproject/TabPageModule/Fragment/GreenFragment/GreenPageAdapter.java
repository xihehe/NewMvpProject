package com.example.fc.newmvpproject.TabPageModule.Fragment.GreenFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.GreenFragment.Fragment.GreenTabFragment;
import com.example.fc.newmvpproject.TabPageModule.Modle.PageItem;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class GreenPageAdapter  extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    Context context;
    List<PageItem> mDatas;

    public GreenPageAdapter(FragmentManager fragmentManager, Context context, List<PageItem> mDatas) {
        super(fragmentManager);
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.tab_top, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(mDatas.get(position).getTitle());
        int padding = dipToPix(10);
        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {


        Bundle bundle = new Bundle();
        GreenTabFragment fragment = (GreenTabFragment) Fragment.instantiate(context, mDatas.get(position).getFragment().getName());
        fragment.setArguments(bundle);

        return fragment;
    }


    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    public int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
        return size;
    }
}
