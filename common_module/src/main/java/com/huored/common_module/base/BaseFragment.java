package com.huored.common_module.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huored.common_module.utils.SharedPreferencesUtil;
import com.huored.common_module.utils.ToastUtils;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements View.OnClickListener, IBaseView {

    protected Activity mContext;
    protected View rootView;
    protected TextView mTvTitle;

    protected P mPresenter;

    protected SharedPreferencesUtil spUtil;

    private ProgressDialog mProgressDialog;

    protected boolean mIsVisiable = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        mContext = getActivity();
        ButterKnife.bind(this, rootView);
//        mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        spUtil = new SharedPreferencesUtil(mContext);
        mIsVisiable = false;
        initTitleBar();
        initView();
        initData();
        initListener();
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void initTitleBar();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected void setTitle(String title) {
        if (mTvTitle != null)
            mTvTitle.setText(title != null ? title : "");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDetach();
    }

    protected void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext, AlertDialog.THEME_HOLO_LIGHT);
        }
        mProgressDialog.setMessage("正在加载中...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void toast(String msg) {
        ToastUtils.toast(msg);
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        dismissProgressDialog();
    }

}
