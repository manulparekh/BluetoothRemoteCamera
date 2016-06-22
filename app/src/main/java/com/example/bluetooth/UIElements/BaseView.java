package com.example.bluetooth.UIElements;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

public interface BaseView {

    void showToast(String message);

    void showToast(String message, int time);

    Context getContext();

    FragmentActivity getActivity();

}
