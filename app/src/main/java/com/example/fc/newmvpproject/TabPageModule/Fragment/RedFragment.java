package com.example.fc.newmvpproject.TabPageModule.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.fc.myutilmodule.BaseModule.BaseFragment;
import com.example.fc.newmvpproject.R;

public class RedFragment extends BaseFragment {

    View sonView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sonView = inflater.inflate(R.layout.tab_fragment_red,null);
        return sonView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}
