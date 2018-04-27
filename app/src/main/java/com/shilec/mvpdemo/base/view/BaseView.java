package com.shilec.mvpdemo.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.shilec.mvpdemo.base.BaseActivity;
import com.shilec.mvpdemo.base.presenter.BasePresnter;

import java.lang.reflect.ParameterizedType;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:42</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public abstract class BaseView<P extends BasePresnter> extends BaseActivity implements IView{

    private P mPresenter;

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mPresenter = initPresenter();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detach();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attach( this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {
        Log.e("BaseView","showLoading....");
    }

    @Override
    public void hideLoading() {
        Log.e("BaseView","hideLoading....");
    }

    @Override
    public void onNetWorkError() {

    }

    //利用BasePresenter 的默认的无参构造方法生成一个Presenter对象
    protected P initPresenter() throws IllegalAccessException, InstantiationException {
        Class cls = getClass();
        Class<P> aClass = (Class<P>) ((ParameterizedType) cls.getGenericSuperclass()).
                getActualTypeArguments()[0];
        return aClass.newInstance();
    }
}
