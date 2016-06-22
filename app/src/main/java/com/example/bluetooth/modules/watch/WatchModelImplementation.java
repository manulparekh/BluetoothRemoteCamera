package com.example.bluetooth.modules.watch;

import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.bluetooth.UIElements.ThreadHandler;
import com.example.bluetooth.utils.bluetooth.BluetoothHandler;
import com.example.bluetooth.utils.bluetooth.BluetoothListener;

public class WatchModelImplementation implements WatchModel, BluetoothListener {

    private BluetoothHandler mBluetoothHandler;

    private WatchModelListener mWatchModelListener;

    public WatchModelImplementation(WatchModelListener watchModelListener) {
        mWatchModelListener = watchModelListener;
    }

    public static WatchModel newInstance(WatchModelListener watchModelListener) {
        return new WatchModelImplementation(watchModelListener);

    }

    @Override
    public void listenForBluetoothConnection() {
        mBluetoothHandler = BluetoothHandler.newInstance(this, true);
        mBluetoothHandler.start();
    }

    @Override
    public boolean isConnected() {
        return mBluetoothHandler != null && mBluetoothHandler.getState() == BluetoothHandler.STATE_CONNECTED;
    }

    @Override
    public void commandToTakePhoto() {
        mBluetoothHandler.write(BluetoothHandler.CAMERA.getBytes());
    }

    @Override
    public void commandToStartStopRecording() {
        mBluetoothHandler.write(BluetoothHandler.RECORD.getBytes());
    }

    @Override
    public void onReceivedData(byte[] bytes) {
        final Bitmap image = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ThreadHandler.getInstance().doInForground(new Runnable() {
            @Override
            public void run() {
                mWatchModelListener.onGotFrameBitmap(image);
            }
        });
    }

    @Override
    public void onConnected(BluetoothDevice device) {
        mWatchModelListener.onDeviceConnected(device);
    }

    @Override
    public void connectionFailed() {

    }

    @Override
    public void onLostConnection() {
        mWatchModelListener.onConnectionFailed();
    }

    @Override
    public void onGotAck(String ack) {

    }

    public interface WatchModelListener {

        void onConnectionFailed();

        void onGotFrameBitmap(Bitmap image);

        void onDeviceConnected(BluetoothDevice device);
    }

}
