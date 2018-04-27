package com.shilec.mvpdemo.base.presenter;

import com.shilec.mvpdemo.base.view.IView;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 14:27</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public interface IPresenter<V extends IView> {

    //依附View
    void attach(V v);

    //解除依附
    void detach();
}
