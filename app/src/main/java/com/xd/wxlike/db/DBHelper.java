package com.xd.wxlike.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.xd.wxlike.MyApplication;
import com.xd.wxlike.entity.UserEntity;
import com.xd.wxlike.greendao.DaoMaster;
import com.xd.wxlike.greendao.UserEntityDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zhangxiaodi1 on 2018/1/7.
 */

public class DBHelper extends DaoMaster.DevOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }




    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {



        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserEntityDao.class);
    }
}
