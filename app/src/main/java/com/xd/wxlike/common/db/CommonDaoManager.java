package com.xd.wxlike.common.db;


/**
 * Created by zhangxiaodi1 on 2018/1/9.
 */

public class CommonDaoManager {


    public static UserInfoDaoManager userInfoDaoManager;



    public static UserInfoDaoManager getUserInfoDaoManger() {
        if (userInfoDaoManager == null)
            userInfoDaoManager = new UserInfoDaoManager();
        return userInfoDaoManager;
    }

}
