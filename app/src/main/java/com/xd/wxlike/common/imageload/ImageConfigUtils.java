package com.xd.wxlike.common.imageload;

import android.content.Context;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by zhangxiaodi1 on 2017/12/26.
 */

public class ImageConfigUtils {


    /**
     * 获取图片下载配置信息
     *
     * @param context
     * @return
     */
    public static ImageLoadConfig getDefaultImageLoadConfig(Context context) {

        RequestOptions options = new RequestOptions()
//                .placeholder()//加载中图片
//                .error()//错误图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .override(500, 500)
                .skipMemoryCache(false)
                .priority(Priority.HIGH);
        ImageLoadConfig cfg = new ImageLoadConfig.Builder().
                setAsBitmap(true).setOptions(options).build();

        return cfg;
    }


    /**
     * 获取图片下载配置信息
     *
     * @param context
     * @param resId   加载中和加载失败的图片
     * @return
     */
    public static ImageLoadConfig getDefaultImageLoadConfig(Context context, int resId) {
        RequestOptions options = new RequestOptions()
                .placeholder(resId)//加载中图片
                .error(resId)//错误图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .skipMemoryCache(false)
                .priority(Priority.HIGH);

        ImageLoadConfig cfg = new ImageLoadConfig.Builder().
                setAsBitmap(true).setOptions(options).build();

        return cfg;
    }

    /**
     * 圆形图片加载配置
     *
     * @param context
     * @param resId   加载中和加载失败的图片
     * @return
     */
    public static ImageLoadConfig getCircleImageLoadConfig(Context context, int resId) {
        RequestOptions options = new RequestOptions()
                .transform(new GlideCircleTransformation())
                .placeholder(resId)//加载中图片
                .error(resId)//错误图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .skipMemoryCache(false)
                .priority(Priority.HIGH);

        ImageLoadConfig cfg = new ImageLoadConfig.Builder().
                setAsBitmap(true).setOptions(options).build();

        return cfg;
    }

    /**
     * 圆角图片加载配置
     *
     * @param context
     * @param resId   加载中和加载失败的图片
     * @param radus   圆角角度
     * @return
     */
    public static ImageLoadConfig getCornerImageLoadConfig(Context context, int resId, int radus) {
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(radus))
                .placeholder(resId)//加载中图片
                .error(resId)//错误图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .skipMemoryCache(false)
                .priority(Priority.HIGH);

        ImageLoadConfig cfg = new ImageLoadConfig.Builder().
                setAsBitmap(true).setOptions(options).build();

        return cfg;
    }

}
