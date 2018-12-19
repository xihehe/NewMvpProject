package com.example.fc.newmvpproject.TabPageModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Modle.TabModle;
import com.example.fc.newmvpproject.TabPageModule.Presenter.TabActivityPresenterCompl;
import com.example.fc.newmvpproject.TabPageModule.View.ITabsView;
import com.fc.myutilmodule.BaseModule.BaseNoBarActivity;
import com.fc.myutilmodule.ViewModule.FragmentTabHost;


import java.util.List;

public class TabActivity extends BaseNoBarActivity implements ITabsView {

    FragmentTabHost mTabHost;

    TabActivityPresenterCompl tabActivityPresenterCompl;

    List<TabModle> tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        tabActivityPresenterCompl = new TabActivityPresenterCompl(this,this);

        tabActivityPresenterCompl.getTabs();

    }

    @Override
    public void OnTabCilck(int pos) {
        mTabHost.setCurrentTab(pos);
    }

    @Override
    public void loadTabs(List<TabModle> tabs) {
        this.tabs = tabs;
        /**
         * 在setup()里边，其才去获取到TabWidget，所以在此之前，不能直接调用getTabWidget()方法；
         */
        mTabHost.setup(this, getSupportFragmentManager(), R.id.maincontent);

        /**
         *addTab:添加标签到TabHost中
         * setIndicator:表示设置标签的logo
         */
        mTabHost.addTab(mTabHost.newTabSpec("blue").setIndicator(getView(tabs.get(0))),
                tabs.get(0).getFragment(), null);
        mTabHost.addTab(mTabHost.newTabSpec("orange").setIndicator(getView(tabs.get(1))),
                tabs.get(1).getFragment(), null);
        mTabHost.addTab(mTabHost.newTabSpec("green").setIndicator(getView(tabs.get(2))),
                tabs.get(2).getFragment(), null);
        mTabHost.addTab(mTabHost.newTabSpec("red").setIndicator(getView(tabs.get(3))),
                tabs.get(3).getFragment(), null);
        mTabHost.setCurrentTab(0);

    }

    private View getView(TabModle tabModle) {
                //取得布局实例
                 View view=View.inflate(this, R.layout.tabcontent, null);
                //取得布局对象
                 ImageView imageView=(ImageView) view.findViewById(R.id.image);
                 TextView textView=(TextView) view.findViewById(R.id.text);

                 //设置图标
                 imageView.setImageResource(tabModle.getIcon());
                //设置标题
                textView.setText(tabModle.getTitle());
                return view;
            }

}






