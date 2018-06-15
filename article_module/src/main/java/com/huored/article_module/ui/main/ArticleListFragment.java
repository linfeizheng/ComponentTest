package com.huored.article_module.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huored.article_module.R;
import com.huored.article_module.bean.GankIoResponse;
import com.huored.common_module.Constants.Constant;
import com.huored.common_module.base.BaseFragment;
import com.huored.common_module.utils.OnItemClickListener;

import java.util.List;

/**
 * Created by danao on 2018/6/14.
 */
@Route(path = "/article/list")
public class ArticleListFragment extends BaseFragment<ArticleListContract.Presenter> implements ArticleListContract.View {

    RecyclerView mRecyclerView;

    private ArticleListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initTitleBar() {
        mPresenter = new ArticleListPresenter(this);
    }

    @Override
    protected void initView() {
        mRecyclerView = rootView.findViewById(R.id.recyclerView_article);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ArticleListAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getArticleList(1);
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                GankIoResponse response = mAdapter.getItem(position);
                ARouter.getInstance().build("/article/detail")
                        .withString(Constant.INTENT_EXTRA_ID, response.getUrl())
                        .navigation();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getArticleListSuccess(List<GankIoResponse> list) {
        mAdapter.setData(list);
    }
}
