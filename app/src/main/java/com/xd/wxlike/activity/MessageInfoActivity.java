package com.xd.wxlike.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivity;
import com.xd.wxlike.common.db.CommonDaoManager;
import com.xd.wxlike.common.db.DaoManager;
import com.xd.wxlike.common.entity.MessageEntity;

/**
 * Created by zhangxiaodi on 2018/4/4.01:07
 */

public class MessageInfoActivity extends BaseActivity {

    public static final String MESSAGEID = "messageId";

    private RecyclerView mZanRc;
    private LinearLayout mLikeLl;
    private RelativeLayout mReplyRl;
    private RecyclerView mReplyRc;
    private ImageView userIv;
    private TextView userNameTv;
    private TextView messageContentTv;
    private LinearLayout urlLl;
    private ImageView urlIv;
    private TextView urlTitleTv;
    private RelativeLayout imagesRl;
    private ImageView oneImage;
    private RecyclerView imagesRc;
    private TextView messageTimeTv;
    private TextView messageDelete;


    private MessageEntity messageEntity;
    private int messageId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ((TextView)findViewById(R.id.title)).setText("详情");
        messageId = getIntent().getIntExtra(MESSAGEID,-1);
        findViewById(R.id.right_image1).setVisibility(View.VISIBLE);
        findViewById(R.id.right_image1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置消息点赞数量
                Intent intent = new Intent(MessageInfoActivity.this,SelectUserActivity.class);
                startActivity(intent);
            }
        });
        initView();
        getMessageInfo();
    }

    /**
     * 获取消息内容
     */
    private void getMessageInfo() {
        messageEntity = CommonDaoManager.getMesageDaoManager().getMessageInfoById(messageId);
        //根据messageId查询该条信息点赞的人


    }

    private void initView() {
        userIv = findViewById(R.id.userAvator);
        userNameTv = findViewById(R.id.userName);
        messageContentTv = findViewById(R.id.message_content);
        urlLl = findViewById(R.id.urlLl);
        urlIv = findViewById(R.id.linkImage);
        urlTitleTv = findViewById(R.id.urlTitle);
        imagesRl = findViewById(R.id.imageRl);
        oneImage = findViewById(R.id.oneImage);
        imagesRc = findViewById(R.id.imageRc);
        messageTimeTv = findViewById(R.id.messageTime);
        messageDelete = findViewById(R.id.messageDelete);

        mReplyRc = findViewById(R.id.userReplayRc);
        mReplyRl = findViewById(R.id.reply_rl);
        mLikeLl = findViewById(R.id.zan_ll);
        mZanRc = findViewById(R.id.zanRc);



    }




}
