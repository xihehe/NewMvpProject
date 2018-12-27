package com.fc.myutilmodule.PhotoShowModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

 import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.fc.myutilmodule.BaseModule.BaseFragment;
import com.fc.myutilmodule.R;
import com.fc.myutilmodule.ViewModule.photoview.PhotoView;

public class PhotoShowFragment extends BaseFragment{


    PhotoView photoView;
    PhotoShowItem itemUri ;
    public static final String PHOTO_ITEM_URI = "photo_item_uri";
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_phototshow, null);
        photoView = (PhotoView)view.findViewById(R.id.img);
        Bundle bundle = getArguments();
        itemUri = (PhotoShowItem)bundle.getSerializable(PHOTO_ITEM_URI);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            ((BaseActivity) getActivity()).loadImg(itemUri.getUri(), photoView);

    }
}
