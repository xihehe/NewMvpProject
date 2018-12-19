package com.example.fc.newmvpproject.TabPageModule.Fragment.Utils;



import com.example.fc.newmvpproject.TabPageModule.Modle.PageItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreenPageHolder {

    Map<String, PageItem> fragmentMap;
    List<PageItem> tabs;


    public GreenPageHolder() {
        fragmentMap = new HashMap<>();
        tabs = new ArrayList<>();
    }

    public void addPageTabs(PageItem pageItem){
        if (!fragmentMap.containsKey(pageItem.getTitle())) {
            this.tabs.add(pageItem);
            fragmentMap.put(pageItem.getTitle(),pageItem);
        }
    }

    public List<PageItem> getPageTab(){
        return tabs;
    }
}
