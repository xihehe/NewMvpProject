package com.fc.myutilmodule.HttpModule.HttpBase;

/**
 * 这个类和具体的业务api 结构有关，本Demo的API 结构大致如下：
 *
 * Created by anylife.zlb@gmail.com on 2016/7/11.
 */
public class HttpResponse<T> {
    private int code;
    private String error;
    private T result;
    // some set and some get
    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
