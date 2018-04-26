package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.xd.wxlike.R;

/**
 * Created by zhangxiaodi on 2018/4/4.01:07
 */

public class MessageInfoActivity extends AppCompatActivity {


    private RecyclerView mZanRc;
    private RecyclerView mReplyRc;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        initView();
    }

    private void initView() {
        mZanRc = findViewById(R.id.zanRc);
    }
}
