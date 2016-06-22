package com.example.bluetooth.utils.bluetooth;

import android.bluetooth.BluetoothDevice;

public interface BluetoothListener {

    void onReceivedData(byte[] bytes);

    void onConnected(BluetoothDevice device);

    void connectionFailed();

    void onLostConnection();

    void onGotAck(String ack);

}
