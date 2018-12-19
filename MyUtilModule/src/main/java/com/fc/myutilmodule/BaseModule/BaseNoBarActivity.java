package com.fc.myutilmodule.BaseModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.fc.myutilmodule.R;
import com.hjq.bar.TitleBar;

public class BaseNoBarActivity extends BaseActivity {

    FrameLayout contentView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.base_nobar_fragment);
        contentView = (FrameLayout) findViewById(R.id.toolbar_fragment_view);
        contentView.removeAllViews();
        View view = LayoutInflater.from(this).inflate(layoutResID,null);
        contentView.addView(view);
    }

}
