package com.freak.rxjava;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2019/1/31.
 */

/**
 * 程序员是观察者
 */
public class Coder implements Observer {
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.e("TAG","hi,"+name+"你观察的方法（订阅）更新啦"+"，更新内容："+arg);
    }

    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                '}';
    }
}
