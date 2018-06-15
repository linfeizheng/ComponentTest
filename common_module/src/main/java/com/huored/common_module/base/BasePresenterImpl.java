package com.huored.common_module.base;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class BasePresenterImpl<V extends IBaseView> implements BasePresenter {

    protected V mView;

    protected List<Disposable> requests;

    public BasePresenterImpl(V mView) {
        this.mView = mView;
        requests = new ArrayList<>();
    }

    @Override
    public void onDetach() {
        for (Disposable disposable : requests) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
