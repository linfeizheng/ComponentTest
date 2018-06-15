package com.huored.main_module.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.huored.common_module.base.BaseActivity;
import com.huored.common_module.utils.ReflectUtils;
import com.huored.main_module.R;

@Route(path = "/main/main")
public class MainActivity extends BaseActivity implements View.OnClickListener {

    //文章
    LinearLayout mArticleLayout;
    ImageView mIvArticle;
    TextView mTvArticle;
    //妹子
    LinearLayout mMeiziLayout;
    ImageView mIvMeizi;
    TextView mTvMeizi;
    //我的
    LinearLayout mMineLayout;
    ImageView mIvMine;
    TextView mTvMine;

    private Fragment mFragment;//当前fragment
    private Fragment mArticleFragment;
    private Fragment mMeiziFragment;
    private Fragment mMineFragment;

    private FragmentManager mFragmentManager;
    private int currentIndex = 0;
    private static final String NOW_MENU_INDEX = "nowMenuIndex";

    public static final String FRAGMENT_TAG_ARTICLE = "com.huored.article_module.ui.main.ArticleListFragment";
    public static final String FRAGMENT_TAG_MEIZI = "com.huored.meizi_module.main.MeiziFragment";
    public static final String FRAGMENT_TAG_MINE = "com.huored.main_module.ui.main.mine.MineFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitleBar() {
    }

    @Override
    protected void initView() {
        mArticleLayout = findViewById(R.id.llyt_main_article);
        mIvArticle = findViewById(R.id.iv_main_article);
        mTvArticle = findViewById(R.id.tv_main_article);

        mMeiziLayout = findViewById(R.id.llyt_main_meizi);
        mIvMeizi = findViewById(R.id.iv_main_meizi);
        mTvMeizi = findViewById(R.id.tv_main_meizi);

        mMineLayout = findViewById(R.id.llyt_main_mine);
        mIvMine = findViewById(R.id.iv_main_mine);
        mTvMine = findViewById(R.id.tv_main_mine);
    }

    @Override
    protected void initData() {
        mFragmentManager = getSupportFragmentManager();
        showFragment(currentIndex);
    }

    @Override
    protected void initListener() {
        mArticleLayout.setOnClickListener(this);
        mMeiziLayout.setOnClickListener(this);
        mMineLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.llyt_main_article) {
            showFragment(0);
        } else if (id == R.id.llyt_main_meizi) {
            showFragment(1);
        } else if (id == R.id.llyt_main_mine) {
            showFragment(2);
        }
    }

    private synchronized void showFragment(int index) {
        switch (index) {
            case 0:
                if (null == mArticleFragment) {
                    mArticleFragment = ReflectUtils.getFragment(FRAGMENT_TAG_ARTICLE);
                }
                switchContent(mArticleFragment, FRAGMENT_TAG_ARTICLE);
                break;
            case 1:
                if (null == mMeiziFragment) {
                    mMeiziFragment = ReflectUtils.getFragment(FRAGMENT_TAG_MEIZI);
                }
                switchContent(mMeiziFragment, FRAGMENT_TAG_MEIZI);
                break;
            case 2:
                if (null == mMineFragment) {
                    mMineFragment = ReflectUtils.getFragment(FRAGMENT_TAG_MINE);
                }
                switchContent(mMineFragment, FRAGMENT_TAG_MINE);
                break;
            default:
                break;
        }
        changeTab(index);
        currentIndex = index;
    }

    private void switchContent(Fragment to, String name) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mFragment != null) {
            if (mFragment != to) {
//                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                // 先判断是否被add过
                if (!to.isAdded()) {
                    transaction.hide(mFragment).add(R.id.llyt_main_content, to, name).commitAllowingStateLoss();
                    // 隐藏当前的fragment，add下一个到Activity中
                } else {
                    transaction.hide(mFragment).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                }
                mFragment = to;
            }
        } else {
            mFragment = to;
            if (!to.isAdded()) {
                transaction.add(R.id.llyt_main_content, to, name).commitAllowingStateLoss();
            } else {
                transaction.show(to).commitAllowingStateLoss();
            }
        }
    }

    private void changeTab(int index) {
        mTvArticle.setSelected(index == 0);
        mTvMeizi.setSelected(index == 1);
        mTvMine.setSelected(index == 2);
        mIvArticle.setImageResource(index == 0 ? R.drawable.ic_home_checked : R.drawable.ic_home_unchecked);
        mIvMeizi.setImageResource(index == 1 ? R.drawable.ic_meizi_checked : R.drawable.ic_meizi_unchecked);
        mIvMine.setImageResource(index == 2 ? R.drawable.ic_video_checked : R.drawable.ic_video_unchecked);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(NOW_MENU_INDEX, currentIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        currentIndex = savedInstanceState.getInt(NOW_MENU_INDEX);
        mArticleFragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ARTICLE);
        mMeiziFragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG_MEIZI);
        mMineFragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG_MINE);
        mFragment = null;
        showFragment(currentIndex);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
