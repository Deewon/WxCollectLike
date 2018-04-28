package com.xd.wxlike.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangxiaodi1 on 2018/4/6.
 */

@Entity
public class MessageEntity {

    @Id
    private long id;
    /**
     * 1、图片，2、链接，3、纯文本
     */
    private int msgType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 链接
     */
    private String URL;
    /**
     * 链接标题
     */
    private String URLContent;
    /**
     * 毫秒数
     */
    private long msgTime;
    /**
     * 图片,多图片地址以逗号隔开
     */
    private String picAddress;



    @Generated(hash = 168984584)
    public MessageEntity(long id, int msgType, String content, String URL,
            String URLContent, long msgTime, String picAddress) {
        this.id = id;
        this.msgType = msgType;
        this.content = content;
        this.URL = URL;
        this.URLContent = URLContent;
        this.msgTime = msgTime;
        this.picAddress = picAddress;
    }
    @Generated(hash = 1797882234)
    public MessageEntity() {
    }



    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getMsgType() {
        return this.msgType;
    }
    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getURL() {
        return this.URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public String getURLContent() {
        return this.URLContent;
    }
    public void setURLContent(String URLContent) {
        this.URLContent = URLContent;
    }
    public long getMsgTime() {
        return this.msgTime;
    }
    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }
    public String getPicAddress() {
        return this.picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }


}
