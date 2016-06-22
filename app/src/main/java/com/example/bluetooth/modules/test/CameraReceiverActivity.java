package com.example.bluetooth.modules.test;

import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.bluetooth.R;
import com.example.bluetooth.UIElements.BaseActivity;
import com.example.bluetooth.UIElements.ThreadHandler;
import com.example.bluetooth.utils.bluetooth.BluetoothHandler;
import com.example.bluetooth.utils.bluetooth.BluetoothListener;

public class CameraReceiverActivity extends BaseActivity {

    private ImageView mImageView;

    private BluetoothHandler mBluetoothHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_receiver);

        mImageView = (ImageView) findViewById(R.id.imageView);

        mBluetoothHandler = BluetoothHandler.newInstance(new BluetoothListener() {
            @Override
            public void onReceivedData(final byte[] bytes) {
                final Bitmap image = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                Log.e("Bitmap", image.getWidth() + " - " + image.getHeight());

                ThreadHandler.getInstance().doInForground(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(image);
                    }
                });
            }

            @Override
            public void onConnected(BluetoothDevice device) {

            }

            @Override
            public void connectionFailed() {

            }

            @Override
            public void onLostConnection() {

            }

            @Override
            public void onGotAck(String ack) {

            }
        }, true);
        mBluetoothHandler.start();

    }

    @Override
    protected void onStop() {
        mBluetoothHandler.stop();
        super.onStop();
    }
}
