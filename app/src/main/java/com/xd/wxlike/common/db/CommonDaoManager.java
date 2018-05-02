package com.xd.wxlike.common.db;


/**
 * Created by zhangxiaodi1 on 2018/1/9.
 */

public class CommonDaoManager {


    public static UserInfoDaoManager userInfoDaoManager;
    public static MessageDaoManager messageDaoManager;
    public static LikeDaoManager likeDaoManager;



    public static UserInfoDaoManager getUserInfoDaoManger() {
        if (userInfoDaoManager == null)
            userInfoDaoManager = new UserInfoDaoManager();
        return userInfoDaoManager;
    }

    public static MessageDaoManager getMesageDaoManager(){
        if(messageDaoManager == null){
            messageDaoManager = new MessageDaoManager();
        }
        return messageDaoManager;
    }

    public static LikeDaoManager getLikeDaoManager(){
        if(likeDaoManager == null){
            likeDaoManager = new LikeDaoManager();
        }
        return likeDaoManager;
    }

}
