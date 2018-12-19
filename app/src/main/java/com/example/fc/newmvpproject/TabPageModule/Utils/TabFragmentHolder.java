package com.example.fc.newmvpproject.TabPageModule.Utils;


import com.example.fc.newmvpproject.TabPageModule.Modle.TabModle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabFragmentHolder {
    Map<String, TabModle> fragmentMap;
    List<TabModle> tabs;

    public TabFragmentHolder() {
        this.fragmentMap = new HashMap<>();
        this.tabs = new ArrayList<>();
    }

    public void addTabs(TabModle tabModle){
        if (!fragmentMap.containsKey(tabModle.getTitle())) {
            this.tabs.add(tabModle);
            fragmentMap.put(tabModle.getTitle(),tabModle);
        }
    }

    public List<TabModle> getTabs(){
        return this.tabs;
    }
    public Class getFragment(String title){
        return fragmentMap.get(title).getFragment();
    }
}
