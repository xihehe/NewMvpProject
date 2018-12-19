package com.example.fc.newmvpproject.Utils;


import android.os.Environment;


import com.example.fc.newmvpproject.MyApplication;

import java.io.File;

public class FileUtils {
    private static String BASE_PATH;
    private static FileUtils mInstance;

    public static FileUtils getInst() {
        if (mInstance == null) {
            synchronized (FileUtils.class) {
                if (mInstance == null) {
                    mInstance = new FileUtils();
                }
            }
        }


        return mInstance;
    }

    private FileUtils() {
        String sdcardState = Environment.getExternalStorageState();
        //如果没SD卡则放缓存
        if (Environment.MEDIA_MOUNTED.equals(sdcardState)) {
            BASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/cityhuner/";
        } else {
            BASE_PATH = MyApplication.getApp().getCacheDirPath();
        }

    }

    public String getBasePath(){return Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/cityhuner" ;}

    public String getPhotoTempPath() {
        return BASE_PATH + "qrcode";
    }
    public String getPhotoCropPath() {return BASE_PATH + "crop";}
    public String getPhotoHeadPath() {return BASE_PATH + "head";}
    public String getApkPath(){return BASE_PATH + "apk";}

    public String getZipPic(){return BASE_PATH + "zippic";}
    public String getChatPath(){return BASE_PATH + "chat";}
    public String getAgrentmentName(){return BASE_PATH + "agrentmentName";}



    public String getgoodsPath(){return BASE_PATH + "goodspic";}


    public String getTestPath(){return Environment.getExternalStorageDirectory().getAbsolutePath()+"/testzip";}
    public String getRootPath(){return Environment.getExternalStorageDirectory().getAbsolutePath()+"/";}

    public boolean mkdir(File file) {
        while (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        return file.mkdir();
    }


    public void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
    }

    public void delZip(){
        try {
            deleteAllFiles(new File(getZipPic()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
