package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xd.wxlike.base.BaseActivityWithTopBar;
import com.xd.wxlike.R;
/**
 * Created by zhangxiaodi1 on 2018/4/8.
 */

public class SelectUserActivity extends BaseActivityWithTopBar {

    public static final String SELECT_USER_TYPE = "selecttype";

    private RecyclerView mUserRc;

    /**
     * 0,选择主账户界面；1，选择点赞用户界面
     */
    private int tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectuser);
        tag = getIntent().getIntExtra(SELECT_USER_TYPE,-1);
        if(tag == 0) {
            setTitle("选择主账户");
            findViewById(R.id.useritem).setVisibility(View.GONE);
        }else if(tag == 1){
            findViewById(R.id.useritem).setVisibility(View.VISIBLE);
            initMainUser();

            setTitle("选择点赞用户");
        }
        initView();
    }

    /**
     * 选择点赞人时展示主账户信息
     */
    private void initMainUser() {
        findViewById(R.id.wxcheck).setVisibility(View.INVISIBLE);

    }

    private void initView() {

        mUserRc = findViewById(R.id.userRc);
        mUserRc.setLayoutManager(new LinearLayoutManager(this));



    }
}
