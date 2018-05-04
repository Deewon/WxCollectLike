package com.xd.wxlike.common.db;

import com.xd.wxlike.common.entity.UserEntity;
import com.xd.wxlike.greendao.UserEntityDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by zhangxiaodi1 on 2018/1/9.
 */

public class UserInfoDaoManager extends BaseDao<UserEntity> {


    /**
     * 通过wxid获取用户信息
     *
     * @param Wxid
     * @return
     */
    public UserEntity getUserInfoByWXID(String Wxid) {
        QueryBuilder<UserEntity> qb = daoSession.getUserEntityDao().queryBuilder();
        qb.where(UserEntityDao.Properties.UserWxid.eq(Wxid)).build();
        return qb.list().get(0);
    }

    public synchronized void insertOrReplace(UserEntity userInfo) {
        daoSession.getUserEntityDao().insertOrReplace(userInfo);
    }


}
