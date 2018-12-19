package com.fc.myutilmodule.BaseModule;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.fc.myutilmodule.R;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

public class BaseToolBarActivity extends BaseActivity {

    FrameLayout contentView;
    public TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.base_toolbar_fragment);
        contentView = (FrameLayout) findViewById(R.id.toolbar_fragment_view);
        contentView.removeAllViews();
        View view = LayoutInflater.from(this).inflate(layoutResID,null);
        contentView.addView(view);
        titleBar = (TitleBar)findViewById(R.id.toolbar_id);
        titleBar.setBackgroundColor(Color.BLUE);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
    }

}
