package com.xd.wxlike.db;


import com.xd.wxlike.MyApplication;
import com.xd.wxlike.greendao.DaoMaster;
import com.xd.wxlike.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

/**
 * 数据库管理类
 * Created by zhangxiaodi1 on 2018/1/7.
 */

public class DaoManager {

    // 是否加密
    public static final boolean ENCRYPTED = true;


    private static final String PASSWORD = "wxzan";
    private static final String DB_NAME = "wxzan.db";//数据库名称
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static DBHelper dbHelper;
    private volatile static DaoManager mDaoManager;//多线程访问

    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static DaoManager getInstance() {
        DaoManager instance = null;
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                if (instance == null) {
                    instance = new DaoManager();
                    mDaoManager = instance;
                }
            }
        }
        return mDaoManager;
    }


    /**
     * 判断数据库是否存在，如果不存在则创建
     *
     * @return
     */
    public static DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
            mDaoMaster = new DaoMaster(getWritableDatabase());
        }
        return mDaoMaster;
    }

    /**
     * 获取可读数据库
     *
     * @return
     */
    public static Database getReadableDatabase(String passwprd) {
        if(null == dbHelper) {
            dbHelper = new DBHelper(MyApplication.getInstance(), DB_NAME, null);
        }
        if (ENCRYPTED) {//加密
            return new DBHelper(MyApplication.getInstance(), DB_NAME, null).getEncryptedReadableDb(passwprd);
        } else {
            return new DBHelper(MyApplication.getInstance(), DB_NAME, null).getReadableDb();
        }
    }

    /**
     * 获取可写数据库
     *
     * @return
     */
    public static Database getWritableDatabase() {
        if(null == dbHelper) {
            dbHelper = new DBHelper(MyApplication.getInstance(), DB_NAME, null);
        }
        return dbHelper.getWritableDb();
    }


    /**
     * 完成对数据库的增删查找
     *
     * @return
     */
    public static DaoSession getDaoSession() {
        if (null == mDaoSession) {
            if (null == mDaoMaster) {
                mDaoMaster = getDaoMaster();
            }
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     *
     * @param flag
     */
    public static void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    /**
     * 关闭数据库
     */
    public void closeDataBase() {
        closeHelper();
        closeDaoSession();
    }

    public void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    public void closeHelper() {
        if (dbHelper != null) {
            dbHelper.close();
            dbHelper = null;
        }
    }

}
