package com.xd.wxlike.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.xd.wxlike.MyApplication;
import com.xd.wxlike.R;
import com.xd.wxlike.common.base.BaseActivity;
import com.xd.wxlike.common.base.BaseActivityWithTopBar;
import com.xd.wxlike.common.dialog.OnTypeClickListener;
import com.xd.wxlike.common.dialog.SelectTypeDialog;
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
        findViewById(R.id.right_image1).setVisibility(View.VISIBLE);
        findViewById(R.id.right_image1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹窗选择消息类型
                showTypeDialog();
            }
        });


    }


    private void showTypeDialog(){
        //初始化字符串数组
        final String[] strArray = new String[]{"文本","链接","图片","取消"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);//实例化builder
        builder.setTitle("分享类型");//设置标题
        //设置列表
        builder.setItems(strArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this,SendMessageActivity.class);
                intent.putExtra(SendMessageActivity.TYPE_KEY,which);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.create().show();//创建并显示对话框
    }


}
