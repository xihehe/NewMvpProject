package com.fc.myutilmodule.Utils;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.content.FileProvider;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.EditText;


import com.fc.myutilmodule.BaseModule.BaseActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengfengchen on 16/6/17.
 */
public class Utils {

    public static final String OUTSTR = ".00";
    public static final String OUTSTR1 = ".0";

    /**
     * 保持屏幕唤醒状态（即背景灯不熄灭）
     *
     * @param on
     *            是否唤醒
     */
    private static PowerManager.WakeLock wl;
    @SuppressLint("InvalidWakeLockTag")
    public static void keepScreenOn(Context context, boolean on) {
        if (on) {
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, "==KeepScreenOn==");
            wl.acquire();
        } else {
            if (wl != null) {
                wl.release();
                wl = null;
            }
        }
    }

    /**
     *  判断list为是否为空
     *  true 为空
     *  false 为非空
     * @param mlist
     * @return
     */
    public static boolean isListNoData(List mlist){
        return !(mlist != null && !mlist.isEmpty());
    }

    /**
     * 判断String字符串是否为空
     * @param content
     * @return
     */
    public static boolean isStringEmpty(String content){

        return !(content != null && !content.isEmpty());

    }

    /**
     * 替换string里面的换行 \n
     * @return
     */
    public static String replace_n(String str){

        if(str!=null && !str.isEmpty()){

            return str.replace("\n"," ");
        }else{
            return str;
        }

    }
    /**
     * 替换string里面的换行 等
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public static int getVersion(BaseActivity baseActivity) {
        try {
            PackageManager manager = baseActivity.getPackageManager();
            PackageInfo info = manager.getPackageInfo(baseActivity.getPackageName(), 0);
            int versionCode = info.versionCode;
            return versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public static String getVersionName(BaseActivity baseActivity) {
        try {
            PackageManager manager = baseActivity.getPackageManager();
            PackageInfo info = manager.getPackageInfo(baseActivity.getPackageName(), 0);
            String versionCode = info.versionName;
            return versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static int getScreenW(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）

        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）

        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)

        return  width;
    }

    public static int getScreenH(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
         int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
         // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
         int screenHeight = (int) (height / density);// 屏幕高度(dp)
        return  screenHeight;
    }


    /**
     * 图片居中
     * @param bodyHTML
     * @return
     */
    public static String getHtmlData(String bodyHTML) {
        String head = "<head><style>img{max-width: 100%; width:auto; height: auto;}</style></head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    /**
     * 安装 apk 文件
     *
      */
    public static void installApk(Context context,String filePath) {
       /* Intent installApkIntent = new Intent();
        installApkIntent.setAction(Intent.ACTION_VIEW);
        installApkIntent.addCategory(Intent.CATEGORY_DEFAULT);
        installApkIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        installApkIntent.setDataAndType(Uri.fromFile(apkFile), MIME_TYPE_APK);

        if (sApp.getPackageManager().queryIntentActivities(installApkIntent, 0).size() > 0) {
            sApp.startActivity(installApkIntent);
        }*/
        //Toast.makeText(sApp,apkFile.getPath(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, "com.puluo.CityHuner.fileprovider", new File(filePath));
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }


    public static void Copy(Context context,String content){
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager)context. getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("text", content);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
    }

    /**
     * 禁止EditText输入空格和换行符
     *
     * @param editText EditText输入框
     */
    public static void setEditTextInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ") || source.toString().contentEquals("\n")) {
                    return "";
                } else {
                    return null;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    //-----------------------------------------------------------------


    public static String StrTimeToFormat(String longTime){
        try {
            if (!TextUtils.isEmpty(longTime)) {
                String updatetime = longTime.trim();
                long updatetimeLong = Long.parseLong(updatetime) * 1000;
                String updateTimeStr = TimeUtils.getTime(updatetimeLong, TimeUtils.DEFAULT_DATE_FORMAT_yyyy_MM_dd_HH_mm_ss);
                return updateTimeStr;
            } else {
                return "";
            }
        }catch (Exception e){
            return "异常数据"+longTime;
        }
    }

    public static String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }


    public static String getTimeStamp(){
        //获取当前时间戳
        long timeStamp = System.currentTimeMillis()/1000;
        String time = String.valueOf(timeStamp);
        return time;
    }
}
