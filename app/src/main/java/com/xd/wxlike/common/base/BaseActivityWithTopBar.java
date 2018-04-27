package com.xd.wxlike.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.xd.wxlike.R;
import com.xd.wxlike.common.utils.MathUtil;


/**
 * Created by zhangxiaodi1 on 2017/12/26.
 */

public class BaseActivityWithTopBar extends BaseActivity {

    private TextView mTitleTv;
    private ImageView rightImage;
    private ImageView rightIv;
    private ImageView backIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(int layoutResID) {
        RelativeLayout root = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_common, null);
        MathUtil.setStatusBarHeigh(root.findViewById(R.id.titleBar),root.findViewById(R.id.statusBar));
        mTitleTv = root.findViewById(R.id.title);
        rightImage = root.findViewById(R.id.right_image1);
        rightIv = root.findViewById(R.id.right_image2);
        backIv = root.findViewById(R.id.back);
        initToolBar();
        LinearLayout container = root.findViewById(R.id.root_layout);
        LayoutInflater.from(this).inflate(layoutResID, container);
        super.setContentView(root);
    }

    @Override
    public void setContentView(View view) {
        RelativeLayout root = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_common, null);
        MathUtil.setStatusBarHeigh(root.findViewById(R.id.titleBar),root.findViewById(R.id.statusBar));
        mTitleTv = root.findViewById(R.id.title);
        rightImage = root.findViewById(R.id.right_image1);
        rightIv = root.findViewById(R.id.right_image2);
        backIv = root.findViewById(R.id.back);
        initToolBar();
        LinearLayout container = root.findViewById(R.id.root_layout);
        container.addView(view);
        super.setContentView(root);
    }

    /**
     * 设置返回按钮
     */
    private void initToolBar() {
        if (backIv != null) {
            backIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }


    public void setTitle(String title) {
        if (!StringUtils.isEmpty(title) && mTitleTv != null) {
            mTitleTv.setText(title);
        }
    }

    public void setTitle(int resId) {
        if (mTitleTv != null) {
            mTitleTv.setText(getResources().getText(resId));
        }
    }

    /**
     * 设置
     *
     * @param resId
     * @param isShow
     */
    public void setRightImage1(int resId, boolean isShow, View.OnClickListener listener) {
        if (rightImage != null) {
            if(resId>0) {
                rightImage.setImageResource(resId);
            }
            if (isShow) {
                rightImage.setVisibility(View.VISIBLE);
            } else {
                rightImage.setVisibility(View.GONE);
            }
            if (listener != null) {
                rightImage.setOnClickListener(listener);
            }
        }
    }
    /**
     * 设置
     *
     * @param resId
     * @param isShow
     */
    public void setRightImage2(int resId, boolean isShow, View.OnClickListener listener) {
        if (rightIv != null) {
            rightIv.setImageResource(resId);
            if (isShow) {
                rightIv.setVisibility(View.VISIBLE);
            } else {
                rightIv.setVisibility(View.GONE);
            }
            if (listener != null) {
                rightIv.setOnClickListener(listener);
            }
        }
    }
}
