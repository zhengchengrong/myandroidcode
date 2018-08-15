package com.jg.myproject.api;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

import com.jg.myproject.api.bean.ItemResult;
import com.jg.myproject.api.bean.PictureResult;
import com.jg.myproject.api.bean.BaseEntity;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public interface TestService {
    @GET("item/{id}")
    Call<ItemResult> getItem(@Path("id") int id);

//    @POST("item/addItem")
//    Call<CommonResutl<TbItemResponse>> createItem(@Body TbItem item);

  // retrofit 和 rxjava2 的结合
  @GET("item/{id}")
  Observable<BaseEntity<ItemResult>> getItemObser(@Path("id") int id);

    @POST("/sso/login")
    @FormUrlEncoded
    Observable<BaseEntity<String>> login(@Field("username")  String username, @Field("password") String password);

    /**
     * 上传头像
     */
    @Multipart
    @POST("/pic/upload")
    Call<PictureResult> uploadMemberIcon(@Part MultipartBody.Part uploadFile);
}
