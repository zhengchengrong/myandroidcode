package com.jg.myproject.module.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jg.myproject.api.Const;
import com.jg.myproject.receiver.ReLoadLoginReceiver;
import com.jg.myproject.utils.ActivityCollector;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.vondear.rxtools.RxLogUtils;
import com.vondear.rxtools.RxNetUtils;
import com.vondear.rxtools.view.RxToast;
import com.zcr.myproject.R;
import com.jg.myproject.module.logins.LoginActivity;
import com.jg.myproject.widget.EmptyLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by long on 2016/8/19.
 * 基类Activity
 */
public abstract class BaseActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView, EmptyLayout.OnRetryListener {
    /**
     * 把 EmptyLayout 放在基类统一处理，@Nullable 表明 View 可以为 null，详细可看 ButterKnife
     */
    @Nullable
    @BindView(R.id.empty_layout)
    protected EmptyLayout mEmptyLayout;
    /**
     * 把 Presenter 提取到基类需要配合基类的 initInjector() 进行注入，如果继承这个基类则必定要提供一个 Presenter 注入方法，
     * 该APP所有 Presenter 都是在 Module 提供注入实现，也可以选择提供另外不带 Presenter 的基类
     */
    @Inject
    protected T mPresenter;
    @Nullable
    protected TextView mTvTitle;
    @Nullable
    protected TextView mOther;
    @Nullable
    protected TextView mTvBack;


    ReLoadLoginReceiver receiver;

    /**
     * 绑定布局文件
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();
    /**
     * Dagger 注入
     */
    protected abstract void initInjector();
    /**
     * 初始化视图控件
     */
    protected abstract void initViews();
    /**
     * 更新视图控件
     */
    protected abstract void updateViews(boolean isRefresh);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        ButterKnife.bind(this);
        // 管理所有的activity
        ActivityCollector.addActivity(this);
        mEmptyLayout = (EmptyLayout) this.findViewById(R.id.empty_layout);
        mTvTitle = (TextView) this.findViewById(R.id.tv_title);// 标题
        mOther = (TextView) this.findViewById(R.id.other); // 最右边的按钮
        mTvBack = (TextView) this.findViewById(R.id.tv_back); //左边的按钮
        initInjector();
        initViews();
        updateViews(false);
        if(!RxNetUtils.isAvailable(this)){
            showNetError();
        }
    }



    @Override
    public void showLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
        }
    }

    @Override
    public void hideLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.hide();
        }
    }
    QMUITipDialog tipDialog;
    // 网络连接错误
    @Override
    public void showNetError() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
            mEmptyLayout.setRetryListener(this);
        }else{

            RxToast.showToast(Const.NET_ERROR);
        }
    }

    // 如果网络连接错误，点击后重新向后台申请数据
    @Override
    public void onRetry() {
        updateViews(false);
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }


    // 跳转到登录页面
    @Override
    public void toLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    // 跳转到下个页面
    public void toNextActivity(Class activityClass,Boolean isFinish){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        if(isFinish){
        finish();
        }
    }
    // 跳转到下个页面并携带参数
    public void toNextActivityAndParams(Class activityClass,Bundle bundle){
        Intent intent = new Intent(this, activityClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    // 跳转到下个页面带动画效果和参数
    public void toNextActivityAndParamsAnim(Class activityClass,Bundle bundle){
        Intent intent = new Intent(this, activityClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    // 跳转到下个页面带动画效果 淡入淡出
    public void toNextActivityAndAnim(Class activityClass,Boolean isFinish){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        if(isFinish){
        finish();
    }
}

    // 初始化标题 isShowBack 有没有返回箭头 title 标题
    public void initTitle(boolean isShowBack,String title) {
        if(isShowBack){
            mTvBack.setVisibility(View.VISIBLE);
            mTvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }else{
            mTvBack.setVisibility(View.GONE);
        }
        mTvTitle.setText(title);
    }
    // 初始化标题 isShowBack 有没有返回箭头 title 标题 id表示右边按钮的图标
    public void initTitle(boolean isShowBack,String title,int id) {
        if(isShowBack){
            mTvBack.setVisibility(View.VISIBLE);
            mTvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }else{
            mTvBack.setVisibility(View.GONE);
        }
        mTvTitle.setText(title);
        mOther.setVisibility(View.VISIBLE);
        mOther.setBackgroundResource(id);
    }
    // 初始化标题 isShowBack 有没有返回箭头 title 标题 other表示右边按钮的文本
    public void initTitle(boolean isShowBack,String title,String other) {
        if(isShowBack){
            mTvBack.setVisibility(View.VISIBLE);
            mTvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }else{
            mTvBack.setVisibility(View.GONE);
        }
        mTvTitle.setText(title);
        mOther.setVisibility(View.VISIBLE);
        mOther.setText(other);
    }
    /**
     * 初始化 Toolbar
     *
     * @param toolbar
     * @param homeAsUpEnabled
     * @param title
     */
    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, int resTitle) {
        initToolBar(toolbar, homeAsUpEnabled, getString(resTitle));
    }






    // 登陆过期，发送登陆失效广播
    public void showToast(String msg) {
        RxLogUtils.d("showToast  " + msg);
        if (!TextUtils.isEmpty(msg)) {
            if (msg.equals(Const.RELOAD_LOGIN_RESPONSE)) { // 处理token过期
                RxToast.showToast(Const.RELOAD_LOGIN_MESSAGE);
                sendBroadcast(new Intent(Const.RELOAD_LOGIN)); //发送广播，跳转到登录页面。
            } else
                RxToast.showToast(this, msg, Toast.LENGTH_SHORT);
        } else {

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter fliter=new IntentFilter();
        fliter.addAction(Const.RELOAD_LOGIN);
        receiver=new ReLoadLoginReceiver();
        registerReceiver(receiver, fliter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);// 注销广播
        ActivityCollector.removeActivity(this);//移除当前Activity
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
