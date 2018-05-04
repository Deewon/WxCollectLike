package com.xd.wxlike.common.imageload;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.AppWidgetTarget;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by zhangxiaodi1 on 2017/12/26.
 */

public class ImageLoadConfig {

    private boolean crossFade; //是否淡入淡出动画
    private OverrideSize size; //图片最终显示在ImageView上的宽高度像素
    private int crossDuration; //淡入淡出动画持续的时间
    private boolean asGif; //true,强制显示的是gif动画,如果url不是gif的资源,那么会回调error()
    private boolean asBitmap;//true,强制显示为常规图片,如果是gif资源,则加载第一帧作为图片
    private float thumbnail;//设置缩略图的缩放比例0.0f-1.0f,如果缩略图比全尺寸图先加载完，就显示缩略图，否则就不显示
    private String thumbnailUrl;//设置缩略图的url,如果缩略图比全尺寸图先加载完，就显示缩略图，否则就不显示
    private SimpleTarget simpleTarget; //指定simpleTarget对象,可以在Target回调方法中处理bitmap,同时该构造方法中还可以指定size
    private ViewTarget viewTarget;//指定viewTarget对象,可以是自定义View,该构造方法传入的view和通配符的view是同一个
    private NotificationTarget notificationTarget; //设置通知栏加载大图片的target;
    private AppWidgetTarget appWidgetTarget;//设置加载小部件图片的target
    private Integer animResId;//图片加载完后的动画效果,在异步加载资源完成时会执行该动画。
    private boolean rotate;//旋转图片
    private int rotateDegree;//默认旋转°
    private String tag; //唯一标识
    private BitmapTransformation bitmapTransformation;
    private RequestOptions options;

    private ImageLoadConfig(Builder builder) {
        this.crossFade = builder.crossFade;
        this.size = builder.size;
        this.crossDuration = builder.crossDuration;
        this.asGif = builder.asGif;
        this.asBitmap = builder.asBitmap;
        this.thumbnail = builder.thumbnail;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.simpleTarget = builder.simpleTarget;
        this.viewTarget = builder.viewTarget;
        this.notificationTarget = builder.notificationTarget;
        this.appWidgetTarget = builder.appWidgetTarget;
        this.animResId = builder.animResId;
        this.rotate = builder.rotate;
        this.rotateDegree = builder.rotateDegree;
        this.tag = builder.tag;
        this.bitmapTransformation = builder.bitmapTransformation;
        this.options = builder.options;

    }


    /**
     * Builder类
     */
    public static class Builder {
        private boolean crossFade;
        private OverrideSize size;
        private int crossDuration;
        private boolean asGif;
        private boolean asBitmap;
        private float thumbnail;
        private String thumbnailUrl;
        private SimpleTarget simpleTarget;
        private ViewTarget viewTarget;
        private NotificationTarget notificationTarget;
        private AppWidgetTarget appWidgetTarget;
        private Integer animResId;
        private boolean rotate;
        private int rotateDegree = 90;
        private String tag;
        private BitmapTransformation bitmapTransformation;
        private RequestOptions options;


        public Builder setCrossFade(boolean crossFade) {
            this.crossFade = crossFade;
            return this;
        }

        public Builder setCrossDuration(int crossDuration) {
            this.crossDuration = crossDuration;
            return this;
        }

        public Builder setAsGif(boolean asGif) {
            this.asGif = asGif;
            return this;
        }

        public Builder setAsBitmap(boolean asBitmap) {
            this.asBitmap = asBitmap;
            return this;
        }

        public void setSize(OverrideSize size) {
            this.size = size;
        }

        public Builder setThumbnail(float thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setSimpleTarget(SimpleTarget simpleTarget) {
            this.simpleTarget = simpleTarget;
            return this;
        }

        public Builder setViewTarget(ViewTarget viewTarget) {
            this.viewTarget = viewTarget;
            return this;
        }

        public Builder setNotificationTarget(NotificationTarget notificationTarget) {
            this.notificationTarget = notificationTarget;
            return this;
        }

        public Builder setAppWidgetTarget(AppWidgetTarget appWidgetTarget) {
            this.appWidgetTarget = appWidgetTarget;
            return this;
        }

        public Builder setAnimResId(Integer animResId) {
            this.animResId = animResId;
            return this;
        }

        public Builder setRotate(boolean rotate) {
            this.rotate = rotate;
            return this;
        }

        public Builder setRotateDegree(int rotateDegree) {
            this.rotateDegree = rotateDegree;
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setBitmapTransformation(BitmapTransformation bitmapTransformation) {
            this.bitmapTransformation = bitmapTransformation;
            return this;
        }

        public RequestOptions getOptions() {
            return options;
        }

        public Builder setOptions(RequestOptions options) {
            this.options = options;
            return this;
        }

        public ImageLoadConfig build() {
            return new ImageLoadConfig(this);
        }
    }


    public static Builder parseBuilder(ImageLoadConfig config) {
        Builder builder = new Builder();
        builder.crossFade = config.crossFade;
        builder.crossDuration = config.crossDuration;
        builder.size = config.size;
        builder.asGif = config.asGif;
        builder.asBitmap = config.asBitmap;
        builder.thumbnail = config.thumbnail;
        builder.thumbnailUrl = config.thumbnailUrl;
        builder.simpleTarget = config.simpleTarget;
        builder.viewTarget = config.viewTarget;
        builder.notificationTarget = config.notificationTarget;
        builder.appWidgetTarget = config.appWidgetTarget;
        builder.animResId = config.animResId;
        builder.rotate = config.rotate;
        builder.rotateDegree = config.rotateDegree;
        builder.tag = config.tag;
        builder.options = config.options;
        return builder;
    }

    public boolean isCrossFade() {
        return crossFade;
    }

    public OverrideSize getSize() {
        return size;
    }

    public int getCrossDuration() {
        return crossDuration;
    }

    public boolean isAsGif() {
        return asGif;
    }

    public boolean isAsBitmap() {
        return asBitmap;
    }

    public float getThumbnail() {
        return thumbnail;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public SimpleTarget getSimpleTarget() {
        return simpleTarget;
    }

    public ViewTarget getViewTarget() {
        return viewTarget;
    }

    public NotificationTarget getNotificationTarget() {
        return notificationTarget;
    }

    public AppWidgetTarget getAppWidgetTarget() {
        return appWidgetTarget;
    }

    public Integer getAnimResId() {
        return animResId;
    }

    public boolean isRotate() {
        return rotate;
    }

    public int getRotateDegree() {
        return rotateDegree;
    }

    public String getTag() {
        return tag;
    }

    public BitmapTransformation getBitmapTransformation() {
        return bitmapTransformation;
    }

    public RequestOptions getOptions() {
        return options;
    }


    public static class OverrideSize {
        private final int width;
        private final int height;

        public OverrideSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
