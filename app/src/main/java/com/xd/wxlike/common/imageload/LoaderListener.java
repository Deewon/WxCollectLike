package com.xd.wxlike.common.imageload;

/**
 * Created by tanmojie on 2016/8/6.
 */
public interface LoaderListener {

    boolean onSuccess();//return true 代表自己处理imageview显示bitmap  return false   代表由Glide处理bitmap显示

    void onError();
}
