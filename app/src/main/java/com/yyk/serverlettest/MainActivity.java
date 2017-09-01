package com.yyk.serverlettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yyk.serverlettest.service.presenter.MainPresenter;
import com.yyk.serverlettest.service.view.MainActivityView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private TextView login;
    private EditText name;
    private EditText password;

    private MainPresenter mPresenter;
    private Map<String, Object> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (TextView) findViewById(R.id.login);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

        params = new HashMap<>();
        params.put("name",name.getText());
        params.put("password",password.getText());
        mPresenter = new MainPresenter(this);
        mPresenter.onCreate();
        mPresenter.attachView(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getData(params);
            }
        });

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

    }
}
