package com.shilec.mvpdemo.base.view;

import android.content.Context;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:28</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:
 *      该类中可以声明一些常用的通用的UI操作
 * </p>
 */
public interface IView {
    Context getContext();

    void showLoading();

    void hideLoading();

    void onNetWorkError();
}
