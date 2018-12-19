package com.fc.myutilmodule.CompressModule;

import android.content.Context;
import android.os.Environment;

import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.fc.myutilmodule.Utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class CompressUtils {

    List<File> compressList = new ArrayList<>();

   private static CompressUtils compressUtils = new CompressUtils();

    public static CompressUtils getInstance(){
        if (compressUtils == null) {
            synchronized (CompressUtils.class) {
                if (compressUtils == null) {
                    compressUtils = new CompressUtils();
                }
            }
        }
        return compressUtils;
    }

    /**
     * 压缩图片过程方法(多张)
     * @param context
     * @param mFiles 要压缩的文件列表
     * @prarm index 0
     * @param Savepath 存储地址
     * @param iCompress listener
     */
    public void ComprossImageList(final Context context,final List<File> mFiles,final int index,final String Savepath,final ICompress iCompress) {

        compressList.clear();

        ComprossImage(context, mFiles.get(index), Savepath,new OnCompressListener() {

            @Override
            public void onStart() {
                iCompress.startCompress("开始压缩第" + (index + 1) + "张图片");
            }
            @Override
            public void onSuccess(File file) {
                compressList.add(file);
                if (index < (mFiles.size() - 1)) {
                    ComprossImageList(context,mFiles,index + 1,Savepath,iCompress);
//                    ComprossImage(context, mFiles.get(index+1),Savepath, this);
                } else {
                    //shangchuan
                    if(context instanceof BaseActivity)
                        ((BaseActivity)context).dialogPresenterCompl.setProgressDialogTxt("压缩完成,上传中....");
                    iCompress.success(compressList);
                }
            }
            @Override
            public void onError(Throwable e) {
                iCompress.fail("压缩失败"+e.getMessage());
            }
        });

    }
    //-------压缩图片 end-------

    /**
     * 压缩图片过程方法(单张)
     * @param context
     * @param file 压缩前图片
     * @param Savepath 存储路径
     * @param onCompressListener listener、
     */
    private void ComprossImage(final Context context,final File file,String Savepath,OnCompressListener onCompressListener) {

        String newCompresspath = Savepath;
        FileUtils.mkdir(new File(newCompresspath));
        File fileBeforZip = file;
        if (fileBeforZip.isFile()) {
            Luban.with(context)
                    .load(fileBeforZip)                                   // 传人要压缩的图片列表
                    .ignoreBy(100)                                  // 忽略不压缩图片的大小
                    .setTargetDir(newCompresspath)                        // 设置压缩后文件存储位置
                    .setCompressListener(onCompressListener).launch();    //启动压缩
        }
    }

}
