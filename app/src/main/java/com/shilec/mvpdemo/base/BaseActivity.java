package com.shilec.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * <p>Author:    shijiale</p>
 * <p>Date:      2018-04-27 16:39</p>
 * <p>Email:     shilec@126.com</p>
 * <p>Describe:</p>
 */
public abstract class BaseActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());

    }

    protected abstract @LayoutRes int getContentLayout();
}
