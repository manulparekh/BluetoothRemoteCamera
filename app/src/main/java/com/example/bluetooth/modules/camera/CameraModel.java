package com.example.bluetooth.modules.camera;

import android.hardware.Camera;
import android.os.Bundle;

public interface CameraModel {

    void saveDeviceDetail(Bundle extras);

    void saveImage(byte[] data);

    void stopSocket();

    Camera.PreviewCallback getPreviewCallback();

}
