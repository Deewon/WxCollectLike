package com.xd.wxlike.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 点赞实体类
 */
@Entity
public class LikeEntity {
    @Id
    private long id;

    private long userId;
    private long messageId;
    private String username;
    private String userAvator;

    @Generated(hash = 101254212)
    public LikeEntity(long id, long userId, long messageId, String username,
            String userAvator) {
        this.id = id;
        this.userId = userId;
        this.messageId = messageId;
        this.username = username;
        this.userAvator = userAvator;
    }

    @Generated(hash = 1383136376)
    public LikeEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvator() {
        return userAvator;
    }

    public void setUserAvator(String userAvator) {
        this.userAvator = userAvator;
    }
}
