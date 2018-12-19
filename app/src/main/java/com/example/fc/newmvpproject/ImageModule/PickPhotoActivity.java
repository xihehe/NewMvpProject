package com.example.fc.newmvpproject.ImageModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.CompressModule.CompressUtils;
import com.fc.myutilmodule.CompressModule.ICompress;
import com.fc.myutilmodule.PhotoPcikModule.PhotoPickerActivity;
import com.fc.myutilmodule.Utils.Utils;
import com.fc.myutilmodule.ViewModule.BamButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PickPhotoActivity extends BaseToolBarActivity {


    PickPhotoAdapter pickPhotoAdapter;
    List<String> fileDatas = new ArrayList<>();
    @BindView(R.id.img_select_one)
    BamButton imgSelectOne;
    @BindView(R.id.img_select_more)
    BamButton imgSelectMore;
    @BindView(R.id.img_select_compress)
    BamButton imgSelectCompress;
    @BindView(R.id.img_select_recycler)
    RecyclerView imgSelectRecycler;

     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        ButterKnife.bind(this);
        titleBar.setTitle("图片选择");
        titleBar.setLeftTitle("返回");
        imgSelectRecycler.setLayoutManager(new GridLayoutManager(this,3));

     }

    public void OverSelectPic(List<String> filsPaths) {
        fileDatas.clear();
        if (!Utils.isListNoData(filsPaths)) {
            fileDatas.addAll(filsPaths);
            if(pickPhotoAdapter==null){
                pickPhotoAdapter = new PickPhotoAdapter(this, fileDatas);
                imgSelectRecycler.setAdapter(pickPhotoAdapter);
            }else{
//                pickPhotoAdapter.setList(filsPaths);
                pickPhotoAdapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PhotoPickerActivity.PICK_PHOTO_MORE:
                if (resultCode == RESULT_OK) {
                    List<String> mlist  = data.getStringArrayListExtra(PhotoPickerActivity.KEY_RESULT);
                    OverSelectPic(mlist);
                }
                break;
        }
    }

    @OnClick({R.id.img_select_one, R.id.img_select_more, R.id.img_select_compress})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_select_one:
                JumpSelectPic(1);
                break;
            case R.id.img_select_more:
                JumpSelectPic(9);
                break;
            case R.id.img_select_compress:



                dialogPresenterCompl.showProgressDialog("开始压缩",true,null,getSupportFragmentManager());

                List<String> mfils = pickPhotoAdapter.getDatas();
                if(!Utils.isListNoData(mfils)){
                    List<File> mFils  = new ArrayList<>();
                    for(String path:mfils){
                        mFils.add(new File(path));
                    }
                    CompressUtils.getInstance().ComprossImageList(PickPhotoActivity.this, mFils,0,com.example.fc.newmvpproject.Utils.FileUtils.getInst().getZipPic(), new ICompress() {
                        @Override
                        public void startCompress(String msg) {
                             dialogPresenterCompl.setProgressDialogTxt("第"+msg+"张");
                            ToastUtil.showText("第"+msg+"张");
                         }

                        @Override
                        public void success(List<File> files) {
                            ToastUtil.showText("成功");
                            dialogPresenterCompl.dissProgressDialog();
                         }

                        @Override
                        public void fail(String msg) {
                            ToastUtil.showText("失败：："+msg);
                             dialogPresenterCompl.dissProgressDialog();
                        }
                    });
                }

                break;
        }
    }


    /**
     * 选择图片
     *
     * @param index
     */
    public void JumpSelectPic(int index) {
        int intentMultiselectedMode = PhotoPickerActivity.MODE_MULTI;
        boolean intentMultishowCamera = true;
        int intentMultimaxNum = index;
        Intent intentMulti = new Intent(PickPhotoActivity.this, PhotoPickerActivity.class);
        intentMulti.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, intentMultishowCamera);
        intentMulti.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, intentMultiselectedMode);
        intentMulti.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, intentMultimaxNum);
        startActivityForResult(intentMulti, PhotoPickerActivity.PICK_PHOTO_MORE);
    }


}
