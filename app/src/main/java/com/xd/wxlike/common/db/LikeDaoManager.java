package com.xd.wxlike.common.db;

import com.xd.wxlike.common.entity.LikeEntity;
import com.xd.wxlike.greendao.LikeEntityDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class LikeDaoManager extends BaseDao<LikeEntity> {


    /**
     * 通过messageId获取消息点赞人信息
     *
     * @param messageId
     * @return
     */
    public List<LikeEntity> getLikesByMessageId(long messageId) {
        QueryBuilder<LikeEntity> qb = daoSession.queryBuilder(LikeEntity.class);
        qb.where(LikeEntityDao.Properties.MessageId.eq(messageId));
        List<LikeEntity> list = qb.list();
        return list;

    }

    /**
     * 根据用户ID和消息ID取消点赞
     *
     * @param userId
     * @param messageId
     */
    public void deleteMessageLike(long userId, long messageId) {
        QueryBuilder<LikeEntity> qb = daoSession.queryBuilder(LikeEntity.class);
        qb.where(LikeEntityDao.Properties.MessageId.eq(messageId)).where(LikeEntityDao.Properties.UserId.eq(userId)).build();
        List<LikeEntity> list = qb.list();
        if (list != null && list.size() > 0) {
            daoSession.getLikeEntityDao().delete(list.get(0));
        }
    }


}
