package com.xd.wxlike.common.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.xd.wxlike.R;

public class SelectTypeDialog extends AlertDialog {

    private Context context;
    private View.OnClickListener listener;

    protected SelectTypeDialog(@NonNull Context context, View.OnClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
        initView();
    }

    protected SelectTypeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectTypeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_select_type,null);



    }
}
