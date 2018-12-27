package com.fc.myutilmodule.PhotoShowModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.R;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;

import java.util.List;


public class PhotoShowActivity extends BaseToolBarActivity {

    PhotoShowAdapter photoShowAdapter;
    private ViewPager photoViewPager;
    private IndicatorViewPager indicatorViewPager;
    private ScrollIndicatorView scrollIndicatorView;
    List<PhotoShowItem> mDatas;
    public static final String SHOW_IMGS_DATA = "show_imgs_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoshow);
        initBundle();
        photoShowAdapter = new PhotoShowAdapter(getSupportFragmentManager(),this,mDatas);
        photoViewPager = (ViewPager)findViewById(R.id.photo_viewPager);
        photoViewPager.setOffscreenPageLimit(3);
        scrollIndicatorView = (ScrollIndicatorView)findViewById(R.id.moretab_indicator);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, photoViewPager);
        indicatorViewPager.setAdapter(photoShowAdapter);
    }

    private void initBundle(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            mDatas = (List<PhotoShowItem>)bundle.getSerializable(SHOW_IMGS_DATA);
        }
    }
}
