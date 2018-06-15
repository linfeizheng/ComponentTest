package com.huored.article_module.ui.articlelist;

import android.view.View;

import com.huored.article_module.R;
import com.huored.article_module.ui.main.ArticleListFragment;
import com.huored.common_module.base.BaseActivity;

/**
 * Created by danao on 2018/6/15.
 * 若是组件化开发，作为首页第一个tab的容器
 * 若不是，没他什么事
 */
public class ArticleListActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_list;
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new ArticleListFragment())
                .commitAllowingStateLoss();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
