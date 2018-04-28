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
     * 通过phone获取用户信息
     *
     * @param Wxid
     * @return
     */
    public List<UserEntity> getUserInfoByWXID(String Wxid) {
        QueryBuilder<UserEntity> qb = daoSession.getUserEntityDao().queryBuilder();
        qb.where(UserEntityDao.Properties.UserWxid.eq(Wxid)).build();
        return qb.list();
    }

    public synchronized void insertOrReplace(UserEntity userInfo) {
        daoSession.getUserEntityDao().insertOrReplace(userInfo);
    }

    /**
     * 根据本地保存的手机号删除登录用户信息
     * @param Wxid
     */
    public synchronized void cleanLoginUserInfo(String Wxid) {
        List<UserEntity> userInfoByPhone = getUserInfoByWXID(Wxid);
        if(userInfoByPhone!=null && userInfoByPhone.size()>0) {
            daoSession.getUserEntityDao().delete(userInfoByPhone.get(0));
        }
    }
}
