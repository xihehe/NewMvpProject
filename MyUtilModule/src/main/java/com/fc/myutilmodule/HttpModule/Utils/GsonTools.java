package com.fc.myutilmodule.HttpModule.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonTools {


    //使用Gson进行解析Person
    public static <T> T getPerson(String jsonString, Class<T> cls) {
            T t = null;
            try {
                Gson gson = new Gson();
                t = gson.fromJson(jsonString, cls);
            } catch (Exception e) {
                // TODO: handle exception
            }
        return t;
    }
    // 使用Gson进行解析 List<Person>
    public static <T> List<T> getPersons(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
        }
        return list;
    }

    //获取json 返回String
    public static String getGsonForObject(Object o){
        String json = null;
        try {
            Gson gson = new Gson();
            json = gson.toJson(o);
        } catch (Exception e) {
        }
        return json;
    }
}
