package com.xd.wxlike.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.blankj.utilcode.util.ActivityUtils;
import com.xd.wxlike.R;
import com.xd.wxlike.base.BaseActivityWithTopBar;

public class MainActivity extends BaseActivityWithTopBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("我的相册");
        setRightImage1(0, true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入设置界面，设置需要发表的内容

                initMessageStyle();

                ActivityUtils.startActivity(SettingActivity.class);

            }
        });


    }

    /**
     * 选择消息类型
     */
    private void initMessageStyle() {


        PopupWindow popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.pop_select_messagestyle,null);

        popupWindow.setContentView(view);

    }
}
