package com.shilec.mvpdemo.logic.presenter;

import com.shilec.mvpdemo.base.presenter.BasePresnter;
import com.shilec.mvpdemo.bean.UserInfo;
import com.shilec.mvpdemo.logic.model.LoginModel;
import com.shilec.mvpdemo.logic.view.ILoginView;
import com.shilec.mvpdemo.logic.view.LoginView;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:33</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public class LoginPresnter extends BasePresnter<ILoginView> {

    private LoginModel model = new LoginModel();

    public void login(UserInfo info) {
        getView().showLoading();
        model.login(info);
        getView().hideLoading();
    }

    public void logout(UserInfo info) {
        getView().showLoading();
        model.logout(info);
        getView().hideLoading();
    }

    public void modifyUserInfo(final UserInfo info) {
        getView().showLoading();
        model.modifyUserInfo(info);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    getView().hideLoading();
                    getView().showUserInfo(info);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    getView().onNetWorkError();
                }
            }
        }).start();
    }

    public void getUserInfo() {
        UserInfo userInfo = model.getUserInfo();
        getView().showUserInfo(userInfo);
    }
}
