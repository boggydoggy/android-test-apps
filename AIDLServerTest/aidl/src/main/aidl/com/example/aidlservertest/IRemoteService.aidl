// IRemoteService.aidl
package com.example.aidlservertest;

// Declare any non-default types here with import statements
import com.example.aidlservertest.IRemoteServiceCallback;

interface IRemoteService {
    boolean addCallback(IRemoteServiceCallback callback);
    boolean removeCallback(IRemoteServiceCallback callback);
}