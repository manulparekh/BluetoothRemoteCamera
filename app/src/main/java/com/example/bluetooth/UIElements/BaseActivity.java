package com.example.bluetooth.UIElements;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    public void showToast(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message, int time) {
        Toast.makeText(BaseActivity.this, message, time).show();
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    @Override
    public FragmentActivity getActivity() {
        return BaseActivity.this;
    }
}
