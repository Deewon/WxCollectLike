package com.xd.wxlike.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;
import com.xd.wxlike.common.dialog.SelectTypeDialog;

import java.util.Calendar;

/**
 * Created by zhangxiaodi1 on 2018/4/23.
 */

public class SendMessageActivity extends BaseActivityWithTopBar implements View.OnClickListener{
    public static String TYPE_KEY = "messageType";

    private EditText messageEt;
    private LinearLayout urlLl;
    private EditText urlEt;
    private EditText urlTitleEt;
    private Button analysisUrlBtn;
    private Button setUrlTitleBtn;
    private TextView urlTitleTv;
    private LinearLayout imageLl;
    private Button selectImageBtn;
    private RecyclerView imageShowRc;
    private LinearLayout selectTimeBtn;
    private TextView timeShowTv;
    private LinearLayout selectUserBtn;
    private ImageView userHeadIv;
    private TextView userNameTv;


    private TimePicker tp = null;
    private DatePicker dp = null;
    private Calendar calendar = null;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;

    //0：文本；1：链接；2：图片
    private int type;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        initView();
        type = getIntent().getIntExtra(TYPE_KEY, -1);
        if (type >= 0) {
            if (type == SelectTypeDialog.TYPE_TEXT) {
                urlLl.setVisibility(View.GONE);
                imageLl.setVisibility(View.GONE);
            } else if (type == SelectTypeDialog.TYPE_URL) {
                urlLl.setVisibility(View.VISIBLE);
                imageLl.setVisibility(View.GONE);
            } else if (type == SelectTypeDialog.TYPE_IMAGE) {
                urlLl.setVisibility(View.GONE);
                imageLl.setVisibility(View.VISIBLE);
            }

        } else {
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
        urlTitleEt = findViewById(R.id.urlTitleEt);
        urlTitleTv = findViewById(R.id.urlTitle);
        analysisUrlBtn = findViewById(R.id.showUrlContent);
        setUrlTitleBtn = findViewById(R.id.showUrlTitle);

        analysisUrlBtn.setOnClickListener(this);
        setUrlTitleBtn.setOnClickListener(this);
        selectTimeBtn.setOnClickListener(this);
        selectUserBtn.setOnClickListener(this);
        imageShowRc.setLayoutManager(new GridLayoutManager(this,3));


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showUrlContent:
                //解析url展示链接分享信息

                break;
            case R.id.showUrlTitle:
                //标题与分享的标题不一致，自定义设置标题

                break;
            case R.id.selectTime:
                //设置分享时间

                break;
            case R.id.selectUser:
                //选择分享人

                break;
        }
    }
}
