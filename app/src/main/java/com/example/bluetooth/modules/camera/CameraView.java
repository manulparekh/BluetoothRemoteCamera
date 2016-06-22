package com.example.bluetooth.modules.camera;

import android.hardware.Camera;

import com.example.bluetooth.UIElements.BaseView;

public interface CameraView extends BaseView{

    void initViews();

    void startRecording(Camera.PreviewCallback previewCallback);

    void stopRecording();

    void takePhotoViaCamera();

    void setCameraPreview(Camera.PreviewCallback previewCallback);

    void navigateBack();

    boolean isRecording();

}
