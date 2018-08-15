package com.jg.myproject.api;

import android.text.TextUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jg.myproject.utils.RxLogTool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

public class RetrofitFactory {

/*
    public static String BASE_URL = "http://192.168.3.32:8096/jcjg/";
*/


    public static String BASE_URL = "http://116.208.6.12:8004/jcjg/";

/*    public static String BASE_URL = "http://120.79.103.55:8097/cqjg/";*/

/*
    public static String BASE_URL = "http://192.168.3.51:8089/jcjg/";
*/

/*
    public static String BASE_URL = "http://120.79.103.55:8099/jcjg/";
*/

    public static String My_URL = "";



    public static final int  MSG_SUCESS=1, MSG_FAIL=0,MSG_OTHER=2;
    // 设置超时
    private static final long TIMEOUT = 30;

    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    //获取request
                    Request request = chain.request();
                    Request.Builder builder = chain.request().newBuilder();
                    //从request中获取原有的HttpUrl实例oldHttpUrl
                    HttpUrl oldHttpUrl = request.url();
                    HttpUrl newBaseUrl = null;
                    if (!TextUtils.isEmpty(My_URL)) {
                        newBaseUrl = HttpUrl.parse(My_URL);
                        //重建新的HttpUrl，修改需要修改的url部分
                        HttpUrl newFullUrl = oldHttpUrl
                                .newBuilder()
                                .scheme(newBaseUrl.scheme())
                                .host(newBaseUrl.host())
                                .port(newBaseUrl.port())
                                .build();
                        //重建这个request，通过builder.url(newFullUrl).build()；
                        //然后返回一个response至此结束修改
                        return chain.proceed(builder.url(newFullUrl).build());
                    }

                    return chain.proceed(builder.build());
                }
            })
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    RxLogTool.d(message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();

    private static JgService retrofitService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            // 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(JgService.class);

    // 得到实例
    public static JgService getInstance() {
        return retrofitService;
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }
}

