package com.xd.wxlike.common.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.xd.wxlike.R;

public class SelectTypeDialog extends AlertDialog {

    public static int TYPE_TEXT = 0;
    public static int TYPE_URL = 1;
    public static int TYPE_IMAGE = 2;


    private Context context;
    private OnTypeClickListener listener;

    public SelectTypeDialog(@NonNull Context context, OnTypeClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;




        initView();
    }


    protected SelectTypeDialog(@NonNull Context context){
        super(context);
    }

    protected SelectTypeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectTypeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }



    private void initView() {
        Builder builder = new Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_select_type,null);
        view.findViewById(R.id.textType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClick(SelectTypeDialog.this,TYPE_TEXT);
                }
            }
        });
        view.findViewById(R.id.textType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClick(SelectTypeDialog.this,TYPE_URL);
                }
            }
        });
        view.findViewById(R.id.textType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClick(SelectTypeDialog.this,TYPE_IMAGE);
                }
            }
        });
        view.findViewById(R.id.textType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    dismiss();
                }
            }
        });
        builder.setView(view);
        builder.create();
        show();
    }

}
