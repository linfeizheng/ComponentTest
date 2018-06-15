package com.huored.common_module.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.huored.common_module.utils.ApplicationUtil;
import com.huored.common_module.utils.SharedPreferencesUtil;
import com.huored.common_module.utils.ToastUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenterImpl> extends AppCompatActivity implements View.OnClickListener, IBaseView {

    protected AppCompatActivity mContext;
    protected TextView mTvTitle;

    protected View rootView;

    protected P mPresenter;

    protected SharedPreferencesUtil spUtil;

    private ProgressDialog mProgressDialog;

    protected String fileName;
    protected static final int CAPTURE_PHOTO_REQUEST_CODE = 0x0112;
    protected static final int REQUEST_CAMERA = 0x201;
    protected static final int REQUEST_PHONE_STATE = 0x202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        int layoutId = getLayoutId();
        setContentView(layoutId);
        rootView = findViewById(android.R.id.content);
        ButterKnife.bind(this);
        spUtil = new SharedPreferencesUtil(mContext);
//        mTvTitle = (TextView) findViewById(R.id.tv_title);
        ApplicationUtil.addActivity(this);
        initTitleBar();
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initTitleBar();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    public void setTitle(@NonNull CharSequence title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
    }

    protected void setBack() {
//        ImageView imageBack = (ImageView) findViewById(R.id.iv_title_back);
//        if (imageBack != null) {
//            imageBack.setVisibility(View.VISIBLE);
//            imageBack.setOnClickListener(new OnClickEvent() {
//                @Override
//                public void onSingleClick(View v) {
//                    onBackPressed();
//                }
//            });
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDetach();
        ApplicationUtil.removeActivity(this);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    protected void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, AlertDialog.THEME_HOLO_LIGHT);
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        Intent intent = new Intent(mContext, WelcomeActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
    }
}
