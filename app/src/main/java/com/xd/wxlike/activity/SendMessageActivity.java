package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;

/**
 * Created by zhangxiaodi1 on 2018/4/23.
 */

public class SendMessageActivity extends BaseActivityWithTopBar {


    private EditText messageEt;
    private LinearLayout urlLl;
    private EditText urlEt;
    private LinearLayout imageLl;
    private Button selectImageBtn;
    private RecyclerView imageShowRc;
    private Button selectTimeBtn;
    private TextView timeShowTv;
    private Button selectUserBtn;
    private ImageView userHeadIv;
    private TextView userNameTv;


    //0：文本；1：链接；2：图片
    private int type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        initView();
        type = getIntent().getIntExtra("type",-1);
        if(type==0){
            urlLl.setVisibility(View.GONE);
            imageLl.setVisibility(View.GONE);
        }else if(type==1){
            urlLl.setVisibility(View.VISIBLE);
            imageLl.setVisibility(View.GONE);
        }else if(type==2){
            urlLl.setVisibility(View.GONE);
            imageLl.setVisibility(View.VISIBLE);
        }else{
            finish();
        }

    }


    private void initView() {
        messageEt = findViewById(R.id.messageinfo);
        urlLl = findViewById(R.id.urlLl);
        urlEt = findViewById(R.id.urlEt);
        imageLl = findViewById(R.id.imageLl);
        selectImageBtn = findViewById(R.id.select_image);
        imageShowRc = findViewById(R.id.showPic);
        selectTimeBtn = findViewById(R.id.selectTime);
        timeShowTv = findViewById(R.id.showTime);
        selectUserBtn = findViewById(R.id.selectUser);
        userHeadIv = findViewById(R.id.showUserImage);
        userNameTv = findViewById(R.id.showUserName);
    }
}
