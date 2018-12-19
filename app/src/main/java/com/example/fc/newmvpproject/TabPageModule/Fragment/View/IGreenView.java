package com.example.fc.newmvpproject.TabPageModule.Fragment.View;



import com.example.fc.newmvpproject.TabPageModule.Fragment.Model.BookItem;
import com.example.fc.newmvpproject.TabPageModule.Modle.PageItem;

import java.util.List;

public interface IGreenView {

    void loadInfoData(BookItem datas);

    void loadTabData(List<PageItem> pageItems);

}
