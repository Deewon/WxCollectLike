package com.xd.wxlike.common.imageload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xd.wxlike.MyApplication;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * Created by sunfusheng on 2017/6/6.
 */
public class ImageLoader {

    //默认配置
    public static ImageLoadConfig defConfig = ImageConfigUtils.getDefaultImageLoadConfig(MyApplication.getInstance());


    private static final String ANDROID_RESOURCE = "android.resource://";
    private static final String FILE = "file://";
    private static final String SEPARATOR = "/";
    private static final String HTTP = "http";

    private static WeakReference<ImageView> mImageView;
    private static Object mImageUrlObj;
    private static long mTotalBytes = 0;
    private static long mLastBytesRead = 0;
    private static boolean mLastStatus = false;
    private static Handler mMainThreadHandler;

    private static OnGlideImageViewListener onGlideImageViewListener;

    public static ImageLoader create(ImageView imageView) {
        return new ImageLoader(imageView);
    }

    private ImageLoader(ImageView imageView) {
        mImageView = new WeakReference<>(imageView);
        mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public ImageView getImageView() {
        if (mImageView != null) {
            return mImageView.get();
        }
        return null;
    }

    public Context getContext() {
        if (getImageView() != null) {
            return getImageView().getContext();
        }
        return null;
    }

    public String getImageUrl() {
        if (mImageUrlObj == null) {
            return null;
        }
        if (!(mImageUrlObj instanceof String)) {
            return null;
        }
        return (String) mImageUrlObj;
    }

    public Uri resId2Uri(int resourceId) {
        if (getContext() == null) {
            return null;
        }
        return Uri.parse(ANDROID_RESOURCE + getContext().getPackageName() + SEPARATOR + resourceId);
    }

    public static void loadImage(ImageView view, String imageUrl, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, imageUrl, config, listener);
    }

    public static void loadFile(ImageView view, File file, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, file, config, listener);
    }

    public static void loadResId(ImageView view, Integer resourceId, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, resourceId, config, listener);
    }

    public static void loadUri(ImageView view, Uri uri, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, uri, config, listener);
    }

    public static void loadGif(ImageView view, String gifUrl, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, gifUrl, ImageLoadConfig.parseBuilder(config).setAsGif(true).build(), listener);
    }

    public static void loadGifResId(ImageView view, Integer resourceId, ImageLoadConfig config, LoaderListener listener) {
        load(view.getContext(), view, resourceId, ImageLoadConfig.parseBuilder(config).setAsGif(true).build(), listener);
    }

    public static void loadTarget(Context context, Object objUrl, ImageLoadConfig config, final LoaderListener listener) {
        load(context, null, objUrl, config, listener);
    }

    public static void load(Context context, ImageView imageView, Object objUrl, ImageLoadConfig config, LoaderListener listener) {
        if (imageView == null || objUrl == null) {
            return;
        }

        if (null != config) {
            defConfig = config;
        }
        mImageView = new WeakReference<>(imageView);
        mMainThreadHandler = new Handler(Looper.getMainLooper());
        mImageUrlObj = objUrl;

        if (defConfig.isAsGif()) {
            RequestBuilder<GifDrawable> builder = Glide.with(context).asGif().load(objUrl).apply(defConfig.getOptions()).transition(DrawableTransitionOptions.withCrossFade());
            builder.into(imageView);
        } else if (defConfig.isAsBitmap()) {
            RequestBuilder<Bitmap> builder = Glide.with(context).asBitmap().load(objUrl).apply(defConfig.getOptions()).listener(new
                                                                                                                                        RequestListener<Bitmap>() {
                                                                                                                                            @Override
                                                                                                                                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                                                                                                                                                mainThreadCallback(mLastBytesRead, mTotalBytes, true, null);
                                                                                                                                                return false;
                                                                                                                                            }

                                                                                                                                            @Override
                                                                                                                                            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                                                                                                                                                mainThreadCallback(mLastBytesRead, mTotalBytes, true, null);
                                                                                                                                                return false;
                                                                                                                                            }
                                                                                                                                        });
            builder.into(imageView);
        } else if (defConfig.isCrossFade()) {
            RequestBuilder<Drawable> builder = Glide.with(context).load(objUrl).transition(DrawableTransitionOptions.withCrossFade());
            builder.into(imageView);
        }

    }


//    public RequestBuilder<Drawable> requestBuilder(Object obj, RequestOptions options) {
//        this.mImageUrlObj = obj;
//        return Glide.with(getContext())
//                .load(obj)
//                .apply(options)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        mainThreadCallback(mLastBytesRead, mTotalBytes, true, e);
//                        ProgressManager.removeProgressListener(internalProgressListener);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        mainThreadCallback(mLastBytesRead, mTotalBytes, true, null);
//                        ProgressManager.removeProgressListener(internalProgressListener);
//                        return false;
//                    }
//                });
//    }

    private void addProgressListener() {
        if (getImageUrl() == null) {
            return;
        }
        final String url = getImageUrl();
        if (!url.startsWith(HTTP)) {
            return;
        }

//        internalProgressListener = new OnProgressListener() {
//            @Override
//            public void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone, GlideException exception) {
//                if (totalBytes == 0) {
//                    return;
//                }
//                if (!url.equals(imageUrl)) {
//                    return;
//                }
//                if (mLastBytesRead == bytesRead && mLastStatus == isDone) {
//                    return;
//                }
//
//                mLastBytesRead = bytesRead;
//                mTotalBytes = totalBytes;
//                mLastStatus = isDone;
//                mainThreadCallback(bytesRead, totalBytes, isDone, exception);
//
////                if (isDone) {
////                    ProgressManager.removeProgressListener(this);
////                }
//            }
//        };
//        ProgressManager.addProgressListener(internalProgressListener);
    }

    private static void mainThreadCallback(final long bytesRead, final long totalBytes, final boolean isDone, final GlideException exception) {
        mMainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                final int percent = (int) ((bytesRead * 1.0f / totalBytes) * 100.0f);
//                if (onProgressListener != null) {
//                    onProgressListener.onProgress((String) mImageUrlObj, bytesRead, totalBytes, isDone, exception);
//                }

                if (onGlideImageViewListener != null) {
                    onGlideImageViewListener.onProgress(percent, isDone, exception);
                }
            }
        });
    }

    public void setOnGlideImageViewListener(String imageUrl, OnGlideImageViewListener onGlideImageViewListener) {
        mImageUrlObj = imageUrl;
        ImageLoader.onGlideImageViewListener = onGlideImageViewListener;
//        addProgressListener();
    }

//    public void setOnProgressListener(String imageUrl, OnProgressListener onProgressListener) {
//        mImageUrlObj = imageUrl;
////        ImageLoader.onProgressListener = onProgressListener;
////        addProgressListener();
//    }
}
