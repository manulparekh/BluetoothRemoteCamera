package com.example.bluetooth.modules.mobile;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import com.example.bluetooth.UIElements.CAdapter;

public interface MobileModel {

    CAdapter<BluetoothDevice> getAdapter();

    void fetchPairedDevicesList();

    Bundle getDeviceBundle(int position);

    CAdapter<BluetoothDevice> getNewDeviceAdapter();

    void listenForNewDevices();

    void stopListeningToNewDevices();

    void pairToDevice(int position);
}
