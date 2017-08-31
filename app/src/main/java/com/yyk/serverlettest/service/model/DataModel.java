package com.yyk.serverlettest.service.model;

import android.content.Context;

import com.yyk.serverlettest.service.RetrofitHelper;
import com.yyk.serverlettest.service.RetrofitService;

import java.util.Map;

import rx.Observable;

/**
 * Created by YYK on 2017/8/28.
 */

public class DataModel {

    private RetrofitService mRetrofitService;

    public DataModel(Context context) {
        mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<String> getRequest(Map<String, Object> params) {
        return mRetrofitService.getAndroid(params);
    }
}
