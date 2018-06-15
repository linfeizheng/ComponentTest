package com.huored.article_module.api;

import com.huored.article_module.bean.GankIoResponse;
import com.huored.common_module.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("{source}/10/{page}")
    Observable<BaseResponse<List<GankIoResponse>>> getArticle(@Path("source") String source, @Path("page") int page);

}
