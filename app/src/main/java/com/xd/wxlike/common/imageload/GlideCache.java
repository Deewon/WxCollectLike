package com.xd.wxlike.common.imageload;


import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.xd.wxlike.MyApplication;

/**
 * Created by zhangxiaodi1 on 2018/2/27.
 * glide磁盘缓存路径及大小
 */
@GlideModule
public class GlideCache extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int diskCacheSizeBytes = 1024 * 1024 * 100; // 100 MB
        builder.setDiskCache(
                new DiskLruCacheFactory(MyApplication.getInstance().getImageCache(), diskCacheSizeBytes)
        );
    }

}
