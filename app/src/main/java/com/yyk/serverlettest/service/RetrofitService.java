package com.yyk.serverlettest.service;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by YYK on 2017/8/25.
 */

public interface RetrofitService {

    @POST("MyServerlet1")
    @FormUrlEncoded
    Observable<String> getAndroid(@FieldMap Map<String, Object> params);
}
