package com.arithmeticdemo.binder;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Stub extends Binder {
    private static int add = 1123;

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code) {
//            case Stub.add:
//
//                break;
           
        }

        return super.onTransact(code, data, reply, flags);
    }
}
