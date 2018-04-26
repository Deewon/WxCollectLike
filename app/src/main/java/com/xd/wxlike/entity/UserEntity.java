package com.xd.wxlike.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangxiaodi on 2018/4/6.16:09
 */

@Entity
public class UserEntity {

    /**
     * 微信id 唯一
     */
    @Id
    private String userWxid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像资源id
     */
    private int userImage;
    /**
     * 地址
     */
    private String userAddress;


    @Generated(hash = 246861243)
    public UserEntity(String userWxid, String userName, String nickName,
            int userImage, String userAddress) {
        this.userWxid = userWxid;
        this.userName = userName;
        this.nickName = nickName;
        this.userImage = userImage;
        this.userAddress = userAddress;
    }

    @Generated(hash = 1433178141)
    public UserEntity() {
    }


    public String getUserWxid() {
        return userWxid;
    }

    public void setUserWxid(String userWxid) {
        this.userWxid = userWxid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserImage() {
        return this.userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
