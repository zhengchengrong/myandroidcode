/*
package com.jg.myproject.module.logins;

import com.google.gson.Gson;
import com.jg.myproject.api.RetrofitFactory;
import com.jg.myproject.api.RxSchedulers;
import com.jg.myproject.module.base.IBasePresenter;
import com.jg.myproject.api.BaseObserver;
import com.jg.myproject.api.bean.BaseEntity;

import javax.inject.Inject;

import io.reactivex.Observable;

*/
/**
 * Created by zhengchengrong on 2017/9/4.
 *//*


public class LoginPresenter implements IBasePresenter {

     private ILoginView mLoginView;
    // 当LoginAcitivty注解@Inject LoginPresenter 会调用这个构造方法进行实例化，ILoginView是通过module传递的

    @Inject
    LoginPresenter(ILoginView loginView){
        this.mLoginView = loginView;
    }


    // 登录操作
    // mLoginView.<BaseEntity<UserEntity>>bindToLife()
    // 回调了BaseActivity中的bindToLife 返回了LifecycleTransformer对象，将生命周期和LoginAcitivity捆绑防止内存泄漏

    public void login(String username,String password){
        mLoginView.showLoading();
        Observable<BaseEntity<String>> observable = RetrofitFactory.getInstance().login(username, password);
        observable.compose(RxSchedulers.<BaseEntity<String>>compose(mLoginView.<BaseEntity<String>>bindToLife()
        )).subscribe(new BaseObserver<String>(mLoginView) {
            @Override
            protected void onHandleSuccess(BaseEntity<String> userEntity) {
                // 保存用户信息等操作
                mLoginView.hideLoading();
                mLoginView.toActivity(new Gson().toJson(userEntity));
            }

            @Override
            protected void onHandleError(BaseEntity<String> userEntity) {
                mLoginView.hideLoading();
                mLoginView.showNetError();
            }
        });
    }

    @Override
    public void getData(boolean isRefresh) {
        //调用model层方法，加载数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //回调方法成功时
        //mLoginView.getDate(2);
    }
    @Override
    public void getMoreData() {

    }
}
*/
