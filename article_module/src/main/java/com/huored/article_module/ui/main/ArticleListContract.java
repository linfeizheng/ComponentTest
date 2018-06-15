package com.huored.article_module.ui.main;

import com.huored.article_module.bean.GankIoResponse;
import com.huored.common_module.base.BasePresenter;
import com.huored.common_module.base.IBaseView;

import java.util.List;

/**
 * Created by danao on 2018/6/13.
 */
public interface ArticleListContract {

    interface View extends IBaseView {

        void getArticleListSuccess(List<GankIoResponse> list);

    }

    interface Presenter extends BasePresenter {

        void getArticleList(int page);

    }

}
