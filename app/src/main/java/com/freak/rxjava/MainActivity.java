package com.freak.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rxJava(View view) {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("发送消息");
                emitter.onNext("发送消息1");
                emitter.onNext("发送消息2");
                emitter.onComplete();
            }
        });
        observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribe(mStringObserver);
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("发送消息");
//                emitter.onNext("发送消息1");
//                emitter.onNext("发送消息2");
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e("TAG", "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.e("TAG", s);
//                Log.e("TAG", "onNext");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("TAG", "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e("TAG", "onComplete");
//            }
//        });
    }

    Observer<String> mStringObserver = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e("TAG", "onSubscribe");
        }

        @Override
        public void onNext(String s) {
            Log.e("TAG", s);
            Log.e("TAG", "onNext");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("TAG", "onError");
        }

        @Override
        public void onComplete() {
            Log.e("TAG", "onComplete");
        }
    };

    public void observer(View view) {
        DevTech devTech=new DevTech();
        Coder coder=new Coder("程序员1");
        Coder coder2=new Coder("程序员2");
        Coder coder3=new Coder("程序员3");
        Coder coder4=new Coder("程序员4");
        devTech.addObserver(coder);
        devTech.addObserver(coder2);
        devTech.addObserver(coder3);
        devTech.addObserver(coder4);
        devTech.postNewPublic("我是你观察的博文，给你发送更新啦");
    }
}
