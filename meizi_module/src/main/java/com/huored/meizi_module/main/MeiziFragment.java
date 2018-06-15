package com.huored.meizi_module.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huored.common_module.base.BaseFragment;
import com.huored.meizi_module.R;

/**
 * Created by danao on 2018/6/14.
 */
public class MeiziFragment extends BaseFragment {

    RecyclerView mRecyclerView;

    private MeiziAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_meizi;
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected void initView() {
        mRecyclerView = rootView.findViewById(R.id.recyclerView_meizi);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        PagerSnapHelper linearSnapHelper = new PagerSnapHelper();
        mAdapter = new MeiziAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
        linearSnapHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void initData() {
        String[] images = getActivity().getResources().getStringArray(R.array.banner);
        mAdapter.setData(images);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
