package com.ifxme.discoveryandroid.ui.ipc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ifxme.discoveryandroid.R;
import com.ifxme.discoveryandroid.common.BaseActivity;

public class IPCMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcmain);
        initView();
        initData();
        initListener();
    }

    private void initView()
    {
        UserManager.sUserId=2;
    }

    private void initData()
    {

    }

    private void initListener()
    {
        findViewById(R.id.btnSecond).setOnClickListener(v -> startActivity(new Intent(IPCMainActivity.this,SecondActivity.class)));
        findViewById(R.id.btnThird).setOnClickListener(v -> startActivity(new Intent(IPCMainActivity.this,ThirdActivity.class)));
    }
}
