package com.shilec.mvpdemo.logic.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.shilec.mvpdemo.R;
import com.shilec.mvpdemo.base.view.BaseView;
import com.shilec.mvpdemo.bean.UserInfo;
import com.shilec.mvpdemo.logic.presenter.LoginPresnter;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:44</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public class LoginView extends BaseView<LoginPresnter>  implements ILoginView{

    @Override
    public void showUserInfo(UserInfo info) {
        Log.e("LoginView","---showUserInfo-----------");
    }

    public void onClick(View v) {
        UserInfo info = new UserInfo();
        info.setPsw("123");
        info.setUserName("shilec");
        getPresenter().modifyUserInfo(info);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_login;
    }
}
