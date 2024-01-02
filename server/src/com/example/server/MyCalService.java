package com.example.server;

import com.example.calculator.calculator;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyCalService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return stub;
    }

    calculator.Stub stub = new calculator.Stub() {
        @Override
        public int sub(int a, int b) throws RemoteException {
            return a - b;
        }

        @Override
        public int mul(int a, int b) throws RemoteException {
            return a * b;
        }

        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    };
}
