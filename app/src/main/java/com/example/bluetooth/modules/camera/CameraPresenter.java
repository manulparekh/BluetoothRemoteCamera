package com.example.bluetooth.modules.camera;

import android.os.Bundle;

public interface CameraPresenter {

    void onCreateView(Bundle extras);

    void onClickCamera();

    void onClickStartRecord();

    void onClickStopRecord();

    void onPictureTaken(byte[] data);

    void stopEverything();

}
