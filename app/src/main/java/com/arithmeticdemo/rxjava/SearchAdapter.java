package com.arithmeticdemo.rxjava;

import java.util.HashMap;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public class SearchAdapter implements FlowableOnSubscribe<HashMap<String,String>> {
    @Override
    public void subscribe(FlowableEmitter e) throws Exception {
    }
}
