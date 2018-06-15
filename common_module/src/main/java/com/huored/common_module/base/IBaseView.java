package com.huored.common_module.base;

import android.content.Context;

public interface IBaseView {

    void showProgress();

    void hideProgress();

    void toast(String msg);

    Context getContext();

}
