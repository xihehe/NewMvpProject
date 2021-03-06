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
            if(i==0){
                blueDataHolder.addData(new BlueItem("对话框","对话框展示" ,""));
            }else if(i==1){
                blueDataHolder.addData(new BlueItem("倒计时" ,"倒计时展示",""));
            }else if(i==2){
                blueDataHolder.addData(new BlueItem("图片压缩上传" ,"压缩图片上传图片" ,""));
            }else if(i==3){
                blueDataHolder.addData(new BlueItem("网络请求" ,"各种模式网络请求",""));
            }else if(i==4){
                blueDataHolder.addData(new BlueItem("图片浏览", "查看图片", ""));
            }else if(i==5){
                blueDataHolder.addData(new BlueItem("插件开发", "360热修复", ""));
            }else if(i==6){
                blueDataHolder.addData(new BlueItem("线程池", "线程池使用", ""));
            }else if(i==7){
                blueDataHolder.addData(new BlueItem("线程安全的Thread", "可以唤醒等待线程的Thread", ""));
            }else{
                blueDataHolder.addData(new BlueItem("未完待续", "未完待续", ""));
            }
        }
        return blueDataHolder.getDatas();
    }
}
