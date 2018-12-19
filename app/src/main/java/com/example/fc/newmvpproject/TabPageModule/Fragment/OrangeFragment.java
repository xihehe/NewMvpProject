package com.example.fc.newmvpproject.TabPageModule.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fc.newmvpproject.R;


public class OrangeFragment extends Fragment {

    private float mSelfHeight = 0;//用以判断是否得到正确的宽高值
    private float mTitleScale;
    private float mSubScribeScale;
    private float mSubScribeScaleX;
    private float mHeadImgScale;

     ImageView mHeadImage;
     TextView mSubscriptionTitle;
     TextView mSubscribe;
     AppBarLayout mAppBar;
     Toolbar mToolbar;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_fragment_orange, null);

        mHeadImage = (ImageView)root.findViewById(R.id.iv_head);
        mSubscriptionTitle = (TextView)root.findViewById(R.id.subscription_title);
        mSubscribe = (TextView)root.findViewById(R.id.subscribe);
        mAppBar = (AppBarLayout)root.findViewById(R.id.app_bar);
        mToolbar = (Toolbar)root.findViewById(R.id.toolbar);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final float screenW = getResources().getDisplayMetrics().widthPixels;
        final float toolbarHeight = getResources().getDimension(R.dimen.toolbar_height);
        final float initHeight = getResources().getDimension(R.dimen.subscription_head);
        final float initPadding = getResources().getDimension(R.dimen.margin_46px);
        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Log.d("verticalOffset","verticalOffset:"+verticalOffset);
                Log.d("toolbarHeight","toolbarHeight:"+toolbarHeight);
                Log.d("appBarLayout","appBarLayout:"+appBarLayout.getHeight());
                //verticalOffset + toolbarHeight = appBarLayout
                if (mSelfHeight == 0) {
                    mSelfHeight = mSubscriptionTitle.getHeight();
                    float distanceTitle = mSubscriptionTitle.getTop() - initPadding/2.0f + (mSelfHeight - toolbarHeight) / 2.0f;
                    float distanceSubscribe = mSubscribe.getY()- initPadding/2.0f + (mSubscribe.getHeight() - toolbarHeight) / 2.0f;
                    float distanceHeadImg = mHeadImage.getY()- initPadding/2.0f + (mHeadImage.getHeight() - toolbarHeight) / 2.0f;
                        float distanceSubscribeX = screenW / 2.0f - (mSubscribe.getWidth() / 2.0f + getResources().getDimension(R.dimen.normal_space));
                    mTitleScale = distanceTitle / (initHeight - toolbarHeight);
                    mSubScribeScale = distanceSubscribe / (initHeight - toolbarHeight);
                    mHeadImgScale = distanceHeadImg / (initHeight - toolbarHeight);
                    mSubScribeScaleX = distanceSubscribeX / (initHeight - toolbarHeight);
                }
                float scale = 1.0f - (-verticalOffset) / (initHeight - toolbarHeight);


//                mHeadImage.setTranslationX(mSubScribeScaleX * verticalOffset);
                mHeadImage.setScaleX(scale);
                mHeadImage.setScaleY(scale);
                mHeadImage.setTranslationY(mHeadImgScale * verticalOffset);
                mSubscriptionTitle.setTranslationY(mTitleScale * verticalOffset);
                mSubscribe.setTranslationY(mSubScribeScale * verticalOffset);
//                mSubscribe.setTranslationX(-mSubScribeScaleX * verticalOffset);
            }
        });

    }
}
