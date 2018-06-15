package com.huored.common_module.utils;

import android.widget.Toast;

import com.huored.common_module.base.BaseApplication;

/**
 * Created by danao on 2018/6/14.
 */
public class ToastUtils {

    public static void toast(String text) {
        Toast.makeText(BaseApplication.getApplication(), text, Toast.LENGTH_SHORT).show();
    }

}
