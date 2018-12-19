package com.example.fc.newmvpproject.TabPageModule.Fragment.Presenter;


import com.example.fc.newmvpproject.TabPageModule.Fragment.GreenFragment.Fragment.GreenTabFragment;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BookItem;
import com.example.fc.newmvpproject.TabPageModule.Fragment.Utils.GreenPageHolder;
import com.example.fc.newmvpproject.TabPageModule.Fragment.View.IGreenView;
import com.example.fc.newmvpproject.TabPageModule.Modle.PageItem;

public class GreenFragmentCompl implements IGreenFragment {

    static GreenPageHolder greenPageHolder;

    static {

        greenPageHolder = new GreenPageHolder();

        PageItem pageItem1 = new PageItem();
        pageItem1.setTitle("简介"); pageItem1.setFragment(GreenTabFragment.class);
        PageItem pageItem2 = new PageItem();
        pageItem2.setTitle("目录"); pageItem2.setFragment(GreenTabFragment.class);
        PageItem pageItem3 = new PageItem();
        pageItem3.setTitle("评论"); pageItem3.setFragment(GreenTabFragment.class);

        greenPageHolder.addPageTabs(pageItem1);
        greenPageHolder.addPageTabs(pageItem2);
        greenPageHolder.addPageTabs(pageItem3);

    }

    IGreenView iGreenView;


    public GreenFragmentCompl(IGreenView iGreenView) {
        this.iGreenView = iGreenView;
    }



    @Override
    public void getBookInfoData() {
        BookItem data = new BookItem();
        iGreenView.loadInfoData(data);
    }

    @Override
    public void getPageData() {
        iGreenView.loadTabData(greenPageHolder.getPageTab());
    }
}
