package com.xd.wxlike.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;

/**
 * Created by zhangxiaodi1 on 2018/4/7.
 *
 * 查看用户信息界面
 *
 */

public class UserInfoActivity extends BaseActivityWithTopBar {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_selectuser);




    }
}
