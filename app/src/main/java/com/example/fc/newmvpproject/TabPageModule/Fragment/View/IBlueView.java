package com.example.fc.newmvpproject.TabPageModule.Fragment.View;


import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;

import java.util.List;

public interface IBlueView {

    void RefreshData(List<BlueItem> mlist);
    void loadMoreData(List<BlueItem> mlist);
    void error(int code);

}
