package com.xd.wxlike.common.db;

import com.xd.wxlike.common.entity.MessageEntity;
import com.xd.wxlike.greendao.MessageEntityDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MessageDaoManager extends BaseDao<MessageEntity> {

    /**
     * 根据消息id获取消息内容
     * @param messageId
     * @return
     */
    public MessageEntity getMessageInfoById(int messageId){

        QueryBuilder<MessageEntity> qb = daoSession.queryBuilder(MessageEntity.class);
        qb.where(MessageEntityDao.Properties.Id.eq(messageId)).build();
        List<MessageEntity> list = qb.list();
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 根据消息id获取消息内容
     * @param userId
     * @return
     */
    public List<MessageEntity> getMessageByUserId(int userId){

        QueryBuilder<MessageEntity> qb = daoSession.queryBuilder(MessageEntity.class);
        qb.where(MessageEntityDao.Properties.Id.eq(userId)).build();
        List<MessageEntity> list = qb.list();
        return list;
    }


}
