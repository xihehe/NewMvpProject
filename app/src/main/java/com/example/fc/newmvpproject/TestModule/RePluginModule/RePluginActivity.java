package com.example.fc.newmvpproject.TestModule.RePluginModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.Utils.FileUtils;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.ViewModule.BamButton;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RePluginActivity extends BaseToolBarActivity {


    private String RePluginName = "test";
    private String RePluginAcitivity = "com.pluginunit.fc.mypluginunit.MainActivity";

    @BindView(R.id.replugin_btn1)
    BamButton repluginBtn1;
    @BindView(R.id.replugin_btn2)
    BamButton repluginBtn2;
    @BindView(R.id.replugin_btn3)
    BamButton repluginBtn3;
    @BindView(R.id.replugin_btn4)
    BamButton repluginBtn4;
    @BindView(R.id.replugin_btn11)
    BamButton repluginBtn11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_replugin);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.replugin_btn1, R.id.replugin_btn2, R.id.replugin_btn3, R.id.replugin_btn4, R.id.replugin_btn11})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.replugin_btn1:
                String filepath = FileUtils.getInst().getRootPath() + "test.apk";
                InstallReplugin(filepath);
                break;
            case R.id.replugin_btn2:
                OpenReplugin(RePluginName,RePluginAcitivity);
                break;
            case R.id.replugin_btn3:
                String upfilepath = FileUtils.getInst().getRootPath() + "test1.apk";
                InstallReplugin(upfilepath);
                break;
            case R.id.replugin_btn4:
                unInstallReplugin(RePluginName);
                break;
            case R.id.replugin_btn11:
                OpenReplugin(RePluginName,RePluginAcitivity);
//                OpenReplugin("image","com.xq.imageplugindemo.MainActivity");
                 break;
        }
    }

    /**
     * 调用插件
     * @param pluginName
     * @param pluginClassName
     */
    private void OpenReplugin(String pluginName,String pluginClassName){
        if (RePlugin.isPluginInstalled(pluginName)){
            RePlugin.startActivity(RePluginActivity.this, RePlugin.createIntent(pluginName, pluginClassName));
        }else{
            ToastUtil.showText("请安装插件");
        }
    }

    /**
     * 安装插件
     * @param filePath
     */
    private void InstallReplugin(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            PluginInfo info = RePlugin.install(file.getAbsolutePath());
            if(info!=null) {
                Log.i("ReplugLog", "installPluginInfo: " + info.toString());
                //预先加载
                if (RePlugin.preload(info)) {
                    ToastUtil.showText("加载成功");
                } else {
                    ToastUtil.showText("加载失败");
                }
            }else{
                ToastUtil.showText("安装失败");
            }
        } else {
            ToastUtil.showText("文件不存在");
        }
    }

    /**
     * 卸载插件
     * @param pluginName
     */
    private void unInstallReplugin(String pluginName){
        if (RePlugin.isPluginInstalled(pluginName)){
            if(RePlugin.uninstall(pluginName)) {
                ToastUtil.showText("卸载成功");
            }else{
                ToastUtil.showText("卸载失败");
            }
        }else{
            ToastUtil.showText("还没安装插件");
        }
    }

}


