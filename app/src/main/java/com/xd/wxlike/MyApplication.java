package com.xd.wxlike;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.xd.wxlike.common.entity.UserEntity;

/**
 * Created by zhangxiaodi1 on 2018/4/6.
 */

public class MyApplication extends Application {

    private static MyApplication instance = null;
    private UserEntity mainUser = null;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public UserEntity getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserEntity mainUser) {
        this.mainUser = mainUser;
    }

}
