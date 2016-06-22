package com.example.bluetooth.modules.watch;

public interface WatchModel {

    void listenForBluetoothConnection();

    boolean isConnected();

    void commandToTakePhoto();

    void commandToStartStopRecording();

}
