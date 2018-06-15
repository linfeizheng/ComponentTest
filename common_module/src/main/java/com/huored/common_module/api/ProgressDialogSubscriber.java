package com.huored.common_module.api;

import android.text.TextUtils;

import com.huored.common_module.base.IBaseView;
import com.huored.common_module.bean.BaseResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ProgressDialogSubscriber<T> implements Observer<BaseResponse<T>> {

    IBaseView mView;
    List<Disposable> requests;

    public ProgressDialogSubscriber(IBaseView mView, List<Disposable> requests) {
        this.mView = mView;
        this.requests = requests;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mView.showProgress();
        requests.add(d);
    }

    @Override
    public void onComplete() {
        mView.hideProgress();
    }

    @Override
    public void onError(Throwable t) {
        mView.hideProgress();
        if (t instanceof SocketTimeoutException) {
            mView.toast("网络开小差了");
//            setStatus(Constants.PageStatus.ERROR);
        } else if (t instanceof ConnectException) {
            mView.toast("网络开小差了");
//            setStatus(Constants.PageStatus.NO_NETWORK);
        } else {
            mView.toast("网络开小差了");
//            setStatus(Constants.PageStatus.NO_NETWORK);
        }
        onBizFailure("");
    }

    @Override
    public void onNext(BaseResponse<T> response) {
        if (!response.isError()) {
            onBizSuccess(response.getResults());
        } else {
            onBizFailure("error");
        }
    }

    public abstract void onBizSuccess(T t);

    public void onBizFailure(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            mView.toast(msg);
        }
    }

}
