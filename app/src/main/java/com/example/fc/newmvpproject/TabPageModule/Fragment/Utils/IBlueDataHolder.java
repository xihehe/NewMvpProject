package com.example.fc.newmvpproject.TabPageModule.Fragment.Utils;


import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;

import java.util.ArrayList;
import java.util.List;

public class IBlueDataHolder {

    List<BlueItem> mdata;


    public IBlueDataHolder() {
        mdata = new ArrayList<>();
    }

    public void addData(BlueItem BlueItem){
        mdata.add(BlueItem);
    }

    public void CleanData(){
        mdata.clear();
    }

    public List<BlueItem> getDatas(){
        return this.mdata;
    }

}
