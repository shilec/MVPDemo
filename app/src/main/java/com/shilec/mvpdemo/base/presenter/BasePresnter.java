package com.shilec.mvpdemo.base.presenter;

import android.util.Log;

import com.shilec.mvpdemo.base.view.IView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:30</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public abstract class BasePresnter<V extends IView> implements IPresenter<V> {

    private volatile V mView;

    public BasePresnter() {

    }

    protected V getView() {
        return _getView();
    }

    private V _getView() {

        //依附到View 时，返回该View
        if(mView != null) {
            return mView;
        }
        Class clz = getClass();
        Class<V> clz1 = (Class<V>) ((ParameterizedType)clz.getGenericSuperclass()).
                getActualTypeArguments()[0];

        //如果没有依附到View 时，并且Presenter的泛型参数不是一个继承自IView的接口
        //抛出异常
        if(!clz1.isInterface() && !Modifier.isAbstract(clz1.getModifiers())) {
            throw new IllegalStateException(clz1.getSimpleName() + " is not a interface");
        }

        //如果是继承自IView的接口，并且当前的Presenter 已经从View detach
        //生成代理类，防止异步请求返回刷新UI 造成空指针
        mView = (V)Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class<?>[]{clz1}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Log.e("BasePresenter","-----------view is deattched!");
                        return null;
                    }
                });
        return mView;
    }

    @Override
    public void attach(V v) {
        synchronized (this) {
            mView = v;
        }
    }

    @Override
    public void detach() {
        synchronized (this) {
            mView = null;
        }
    }
}
