package com.example.fc.newmvpproject.TabPageModule.View;


import com.example.fc.newmvpproject.TabPageModule.Modle.TabModle;

import java.util.List;

public interface ITabsView {

    public void OnTabCilck(int pos);
    public void loadTabs(List<TabModle> tabs);
}
