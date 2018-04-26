package com.xd.wxlike.entity;

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
    private String content;
    private String URL;
    private String URLContent;
    private String msgTime;
    private String picAddress1;
    private String picAddress2;
    private String picAddress3;
    private String picAddress4;
    private String picAddress5;
    private String picAddress6;
    @Generated(hash = 2103228293)
    public MessageEntity(long id, int msgType, String content, String URL,
            String URLContent, String msgTime, String picAddress1,
            String picAddress2, String picAddress3, String picAddress4,
            String picAddress5, String picAddress6) {
        this.id = id;
        this.msgType = msgType;
        this.content = content;
        this.URL = URL;
        this.URLContent = URLContent;
        this.msgTime = msgTime;
        this.picAddress1 = picAddress1;
        this.picAddress2 = picAddress2;
        this.picAddress3 = picAddress3;
        this.picAddress4 = picAddress4;
        this.picAddress5 = picAddress5;
        this.picAddress6 = picAddress6;
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
    public String getMsgTime() {
        return this.msgTime;
    }
    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
    public String getPicAddress1() {
        return this.picAddress1;
    }
    public void setPicAddress1(String picAddress1) {
        this.picAddress1 = picAddress1;
    }
    public String getPicAddress2() {
        return this.picAddress2;
    }
    public void setPicAddress2(String picAddress2) {
        this.picAddress2 = picAddress2;
    }
    public String getPicAddress3() {
        return this.picAddress3;
    }
    public void setPicAddress3(String picAddress3) {
        this.picAddress3 = picAddress3;
    }
    public String getPicAddress4() {
        return this.picAddress4;
    }
    public void setPicAddress4(String picAddress4) {
        this.picAddress4 = picAddress4;
    }
    public String getPicAddress5() {
        return this.picAddress5;
    }
    public void setPicAddress5(String picAddress5) {
        this.picAddress5 = picAddress5;
    }
    public String getPicAddress6() {
        return this.picAddress6;
    }
    public void setPicAddress6(String picAddress6) {
        this.picAddress6 = picAddress6;
    }



}
