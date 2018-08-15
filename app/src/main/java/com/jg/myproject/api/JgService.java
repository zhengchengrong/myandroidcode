package com.jg.myproject.api;


import com.jg.myproject.api.bean.BaseEntity;
import com.jg.myproject.api.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public interface JgService {

    @FormUrlEncoded
    @POST("api/jzqy/postLogin")
    Observable<BaseEntity<UserBean>> toLogin(@Field("username") String username, @Field("password") String password, @Field("accountType") String accountType);



}
