MyUtilsModule使用
一．DiaologModule常用对话框使用
1.CustomDialogFragement为base Dialog 双按钮普通展示Dialog  
（不设置的内容不会显示：例如不设置title  title 就会为Gone）
①设置确定按钮文字和时间
setPositiveButton(String positiveButtonText,DialogInterface.OnClickListener listener)
②.设置取消按钮文字和时间
setNegativeButton(String negativeButtonText,DialogInterface.OnClickListener listener)
③.设置中间要更换的view
setContentView(View contentView)
④.设置title 和 msg 内容
setTitleAndMsg(String titleStr,String messageStr)

2.CustomInputDialogFragment 
继承自CustomDialogFragment 封装为输入框dialog
3.CustomProgressDialogFragment 
继承自CustomDialogFragment 封装为加载框dialog

使用方法：
再baseActivity 的 oncreate 方法里加入 
dialogPresenterCompl = DialogUtils.getInstance();
dialogPresenterCompl .showCheckDialog_OneBtn 展示单按钮对话框
dialogPresenterCompl .showCheckDialog_TwoBtn 展示双按钮对话框
dialogPresenterCompl .dissCheckDialog 关闭按钮对话框
dialogPresenterCompl .showProgressDialog 展示加载对话框
dialogPresenterCompl .setProgressDialogTxt 设置加载对话框文字
dialogPresenterCompl .dissProgressDialog 关闭加载对话框
dialogPresenterCompl .showInputDialog 展示输入框对话框
dialogPresenterCompl .dissInputDialog 关闭输入框对话框

二．ComPressModule压缩图片模块
* @param context
* @param mFiles 要压缩的文件列表
* @prarm index 0
* @param Savepath 存储地址
* @param iCompress listener
主要方法ComprossImageList();
mFiles是需要压缩的列表,例：List<File> mFiles；
index 穿0 就行
Savepath  存储地址
iCompress 回调函数接口

使用方法：
CompressUtils.getInstance().ComprossImageList(PickPhotoActivity.this, mFils,0,com.example.fc.newmvpproject.Utils.FileUtils.getInst().getZipPic(), new ICompress() {
        @Override
        public void startCompress(String msg) {
              ToastUtil.showText("第"+msg+"张");
         }
        @Override
        public void success(List<File> files) {
            ToastUtil.showText("成功");
         }
        @Override
        public void fail(String msg) {
            ToastUtil.showText("失败：："+msg);
            }
    });
}

三．PayModule支付模块 支付宝、微信
使用方法
支付宝支付 服务端验证  orderInfo为服务端返回的验证过的info
1.PayUtils.AliPaySignOnWeb(Activity context,String orderInfo);

支付宝支付 客户端验证  AliPayModle 自己拼接的信息
2.PayUtils.AliPaySignOnPhone(Activity context,AliPayModle aliPayModle);

微信web端验证 
请求了服务器 获取到了所有的数据,注意参数不能少
3.PayUtils.WxPaySignOnWeb(Activity context, WxPayModle wxPayModle);

微信客户端验证 
请求了服务端信息，并获取了appid、partnerId、prepayId，注意参数不能少
4.PayUtils.WxPaySignOnPhone(Activity context, WxPayModle wxPayModle);

一般使用服务器签名 所以 一般只需要用到 1 、3 方法


四．图片选择模块
已经封装好了Activity 直接调用就行了，
/**
 * 选择图片
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
必须用onActivityResult 这个才能回调
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

五．权限模块
初始化
PermissionManager permissionManager = PermissionUtils.getInstance(this);
permissionManager.initPermission();



六．自定义View模块
带点击动画的自定义view
BamButton直接替代Button
BamImageView直接替代ImageView
BamLinearLayout直接替代LinearLayout
BamTextView直接替代TextView
所有事件都与原始的一样

七．其他辅助方法
MD5Util
public  static String encrypt(String plaintext)
public static String md5(String string)
SHA1Utils
SHA加密
public static String shaEncrypt(String strSrc)
Utils
保持屏幕唤醒状态（即背景灯不熄灭）
public static void keepScreenOn(Context context, boolean on)
判断list为是否为空
public static boolean isListNoData(List mlist)
判断String字符串是否为空
public static boolean isStringEmpty(String content)
替换string里面的换行 \n
public static String replace_n(String str)
获取版本号
public static int getVersion(BaseActivity baseActivity)
获取版本号
public static String getVersionName(BaseActivity baseActivity)
获取屏幕宽度
public static int getScreenW(Context context)
获取屏幕高度
public static int getScreenH(Context context)
图片居中  显示html字符串时 让图片局中
public static String getHtmlData(String bodyHTML)
安装 apk 文件
public static void installApk(Context context,String filePath) 
复制内容到剪切板
public static void Copy(Context context,String content)
禁止EditText输入空格和换行符
public static void setEditTextInputSpace(EditText editText)

TimeUtils
Long 型时间转换为String  dateFormat为转换的格式
public static String getTime(long timeInMillis, SimpleDateFormat dateFormat)
String 类型的long型时间转换为String  dateFormat为转换的格式
public static String getTime(String timeInMillisStr,SimpleDateFormat dateFormat)
获取自己定义的时间String 格式  如 yyyy:MM:dd
public static final DateFormat getFormat(String format)
Date类型时间转换为 自定义时间格式  如 yyyy:MM:dd
public static String dtFormat(Date date, String dateFormat)
例如yyyy:MM:dd 类型的时间格式转换为Date  formatType为时间格式
public static Date stringToDate(String strTime, String formatType)
获取当前long型时间
public static long getCurrentTimeInLong() 
获取当前Date类型时间
public static Date getNow() 
得到当前Date时间后的几天  day表示几天
public static Date getDateAfter(Date d, int day)
得到当前Date时间后的几天  day表示几天  格式类型为yyyy-MM-dd
public static String getEveryDay(int day, Date date)
得到今天起几天后的时间
public static Date getDateAfter(int day)
获取当前Date月份前后需要的月份的第一天 时间格式yyyy-MM-dd
times -为前  times+后 
public static String getEveryMonthFirstDay(int times, Date date)
获取当前Date月份前后需要的月份
times -为前  times+后 
public static String getEveryMonth(int times, Date date)
根据Date 判断是第几周
public static String getdayForWeek(Date date)
将秒数转为  日时分秒
public static String getSecondTimeToDDHHmmss
将秒数转为  时分秒
public static String getSecondTimeToHHmmss
将秒数转为  分秒
public static String getSecondTimeTommss

































