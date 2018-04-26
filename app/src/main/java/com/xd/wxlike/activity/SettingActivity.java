package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.xd.wxlike.R;
import com.xd.wxlike.base.BaseActivityWithTopBar;
import com.xd.wxlike.entity.MessageEntity;
import com.xd.wxlike.entity.UserEntity;

import java.util.List;

/**
 * Created by zhangxiaodi1 on 2018/4/7.
 */

public class SettingActivity extends BaseActivityWithTopBar implements View.OnClickListener{

    private RelativeLayout selectUserImage;
    private EditText mWxIdEt;
    private EditText mWxNameEt;
    private EditText mMsgContentEt;
    private EditText mMsgUrlEt;
    private Button selectImageBtn;
    private RecyclerView selectImageRc;
    private Button commitBtn;

    private List<String> ImageUrlList;
    private String userAvator;
    private UserEntity userEntity;//选择需要点赞的人的身份
    private MessageEntity messageEntity;//发表的内容


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("设置分享内容");
        initView();


    }


    private void initView() {



        mMsgContentEt = findViewById(R.id.messageContent);
        mMsgUrlEt = findViewById(R.id.messageUrl);
        selectImageBtn = findViewById(R.id.select_image);
        selectImageRc = findViewById(R.id.showSelectImage);
        commitBtn = findViewById(R.id.commit);

        selectUserImage.setOnClickListener(this);
        selectImageBtn.setOnClickListener(this);
        commitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.selectUserImage:

                break;
            case R.id.select_image:

                break;
            case R.id.commit:

                break;
        }
    }
}
