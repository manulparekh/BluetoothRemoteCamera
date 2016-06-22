package com.example.bluetooth;

import android.app.Application;

public class BlutoothCamera extends Application {

    private static BlutoothCamera sBlutoothCamera;

    public static BlutoothCamera getInstance() {
        return sBlutoothCamera;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sBlutoothCamera = BlutoothCamera.this;
    }
}
