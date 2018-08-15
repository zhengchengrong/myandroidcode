package com.jg.myproject;

import android.Manifest;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jg.myproject.api.Const;
import com.jg.myproject.api.RetrofitFactory;
import com.jg.myproject.module.base.BaseActivity;
import com.jg.myproject.module.base.IBaseView;
import com.jg.myproject.module.home.HomeActivity;
import com.jg.myproject.module.logins.LoginActivity;
import com.jg.myproject.utils.RxSPTool;
import com.zcr.myproject.R;

import kr.co.namee.permissiongen.PermissionGen;


/**
 * Created by llz on 2018/3/28.
 */
public class WelcomeActitivy extends BaseActivity implements IBaseView{

    TextView textbottom;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initInjector() {

    }
    @Override
    protected void initViews() {
        textbottom =  findViewById(R.id.textbottom);
    }

    @Override
    protected void updateViews(boolean isRefresh) {

        String strUrl  = RxSPTool.getString(this, Const.MYURL);
        if(!TextUtils.isEmpty(strUrl)){
            RetrofitFactory.My_URL = strUrl;
        }
        textbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = RxSPTool.getString(WelcomeActitivy.this,Const.USERNAME);
                if(TextUtils.isEmpty(username)) {
                    toNextActivityAndAnim(LoginActivity.class,true);
                }else{
                    toNextActivityAndAnim(HomeActivity.class,true);
                }
            }
        });

        //存储授权
        PermissionGen.with(WelcomeActitivy.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO,Manifest.permission.WAKE_LOCK,Manifest.permission.SYSTEM_ALERT_WINDOW)
                .request();
    }
}
