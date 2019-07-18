package com.arithmeticdemo.rxjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJava {

    public void createRxJava(){

        Flowable<HashMap<String,String>> flowable = Flowable.create(new SearchAdapter(), BackpressureStrategy.BUFFER);
        Disposable disposeable = flowable.map(hashMap-> {

                Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
                while (iterator.hasNext()){
                    String value = iterator.next().getValue();
                    if(value.equals("1")){
                        return value;
                    }
                }

                return null;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();



    }

}
