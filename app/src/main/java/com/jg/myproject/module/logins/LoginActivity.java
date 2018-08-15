package com.jg.myproject.module.logins;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jg.myproject.api.BaseObserver;
import com.jg.myproject.api.Const;
import com.jg.myproject.api.RetrofitFactory;
import com.jg.myproject.api.RxSchedulers;
import com.jg.myproject.api.bean.BaseEntity;
import com.jg.myproject.api.bean.UserBean;
import com.jg.myproject.module.base.BaseActivity;
import com.jg.myproject.module.base.IBaseView;
import com.jg.myproject.module.home.HomeActivity;
import com.jg.myproject.utils.RxSPTool;
import com.vondear.rxtools.view.RxToast;
import com.zcr.myproject.R;
import io.reactivex.Observable;

/**
 * Created by zhengchengrong on 2017/9/4.
 */
public class LoginActivity extends BaseActivity implements IBaseView ,View.OnClickListener {





    private TextView tvLogin;
    private EditText edUserName;
    private EditText edPassword;
    private ProgressDialog dialog;
    Spinner sptype;
    String type;
    private static final String[] types = {"施工项目部账号", "检测单位","勘察单位", "设计单位", "建设单位", "施工单位", "监理单位","监督站","监理项目部账号"};
    private ArrayAdapter<String> adapterAll;
    private ImageView iv_show_pwd;
    @Override
    protected int attachLayoutRes() {
        return  R.layout.activity_login;
    }
    @Override
    protected void initInjector() {
    }
    @Override
    protected void initViews() {
        iv_show_pwd = (ImageView) this.findViewById(R.id.iv_show_pwd);
        sptype  = (Spinner) this.findViewById(R.id.sp_login_type);
        sptype.setVisibility(View.VISIBLE);
        tvLogin = (TextView) this.findViewById( R.id.login);
        edUserName = (EditText) this.findViewById( R.id.phoneNum);
        edPassword = (EditText) this.findViewById( R.id.password);
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        adapterAll = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        //设置下拉列表的风格
        adapterAll.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        sptype.setAdapter(adapterAll);
        //添加事件Spinner事件监听
        sptype.setOnItemSelectedListener(new SpinnerSelectedListener());

        tvLogin.setOnClickListener(this);
        iv_show_pwd.setOnClickListener(this);


    }
    private boolean flag = false;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.login: // 登陆
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                if(TextUtils.isEmpty(username)){
                    RxToast.showToast(Const.INPUT_ACCOUNT);
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    RxToast.showToast(Const.INPUT_PASSWORD);
                    return;
                }
                dialog = new ProgressDialog(this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(true);
                dialog.setTitle("正在登录...");
                dialog.show();
                toLogin(username,password,type);
                break;
            case R.id.iv_show_pwd:
                if (flag == true) {
                    edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_gone);
                    flag = false;
                } else {
                    edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_visuable);
                    flag = true;
                }
                String pwd = edPassword.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    edPassword.setSelection(pwd.length());
                break;
        }
    }
    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            type = types[arg2];
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    private void toLogin(final String username, final String password,String mType) {
        UserBean req = new UserBean();
        req.setUsername(username);
        req.setPassword(password);
        req.setAccountType(mType);
        Observable<BaseEntity<UserBean>> observable = RetrofitFactory.getInstance().toLogin(username,password,mType);
        observable.compose(RxSchedulers.<BaseEntity<UserBean>>compose()).subscribe(new BaseObserver<UserBean>(this) {
            @Override
            protected void onHandleSuccess(BaseEntity<UserBean> t) {
                dialog.dismiss();
                RxToast.showToast(t.getDescription());
                //缓存账号信息
                RxSPTool.putString(LoginActivity.this,Const.USERNAME,username);
                RxSPTool.putString(LoginActivity.this,Const.PASSWORD,password);
                RxSPTool.putString(LoginActivity.this,Const.ACCOUNTTYPE,t.getList().get(0).getAccountType());
                RxSPTool.putString(LoginActivity.this,Const.USERID,t.getList().get(0).getUserId());
                RxSPTool.putString(LoginActivity.this,Const.CUSTOMERID,t.getList().get(0).getCustomerId());
                RxSPTool.putString(LoginActivity.this,Const.DISPLAYNAME,t.getList().get(0).getDisplayName());
                toNextActivityAndAnim(HomeActivity.class,true);
            }
            @Override
            protected void onHandleError(BaseEntity<UserBean> t) {
                dialog.dismiss();
                RxToast.showToast(t.getDescription());
            }
        });
    }
}

