package com.xd.wxlike.common.db;

import android.util.Log;


import com.xd.wxlike.greendao.DaoSession;

import java.util.List;

/**
 * Created by zhangxiaodi1 on 2018/1/7.
 */
public class BaseDao<T> {
    public static final String TAG = BaseDao.class.getSimpleName();
    public static final boolean DUBUG = false;
    public DaoManager manager;
    public DaoSession daoSession;

    public BaseDao() {
        manager = DaoManager.getInstance();
        daoSession = manager.getDaoSession();
        manager.setDebug(DUBUG);
    }

    /**************************数据库插入操作***********************/
    /**
     * 插入单个对象
     *
     * @param object
     * @return
     */
    public boolean insertObject(T object) {
        boolean flag = false;
        try {
            flag = manager.getDaoSession().insert(object) != -1 ? true : false;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return flag;
    }

    /**
     * 插入或者更新单个对象
     *
     * @param object
     * @return
     */
    public boolean insertOrUpdateObject(T object) {
        boolean flag = false;
        try {
            flag = manager.getDaoSession().insertOrReplace(object) != -1 ? true : false;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return flag;
    }

    /**
     * 插入多个对象，并开启新的线程
     *
     * @param objects
     * @return
     */
    public boolean insertMultObject(final List<T> objects) {
        boolean flag = false;
        if (null == objects || objects.isEmpty()) {
            return false;
        }
        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (T object : objects) {
                        manager.getDaoSession().insertOrReplace(object);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        } finally {
//            manager.CloseDataBase();
        }
        return flag;
    }

    /**************************数据库更新操作***********************/
    /**
     * 以对象形式进行数据修改
     * 其中必须要知道对象的主键ID
     *
     * @param object
     * @return
     */
    public void updateObject(T object) {

        if (null == object) {
            return;
        }
        try {
            manager.getDaoSession().update(object);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 批量更新数据
     *
     * @param objects
     * @return
     */
    public void updateMultObject(final List<T> objects, Class clss) {
        if (null == objects || objects.isEmpty()) {
            return;
        }
        try {

            daoSession.getDao(clss).updateInTx(new Runnable() {
                @Override
                public void run() {
                    for (T object : objects) {
                        daoSession.update(object);
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    /**************************数据库删除操作***********************/
    /**
     * 删除某个数据库表
     *
     * @param clss
     * @return
     */
    public boolean deleteAll(Class clss) {
        boolean flag = false;
        try {
            manager.getDaoSession().deleteAll(clss);
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        }
        return flag;
    }

    /**
     * 删除某个对象
     *
     * @param object
     * @return
     */
    public void deleteObject(T object) {
        try {
            daoSession.delete(object);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 通过id删除某个对象
     *
     * @param object
     * @return
     */
//    public void deleteObjectById(Class object,long id) {
//        try {
//            daoSession.getDao(object).deleteByKey(id);
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        }
//    }

    /**
     * 异步批量删除数据
     *
     * @param objects
     * @return
     */
    public boolean deleteMultObject(final List<T> objects, Class clss) {
        boolean flag = false;
        if (null == objects || objects.isEmpty()) {
            return false;
        }
        try {

            daoSession.getDao(clss).deleteInTx(new Runnable() {
                @Override
                public void run() {
                    for (T object : objects) {
                        daoSession.delete(object);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            flag = false;
        }
        return flag;
    }

    /**************************数据库查询操作***********************/

    /**
     * 获得某个表名
     *
     * @return
     */
    public String getTablename(Class object) {
        return daoSession.getDao(object).getTablename();
    }

    /**
     * 根据主键ID来查询
     *
     * @param id
     * @return
     */
    public T queryById(long id, Class object) {
        return (T) daoSession.getDao(object).loadByRowId(id);
    }

//    /**
//     * 查询某条件下的对象
//     *
//     * @param object
//     * @return
//     */
//    public List<T> queryObject(Class object, String where, String... params) {
//        Object obj = null;
//        List<T> objects = null;
//        try {
//            obj = daoSession.getDao(object);
//            if (null == obj) {
//                return null;
//            }
//            objects = daoSession.getDao(object).queryRaw(where, params);
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        }
//
//        return objects;
//    }

    /**
     * 查询所有对象
     *
     * @param object
     * @return
     */
    public List<T> queryAll(Class object) {
        List<T> objects = null;
        try {
            objects = (List<T>) daoSession.getDao(object).loadAll();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return objects;
    }

    /***************************关闭数据库*************************/
    /**
     * 关闭数据库一般在ondestory中使用
     */
    public void closeDataBase() {
        manager.closeDataBase();
    }


}
