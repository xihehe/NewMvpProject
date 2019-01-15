package com.example.fc.newmvpproject.TestModule.RePluginModule;

import android.os.RemoteException;
import android.util.Log;

import com.example.fc.newmvpproject.ITest;

public class ITestCmpl extends ITest.Stub {

    @Override
    public void Hello() throws RemoteException {
        Log.d("adillog","Hello");
    }
}
