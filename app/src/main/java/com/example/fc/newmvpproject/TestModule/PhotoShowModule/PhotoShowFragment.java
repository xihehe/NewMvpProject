package com.example.fc.newmvpproject.TestModule.PhotoShowModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fc.newmvpproject.Utils.FileUtils;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.fc.myutilmodule.BaseModule.BaseFragment;
 import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBoottomShareFragment;
import com.fc.myutilmodule.DownLoadModule.DownLoadUtils;
import com.fc.myutilmodule.R;
import com.fc.myutilmodule.ViewModule.photoview.PhotoView;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

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

        photoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.showShareDialog(new CustomDialogBoottomShareFragment.DialogClick() {
                    @Override
                    public View.OnClickListener setWxClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setPyqClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setQQClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setWeiboClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setDownClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ((BaseActivity) getActivity()).dialogBottomPresenterCompl.dismissShareDialog();
                                String filePath = FileUtils.getInst().getPhotoPicPath();
                                DownLoadUtils.getInstance().DownLoadFile((String)itemUri.getUri(), filePath, "pic.jpg", new FileDownloadListener() {
                                    @Override
                                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                                        Log.d("download", "pending");
                                    }
                                    @Override
                                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                                      setProgressDialogContent("进度 " + soFarBytes + "/" + totalBytes);
                                        ToastUtil.showText("进度 " + soFarBytes + "/" + totalBytes);
                                    }
                                    @Override
                                    protected void completed(BaseDownloadTask task) {
                                        //完成
                                        ToastUtil.showText("下载完成");
                                    }
                                    @Override
                                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                                    }
                                    @Override
                                    protected void error(BaseDownloadTask task, Throwable e) {
//                                        toast("下载出错", Toast.LENGTH_SHORT);
//                                        Log.d("download", "error");
                                        ToastUtil.showText("下载出错");
                                    }
                                    @Override
                                    protected void warn(BaseDownloadTask task) {

                                    }
                                });
                            }
                        };
                    }
                }, getFragmentManager());


                return false;
            }
        });
    }
}
