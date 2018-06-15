package com.huored.article_module.ui.main;

import com.huored.article_module.api.RetrofitService;
import com.huored.article_module.bean.GankIoResponse;
import com.huored.common_module.api.ProgressDialogSubscriber;
import com.huored.common_module.api.RetrofitManager;
import com.huored.common_module.base.BasePresenterImpl;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by danao on 2018/6/13.
 */
public class ArticleListPresenter extends BasePresenterImpl<ArticleListContract.View> implements ArticleListContract.Presenter {

    public ArticleListPresenter(ArticleListContract.View mView) {
        super(mView);
    }

    @Override
    public void getArticleList(int page) {
        RetrofitManager.getInstance()
                .getApiService(RetrofitService.class)
                .getArticle("Android", page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressDialogSubscriber<List<GankIoResponse>>(mView, requests) {

                    @Override
                    public void onBizSuccess(List<GankIoResponse> response) {
                        mView.getArticleListSuccess(response);
                    }
                });
    }
}
