package com.xd.wxlike.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivity;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;
import com.xd.wxlike.common.utils.MathUtil;

public class MainActivity extends BaseActivity {


    private RecyclerView messageRc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView)findViewById(R.id.title)).setText("我的相册");
        MathUtil.setStatusBarHeigh(findViewById(R.id.titleBar),50,findViewById(R.id.statusBar));
        setTitle("我的相册");
        findViewById(R.id.right_image1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹窗选择消息类型


            }
        });


    }

    /**
     * 选择消息类型
     */
    private void initMessageStyle() {


        PopupWindow popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_select_type,null);

        popupWindow.setContentView(view);

    }
}
