package com.shilec.mvpdemo.logic.model;

import android.util.Log;

import com.shilec.mvpdemo.bean.UserInfo;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:27</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public class LoginModel {

    public void login(UserInfo info) {

    }

    public void logout(UserInfo info) {

    }

    public UserInfo getUserInfo() {
        return null;
    }

    public void modifyUserInfo(UserInfo info) {
        Log.e("LoginModel","--------modify userInfo---------");
    }
}
