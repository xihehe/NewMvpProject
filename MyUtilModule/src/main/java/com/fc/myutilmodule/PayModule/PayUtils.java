package com.fc.myutilmodule.PayModule;

import android.app.Activity;

import com.fc.myutilmodule.PayModule.AilPay.AliPayModle;
import com.fc.myutilmodule.PayModule.AilPay.MyALipayUtils;
import com.fc.myutilmodule.PayModule.WxPay.WXPayUtils;
import com.fc.myutilmodule.PayModule.WxPay.WxPayModle;

public class PayUtils {
    /**
     * 支付宝支付 服务端验证
     * orderInfo
     * 假设已从服务端获取orderInfo
     * @param context
     * @param orderInfo
     */
    public static void AliPaySignOnWeb(Activity context,String orderInfo){
        //假设已从服务端获取orderInfo
        MyALipayUtils.ALiPayBuilder builder = new MyALipayUtils.ALiPayBuilder();
        builder.build().toALiPay(context, orderInfo);
    }

    /**
     *支付宝支付 客户端验证
     * @param context
     * @param aliPayModle
     */
    public static void AliPaySignOnPhone(Activity context,AliPayModle aliPayModle){
        MyALipayUtils.ALiPayBuilder builder = new MyALipayUtils.ALiPayBuilder();
        builder.setAppid(aliPayModle.getAppid())
                .setRsa(aliPayModle.getRsa())//根据情况设置Rsa2与Rsa。这里一定要换成正确的私钥，不然会报错
                .setMoney(aliPayModle.getMoney())//单位时分
                .setTitle(aliPayModle.getTitle())
                .setOrderTradeId(aliPayModle.getOrderTradeId())//从服务端获取
                .setNotifyUrl(aliPayModle.getNotifyUrl())//从服务端获取
                .build()
                .toALiPay(context);
    }

    /**
     * 微信web端验证
     * @param context
     * @param wxPayModle
     */
    public static void WxPaySignOnWeb(Activity context, WxPayModle wxPayModle){
        //假装请求了服务器 获取到了所有的数据,注意参数不能少
        WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
        builder.setAppId(wxPayModle.getAppID())
                .setPartnerId(wxPayModle.getPartnerId())
                .setPrepayId(wxPayModle.getPrepayId())
                .setPackageValue("Sign=WXPay")
                .setNonceStr(wxPayModle.getNonceStr())
                .setTimeStamp(wxPayModle.getTimeStamp())
                .setSign(wxPayModle.getSign())
                .build().toWXPayNotSign(context);
    }

    /**
     * 微信客户端验证
     * @param context
     * @param wxPayModle
     */
    public static void WxPaySignOnPhone(Activity context, WxPayModle wxPayModle){
        //假装请求了服务端信息，并获取了appid、partnerId、prepayId，注意参数不能少
        WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
        builder.setAppId(wxPayModle.getAppID())
                .setPartnerId(wxPayModle.getPartnerId())
                .setPrepayId(wxPayModle.getPrepayId())
                .setPackageValue("Sign=WXPay")
                .build()
                .toWXPayAndSign(context,wxPayModle.getAppID(),wxPayModle.getKey());
    }





}
