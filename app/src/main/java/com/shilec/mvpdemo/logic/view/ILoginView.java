package com.shilec.mvpdemo.logic.view;

import com.shilec.mvpdemo.base.view.IView;
import com.shilec.mvpdemo.bean.UserInfo;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 17:22</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public interface ILoginView extends IView {
    void showUserInfo(UserInfo info);
}
