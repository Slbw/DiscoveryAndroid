package com.ifxme.discoveryandroid.ui.ipc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ifxme.discoveryandroid.R;
import com.orhanobut.logger.Logger;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Logger.e("UserManager.sUserId: "+UserManager.sUserId);
    }
}
