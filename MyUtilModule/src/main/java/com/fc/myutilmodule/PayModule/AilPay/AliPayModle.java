package com.fc.myutilmodule.PayModule.AilPay;

public class AliPayModle {

    String Appid;
    String Rsa;
    String Money;
    String Title;
    String OrderTradeId;
    String NotifyUrl;

    public String getAppid() {
        return Appid;
    }

    public void setAppid(String appid) {
        Appid = appid;
    }

    public String getRsa() {
        return Rsa;
    }

    public void setRsa(String rsa) {
        Rsa = rsa;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOrderTradeId() {
        return OrderTradeId;
    }

    public void setOrderTradeId(String orderTradeId) {
        OrderTradeId = orderTradeId;
    }

    public String getNotifyUrl() {
        return NotifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        NotifyUrl = notifyUrl;
    }
}
