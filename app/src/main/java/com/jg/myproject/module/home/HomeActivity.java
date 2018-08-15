package com.jg.myproject.module.home;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.jg.myproject.adapter.BannerAdapter2;
import com.jg.myproject.api.Const;
import com.jg.myproject.api.bean.UserBean;
import com.jg.myproject.module.base.BaseActivity;
import com.jg.myproject.utils.RxSPTool;
import com.jg.myproject.widget.NoScrollGridView;
import com.jg.myproject.widget.banner.BannerLayout;
import com.jg.myproject.widget.roundspinview.RoundSpinView;
import com.vondear.rxtools.view.RxToast;
import com.zcr.myproject.R;

import java.util.ArrayList;
import java.util.List;

import kr.co.namee.permissiongen.PermissionGen;


/**
 * Created by llz on 2018/3/29.
 */

public class HomeActivity extends BaseActivity implements RoundSpinView.onRoundSpinViewListener {




    private  String type;

    private BannerLayout  recyclerBanner;

    private RoundSpinView rsvTest;

    @Override
    protected int attachLayoutRes() {
        return R.layout.home_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
/*
        initTitle(false,"首页","注销");
*/
        type = RxSPTool.getString(this, Const.ACCOUNTTYPE);
        recyclerBanner =  findViewById(R.id.recycler);
        rsvTest = findViewById(R.id.rsv_test);
    }


    @Override
    protected void updateViews(boolean isRefresh) {
        BannerAdapter2 webBannerAdapter = new BannerAdapter2(this);
        webBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                RxToast.showToast("点击了第  " + position + "  项");
            }
        });
        recyclerBanner.setAdapter(webBannerAdapter);

        rsvTest.setOnRoundSpinViewListener(this);



    }

    @Override
    public void onSingleTapUp(int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "place:0", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this, "place:1", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "place:2", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
