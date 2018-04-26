package com.xd.wxlike.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;

import com.xd.wxlike.R;
import com.xd.wxlike.base.BaseActivityWithTopBar;

/**
 * Created by zhangxiaodi1 on 2018/4/22.
 */

public class SelectMessageTypeActivity extends BaseActivityWithTopBar implements OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_msgtype);
        findViewById(R.id.textType).setOnClickListener(this);
        findViewById(R.id.urlType).setOnClickListener(this);
        findViewById(R.id.imageType).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(SelectMessageTypeActivity.this,SendMessageActivity.class);
        switch (view.getId()){
            case R.id.textType:
                intent.putExtra("type",0);
                break;
            case R.id.urlType:
                intent.putExtra("type",1);
                break;
            case R.id.imageType:
                intent.putExtra("type",2);
                break;
        }
        startActivity(intent);
        finish();
    }
}
