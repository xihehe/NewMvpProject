package com.example.fc.newmvpproject.TabPageModule.Fragment.GreenFragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BookItem;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Presenter.GreenFragmentCompl;
import com.example.fc.newmvpproject.TabPageModule.Fragment.View.IGreenView;
import com.example.fc.newmvpproject.TabPageModule.Modle.PageItem;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.DrawableBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.List;

public class GreenFragment extends Fragment implements IGreenView {



      CollapsingToolbarLayout collapsingtoolbarlayout;
      AppBarLayout appbarlayout;
      TextView textviewCard;
//     FloatingActionButton floating;


    private IndicatorViewPager indicatorViewPager;
    private ScrollIndicatorView scrollIndicatorView;
    ViewPager viewPager;
    private int unSelectTextColor;
    GreenPageAdapter greenPageAdapter;
    List<PageItem> mDatas;
    GreenFragmentCompl greenFragmentCompl;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_fragment_my, null);
        greenFragmentCompl = new GreenFragmentCompl(this);
        viewPager = (ViewPager) root.findViewById(R.id.moretab_viewPager);
        viewPager.setOffscreenPageLimit(3);
        scrollIndicatorView = (ScrollIndicatorView) root.findViewById(R.id.moretab_indicator);
        scrollIndicatorView.setBackgroundColor(Color.RED);

        Log.d("fragment","onCreateView");
         return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //设置透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
         greenFragmentCompl.getBookInfoData();
        greenFragmentCompl.getPageData();
        Log.d("fragment","onViewCreated");
    }

    /**
     * 虚构的 TextView 要显示的数据
     * @param titleName
     * @return
     */
    private String ContentData(String titleName) {

        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < 1000;i++){
            buffer.append(titleName);
        }
        return buffer.toString();
    }

    @Override
    public void loadInfoData(BookItem datas) {

    }

    @Override
    public void loadTabData(List<PageItem> pageItems) {
        this.mDatas = pageItems;
        greenPageAdapter = new GreenPageAdapter(getActivity().getSupportFragmentManager(),getActivity(),mDatas);
        scrollIndicatorView.setScrollBar(new DrawableBar(getActivity(), R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - greenPageAdapter.dipToPix(12);
            }
            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - greenPageAdapter.dipToPix(12);
            }
        });
        unSelectTextColor = Color.WHITE;
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, unSelectTextColor));
        viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        indicatorViewPager.setAdapter(greenPageAdapter);
    }
}
