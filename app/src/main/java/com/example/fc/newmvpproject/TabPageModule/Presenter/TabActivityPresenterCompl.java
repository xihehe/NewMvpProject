package com.example.fc.newmvpproject.TabPageModule.Presenter;

import android.content.Context;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment.BlueFragment;
import com.example.fc.newmvpproject.TabPageModule.Fragment.GreenFragment.GreenFragment;
import com.example.fc.newmvpproject.TabPageModule.Fragment.OrangeFragment;
import com.example.fc.newmvpproject.TabPageModule.Fragment.RedFragment;
import com.example.fc.newmvpproject.TabPageModule.Modle.TabModle;
import com.example.fc.newmvpproject.TabPageModule.Utils.TabFragmentHolder;
import com.example.fc.newmvpproject.TabPageModule.View.ITabsView;


public class TabActivityPresenterCompl implements ITabActivityPresenter{


 public static TabFragmentHolder tabFragmentHolder;
 static {
  tabFragmentHolder = new TabFragmentHolder();
  TabModle tabModle = new TabModle();
  tabModle.setIcon(R.drawable.selector_home);
  tabModle.setTitle("蓝色");
  tabModle.setFragment(BlueFragment.class);
  tabFragmentHolder.addTabs(tabModle);

  TabModle tabModle1 = new TabModle();
  tabModle1.setIcon(R.drawable.selector_home);
  tabModle1.setTitle("绿色");
  tabModle1.setFragment(GreenFragment.class);
  tabFragmentHolder.addTabs(tabModle1);


  TabModle tabModle2 = new TabModle();
  tabModle2.setIcon(R.drawable.selector_home);
  tabModle2.setTitle("橘色");
  tabModle2.setFragment(OrangeFragment.class);
  tabFragmentHolder.addTabs(tabModle2);

  TabModle tabModle3 = new TabModle();
  tabModle3.setIcon(R.drawable.selector_home);
  tabModle3.setTitle("红色");
  tabModle3.setFragment(RedFragment.class);
  tabFragmentHolder.addTabs(tabModle3);
 }


 Context context;
 ITabsView tabsView;

 public TabActivityPresenterCompl(Context context, ITabsView tabsView) {
  this.context = context;
  this.tabsView = tabsView;
 }

 @Override
 public void changeItem(int pos) {
  tabsView.OnTabCilck(pos);
 }

 @Override
 public void getTabs() {
  tabsView.loadTabs(tabFragmentHolder.getTabs());
 }
}




