package com.jg.myproject.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

import com.jg.myproject.api.Const;
import com.jg.myproject.module.logins.LoginActivity;
import com.jg.myproject.utils.ActivityCollector;

/**
 * Created by llz on 2018/8/15.
 */
public class ReLoadLoginReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        ActivityCollector.finishAll();
        Intent intentlogin = new Intent(context,LoginActivity.class);
        intentlogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentlogin); // 重新启动LoginActivity
    }
}
