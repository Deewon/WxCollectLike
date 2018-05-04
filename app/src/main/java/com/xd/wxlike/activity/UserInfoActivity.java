package com.xd.wxlike.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;
import com.xd.wxlike.common.db.CommonDaoManager;
import com.xd.wxlike.common.entity.UserEntity;
import com.xd.wxlike.common.imageload.ImageLoader;

import java.io.File;

/**
 * Created by zhangxiaodi1 on 2018/4/7.
 *
 * 查看用户信息界面
 *
 */

public class UserInfoActivity extends BaseActivityWithTopBar {


    private ImageView userHeadIv;
    private TextView userNameTv;
    private TextView userWxidTv;
    private TextView userNickTv;
    private TextView userAddressTv;


    private UserEntity userEntity;

    private String wxid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_user_info);
        wxid = getIntent().getStringExtra("wxid");
        if(!StringUtils.isEmpty(wxid)){
            userEntity = CommonDaoManager.getUserInfoDaoManger().getUserInfoByWXID(wxid);
        }else{
            finish();
        }
        if(userEntity!=null){
            //初始化控件
            initView();
        }else{
            finish();
        }

    }

    /**
     *
     */
    private void initView() {
        userHeadIv = findViewById(R.id.user_image);
        userNameTv = findViewById(R.id.username);
        userWxidTv = findViewById(R.id.wxid);
        userNickTv = findViewById(R.id.wxnickname);
        userAddressTv = findViewById(R.id.userAddress);

        userWxidTv.setText(userEntity.getUserWxid());
        if(!TextUtils.isEmpty(userEntity.getNickName())) {
            userNickTv.setVisibility(View.VISIBLE);
            userNickTv.setText(userEntity.getNickName());
        }else{
            userNickTv.setVisibility(View.GONE);
        }
        if(!TextUtils.isEmpty(userEntity.getUserName())) {
            userNameTv.setText(userEntity.getUserName());
        }
        if(!TextUtils.isEmpty(userEntity.getUserImage())) {
            ImageLoader.load(this, userHeadIv, new File(userEntity.getUserImage()), null, null);
        }
        if(!TextUtils.isEmpty(userEntity.getUserAddress())){
            userAddressTv.setText(userEntity.getUserAddress());
        }else{
            userAddressTv.setText("");
        }
    }
}
