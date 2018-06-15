package com.huored.article_module.ui.detail;

import android.view.View;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.huored.article_module.R;
import com.huored.common_module.Constants.Constant;
import com.huored.common_module.base.BaseActivity;

/**
 * 文章详情页
 */
@Route(path = "/article/detail")
public class ArticleActivity extends BaseActivity {

    WebView mWebView;

    String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    protected void initTitleBar() {
        url = getIntent().getStringExtra(Constant.INTENT_EXTRA_ID);
    }

    @Override
    protected void initView() {
        mWebView = findViewById(R.id.webview_article);
    }

    @Override
    protected void initData() {
        mWebView.loadUrl(url);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
