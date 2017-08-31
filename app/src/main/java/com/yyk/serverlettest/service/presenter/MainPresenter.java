package com.yyk.serverlettest.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.yyk.serverlettest.service.model.DataModel;
import com.yyk.serverlettest.service.view.IView;
import com.yyk.serverlettest.service.view.MainActivityView;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by YYK on 2017/8/28.
 */

public class MainPresenter implements IPresenter {

    private Context mContext;
    private MainActivityView mMainActivityView;
    private DataModel mModel;

    public MainPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        mModel = new DataModel(mContext);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(IView iView) {
        mMainActivityView = (MainActivityView) iView;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getData(Map<String, Object> params) {
        mModel.getRequest(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mMainActivityView.showError("服务器挂了");
                        mMainActivityView.hideProgress();
                    }

                    @Override
                    public void onNext(String s) {
                        mMainActivityView.setData(s);
                    }
                });

    }
}
