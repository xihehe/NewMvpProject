package com.example.fc.newmvpproject.TestModule.PhotoShowModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.R;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;


public class PhotoShowActivity extends BaseToolBarActivity {

    PhotoShowAdapter photoShowAdapter;
    private ViewPager photoViewPager;
    private IndicatorViewPager indicatorViewPager;
    private FixedIndicatorView fixedIndicatorView;
    List<PhotoShowItem> mDatas;
    public static final String SHOW_IMGS_DATA = "show_imgs_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoshow);
        initBundle();
        titleBar.setBackgroundColor(ContextCompat.getColor(this,R.color.black));

        photoShowAdapter = new PhotoShowAdapter(getSupportFragmentManager(),this,mDatas);
        photoViewPager = (ViewPager)findViewById(R.id.photo_viewPager);
        photoViewPager.setOffscreenPageLimit(3);
        fixedIndicatorView = (FixedIndicatorView)findViewById(R.id.moretab_indicator);
        indicatorViewPager = new IndicatorViewPager(fixedIndicatorView, photoViewPager);
        indicatorViewPager.setAdapter(photoShowAdapter);
    }

    private void initBundle(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            mDatas = (List<PhotoShowItem>)bundle.getSerializable(SHOW_IMGS_DATA);
        }
    }
}
