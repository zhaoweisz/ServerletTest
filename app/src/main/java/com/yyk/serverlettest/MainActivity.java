package com.yyk.serverlettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yyk.serverlettest.service.presenter.MainPresenter;
import com.yyk.serverlettest.service.view.MainActivityView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private TextView mTextView;
    private MainPresenter mPresenter;
    private Map<String, Object> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);
        params = new HashMap<>();
        params.put("name","zhaowei");
        params.put("pwd","123456");
        mPresenter = new MainPresenter(this);
        mPresenter.onCreate();
        mPresenter.attachView(this);
        mPresenter.getData(params);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setData(String data) {
        mTextView.setText(data);
    }
}
