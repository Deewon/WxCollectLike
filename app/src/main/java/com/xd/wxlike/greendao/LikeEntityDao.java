package com.xd.wxlike.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.xd.wxlike.common.entity.LikeEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LIKE_ENTITY".
*/
public class LikeEntityDao extends AbstractDao<LikeEntity, Long> {

    public static final String TABLENAME = "LIKE_ENTITY";

    /**
     * Properties of entity LikeEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property UserId = new Property(1, long.class, "userId", false, "USER_ID");
        public final static Property MessageId = new Property(2, long.class, "messageId", false, "MESSAGE_ID");
        public final static Property Username = new Property(3, String.class, "username", false, "USERNAME");
        public final static Property UserAvator = new Property(4, String.class, "userAvator", false, "USER_AVATOR");
    }


    public LikeEntityDao(DaoConfig config) {
        super(config);
    }
    
    public LikeEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LIKE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"USER_ID\" INTEGER NOT NULL ," + // 1: userId
                "\"MESSAGE_ID\" INTEGER NOT NULL ," + // 2: messageId
                "\"USERNAME\" TEXT," + // 3: username
                "\"USER_AVATOR\" TEXT);"); // 4: userAvator
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LIKE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LikeEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getUserId());
        stmt.bindLong(3, entity.getMessageId());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(4, username);
        }
 
        String userAvator = entity.getUserAvator();
        if (userAvator != null) {
            stmt.bindString(5, userAvator);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LikeEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getUserId());
        stmt.bindLong(3, entity.getMessageId());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(4, username);
        }
 
        String userAvator = entity.getUserAvator();
        if (userAvator != null) {
            stmt.bindString(5, userAvator);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public LikeEntity readEntity(Cursor cursor, int offset) {
        LikeEntity entity = new LikeEntity( //
            cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // userId
            cursor.getLong(offset + 2), // messageId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // username
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // userAvator
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LikeEntity entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setUserId(cursor.getLong(offset + 1));
        entity.setMessageId(cursor.getLong(offset + 2));
        entity.setUsername(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserAvator(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LikeEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LikeEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LikeEntity entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
