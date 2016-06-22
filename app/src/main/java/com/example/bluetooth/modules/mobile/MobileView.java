package com.example.bluetooth.modules.mobile;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import com.example.bluetooth.UIElements.BaseView;
import com.example.bluetooth.UIElements.CAdapter;

public interface MobileView extends BaseView{

    void initViews();

    void enableBluetooth();

    void hideInapp();

    boolean isBluetoothEnabled();

    void setAdapter(CAdapter<BluetoothDevice> adapter);

    void navigateToCameraActivity(Bundle bundle);

    void showNewDeviceDialog(CAdapter<BluetoothDevice> newDeviceAdapter);

    void hideNewDeviceList();

}
