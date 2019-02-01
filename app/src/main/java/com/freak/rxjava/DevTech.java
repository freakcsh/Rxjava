package com.freak.rxjava;

import java.util.Observable;

/**
 * Created by Administrator on 2019/1/31.
 */

/**
 * 这个类代表的是订阅的博文网站，这个是被观察的对象，当它有更新的使用所有的观察者（这里是程序员）都会接收到相应的消息
 */
public class DevTech extends Observable {
    void postNewPublic(String context){
        setChanged();
        notifyObservers(context);
    }
}
