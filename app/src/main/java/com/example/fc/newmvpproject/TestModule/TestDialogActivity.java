package com.example.fc.newmvpproject.TestModule;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.DialogBottomModule.DialogFragmentUtils.CustomDialogBoottomShareFragment;
import com.fc.myutilmodule.DialogModule.IInputDialog;
import com.fc.myutilmodule.ViewModule.BamButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestDialogActivity extends BaseToolBarActivity {


    @BindView(R.id.dialog_mid_double)
    BamButton dialogMidDouble;
    @BindView(R.id.dialog_mid_simple)
    BamButton dialogMidSimple;
    @BindView(R.id.dialog_bottom_double)
    BamButton dialogBottomDouble;
    @BindView(R.id.dialog_bottom_share)
    BamButton dialogBottomShare;
    @BindView(R.id.dialog_bottom_input)
    BamButton dialogBottomInput;
    @BindView(R.id.dialog_bottom_img)
    ImageView dialogBottomImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
        ButterKnife.bind(this);

        loadImg(R.drawable.page1,dialogBottomImg);

    }

    @OnClick({R.id.dialog_mid_double, R.id.dialog_mid_simple, R.id.dialog_bottom_double, R.id.dialog_bottom_share, R.id.dialog_bottom_input})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_mid_double:
                dialogPresenterCompl.showCheckDialog_TwoBtn("123123", "1111", "2222", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogPresenterCompl.dissCheckDialog();
                    }
                }, "3333", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogPresenterCompl.dissCheckDialog();
                    }
                }, getSupportFragmentManager());
                break;
            case R.id.dialog_mid_simple:
                dialogPresenterCompl.showCheckDialog_OneBtn("123123", "1111", "2222", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogPresenterCompl.dissCheckDialog();

                    }
                }, getSupportFragmentManager());

                break;
            case R.id.dialog_bottom_double:
                dialogBottomPresenterCompl.showTxtDialog("测试", "更新", "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, getSupportFragmentManager());
                break;

            case R.id.dialog_bottom_share:
                dialogBottomPresenterCompl.showShareDialog(new CustomDialogBoottomShareFragment.DialogClick() {
                    @Override
                    public View.OnClickListener setWxClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setPyqClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setQQClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }

                    @Override
                    public View.OnClickListener setWeiboClick() {
                        return new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBottomPresenterCompl.dismissShareDialog();
                            }
                        };
                    }
                }, getSupportFragmentManager());
                break;

            case R.id.dialog_bottom_input:
                dialogPresenterCompl.showInputDialog("输入框", "123", "请输入", "确定", "取消", new IInputDialog() {
                    @Override
                    public void getEditContent(String content) {
                        if (!TextUtils.isEmpty(content)) {
                            ToastUtil.showText(content);
                            dialogPresenterCompl.dissInputDialog();
                        } else {
                            ToastUtil.showText("还没有输入");
                        }
                    }
                }, getSupportFragmentManager());

                break;
        }
    }
}
