package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xd.wxlike.base.BaseActivityWithTopBar;
import com.xd.wxlike.R;
/**
 * Created by zhangxiaodi1 on 2018/4/8.
 */

public class SelectUserActivity extends BaseActivityWithTopBar {


    private RecyclerView mUserRc;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectuser);
        setTitle("选择用户");
        initView();
    }

    private void initView() {
        mUserRc = findViewById(R.id.userRc);
        mUserRc.setLayoutManager(new LinearLayoutManager(this));



    }
}
