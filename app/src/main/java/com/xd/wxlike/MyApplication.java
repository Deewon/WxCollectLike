package com.xd.wxlike;

import android.app.Application;
import android.os.Environment;

import com.blankj.utilcode.util.Utils;
import com.xd.wxlike.common.entity.UserEntity;

import java.io.File;

/**
 * Created by zhangxiaodi1 on 2018/4/6.
 */

public class MyApplication extends Application {

    private static MyApplication instance = null;
    private UserEntity mainUser = null;
    /**
     * 软件缓存路径
     */
    public static String cachePath = "";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initCachePath();
        Utils.init(this);
    }

    private void initCachePath() {
        cachePath = Environment.getExternalStorageState();
        if ((cachePath != null) && (cachePath.equals(Environment.MEDIA_MOUNTED))) {
            cachePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            cachePath = Environment.getDataDirectory().getAbsolutePath() + File.separator +
                    "data" + File.separator + getApplicationContext().getPackageName();
        }
        cachePath += File.separator + "wxlike";
    }

    public static MyApplication getInstance() {
        return instance;
    }

    /**
     * 获取图片缓存路径
     *
     * @return
     */
    public String getImageCache() {
        String imageCache = cachePath + File.separator + "imagecache";
        File dir = new File(imageCache);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return imageCache;
    }


    public UserEntity getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserEntity mainUser) {
        this.mainUser = mainUser;
    }

}
