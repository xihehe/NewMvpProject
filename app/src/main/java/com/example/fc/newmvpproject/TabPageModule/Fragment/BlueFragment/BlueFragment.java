package com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fc.myutilmodule.BaseModule.BaseFragment;
import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.BlueFragment.Adapter.BlueAdapter;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BlueItem;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Presenter.BluePresenterCompl;
import com.example.fc.newmvpproject.TabPageModule.Fragment.View.IBlueView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class BlueFragment extends BaseFragment implements IBlueView {

    BluePresenterCompl bluePresenterCompl;
    RecyclerView recyclerView;
    BlueAdapter blueAdapter;

    RefreshLayout refreshLayout;

    int index =1;
        @Override
         public View onCreateView(LayoutInflater inflater,
                                  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View root = inflater.inflate(R.layout.tab_bluefragment, null);
            recyclerView = root.findViewById(R.id.tab_blue_recycler);
            refreshLayout = (RefreshLayout)root.findViewById(R.id.refreshLayout);
            Log.d("fragment","onCreateView");
            return root;
           }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("fragment","onViewCreated");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bluePresenterCompl = new BluePresenterCompl(this);
        bluePresenterCompl.loadData(1);


        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                index = index + 1;
                bluePresenterCompl.loadData(index);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                index = 1;
                bluePresenterCompl.loadData(index);
            }
        });
    }

    @Override
    public void RefreshData(List<BlueItem> mlist) {
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.finishRefresh();
        initAdapter(mlist);

    }

    @Override
    public void loadMoreData(List<BlueItem> mlist) {
        refreshLayout.finishLoadMore();
        initAdapter(mlist);
    }

    @Override
    public void error(int code) {
        refreshLayout.finishLoadMore(false);
        refreshLayout.setEnableLoadMore(false);
    }

    public void initAdapter(List<BlueItem> mlist){
            if(blueAdapter==null){
                blueAdapter = new BlueAdapter(getActivity(),R.layout.tab_blue_item,mlist);
                recyclerView.setAdapter(blueAdapter);
            }else{
                blueAdapter.setMDatas(mlist);
            }
    }
}
