package com.example.bluetooth.modules.mobile;

public interface MobilePresenter {

    void onCreateView();

    void onClickEnable();

    void onBluetoothEnabled();

    void onClickNewDevice();

    void onPairedDeviceSelected(int position);

    void onNewDeviceClicked(int position);

}
