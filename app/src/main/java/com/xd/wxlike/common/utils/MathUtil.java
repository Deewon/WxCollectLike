package com.xd.wxlike.common.utils;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;


import com.blankj.utilcode.util.ConvertUtils;
import com.xd.wxlike.MyApplication;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangxiaodi1 on 2017/12/23.
 */

public class MathUtil {


    private static double EARTH_RADIUS = 6371.393;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 保留两位小数
     *
     * @param num
     * @return
     */
    public static float saveTwoDecimals(float num) {
        BigDecimal b = new BigDecimal(num);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (null == str || str.length() == 0) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将屏幕尺寸四舍五入为1位小数的double值
     *
     * @param screenInches
     * @return
     */
    public static double saveOneDecimals(double screenInches) {
        BigDecimal bigDecimal = new BigDecimal(screenInches);
        return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 初始化价格
     *
     * @param num          如果小于等于0  则返回免费
     * @param reserveCount 保留价格位数，默认两位
     * @return
     */
    public static String showDecimalNum(double num, int reserveCount) {
        if (reserveCount == 0) {
            return new BigDecimal("" + num).setScale(0, BigDecimal.ROUND_HALF_UP) + "";
        }
        DecimalFormat decimalFormat = null;
        if (reserveCount == 1) {
            decimalFormat = new DecimalFormat("0.0");
        } else {
            decimalFormat = new DecimalFormat("0.00");
        }
        return decimalFormat.format(num);
    }


    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }



    /**
     * 设置状态栏填充控件高度
     * @param toolbar
     * @param statusBarView
     */
    public static void setStatusBarHeigh(View toolbar,int toolbarHeighDp,View statusBarView){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            RelativeLayout.LayoutParams params = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, MathUtil.getStatusBarHeight());
            statusBarView.setLayoutParams(params);
            statusBarView.setVisibility(View.VISIBLE);
            if(toolbar!=null) {
                RelativeLayout.LayoutParams toolBarParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
                toolBarParams.height = MathUtil.getStatusBarHeight() + ConvertUtils.dp2px(toolbarHeighDp);
                toolbar.setLayoutParams(toolBarParams);
            }
        }else{
            RelativeLayout.LayoutParams params = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 0);
            statusBarView.setLayoutParams(params);
            statusBarView.setVisibility(View.GONE);
            if(toolbar!=null) {
                RelativeLayout.LayoutParams toolBarParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
                toolBarParams.height = ConvertUtils.dp2px(toolbarHeighDp);
                toolbar.setLayoutParams(toolBarParams);
            }
        }
    }

    /**
     * 获取状态栏的高度
     */
    public static int getStatusBarHeight() {
        int statusBarHeightId = MyApplication.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return MyApplication.getInstance().getResources().getDimensionPixelOffset(statusBarHeightId);
    }
}
