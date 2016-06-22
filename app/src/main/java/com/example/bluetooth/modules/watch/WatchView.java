package com.example.bluetooth.modules.watch;

import android.graphics.Bitmap;

import com.example.bluetooth.UIElements.BaseView;

public interface WatchView extends BaseView {

    void promptUserToEnableBluetooth();

    boolean isBluetoothEnabled();

    void closeWatchView();

    void showFrameInImageView(Bitmap image);

    void showProgressDialog();

    void hideProgressDialog();

    void setProgressMessage(String name);

}
