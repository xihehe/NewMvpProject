package com.fc.myutilmodule.DownLoadModule;

import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

public class DownLoadUtils {

    private static DownLoadUtils downLoadUtils = new DownLoadUtils();

    public static DownLoadUtils getInstance(){
        if (downLoadUtils == null) {
            synchronized (DownLoadUtils.class) {
                if (downLoadUtils == null) {
                    downLoadUtils = new DownLoadUtils();
                }
            }
        }
        return downLoadUtils;
    }

    /**
     * 下载
     * @param downUrl
     * @param filepath  如app/pic
     * @param filename  如abc.jpg
     * @param fileDownloadListener
     */
    public void DownLoadFile(String downUrl, String filepath ,String filename, FileDownloadListener fileDownloadListener){
        File fileDouctment = new File(filepath);
        mkdir(fileDouctment);
        String filedownStr = filepath + "/" + filename;
        File fileDown = new File(filedownStr);
        FileDownloader.getImpl().create(downUrl)
                .setPath(fileDown.getPath())
                .setListener(fileDownloadListener).start();
    }

    private boolean mkdir(File file) {
        while (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        return file.mkdir();
    }
}
