package com.example.fc.newmvpproject.TabPageModule.Fragment.Presenter;



import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Utils.IBlueDataHolder;
import com.example.fc.newmvpproject.TabPageModule.Fragment.View.IBlueView;

import java.util.List;

public class BluePresenterCompl implements IBluePresenter {

     IBlueDataHolder blueDataHolder = new IBlueDataHolder();
     IBlueView iBlueView;

    public BluePresenterCompl(IBlueView iBlueView) {
        this.iBlueView = iBlueView;
    }

    @Override
    public void loadData(int page) {

        loadTestData(page);

        if(page==1) {
            iBlueView.RefreshData(blueDataHolder.getDatas());
        }else if(page >=10){
            iBlueView.error(300);
        }else{
            iBlueView.loadMoreData(blueDataHolder.getDatas());
        }

    }



    private List<BlueItem> loadTestData(int page){
        if(page ==1){
            blueDataHolder.CleanData();
        }
        for(int i=0;i<10;i++){
            blueDataHolder.addData(new BlueItem("目录" + i,"内容" + i,""));
        }
        return blueDataHolder.getDatas();
    }
}
