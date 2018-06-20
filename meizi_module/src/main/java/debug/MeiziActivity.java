package debug;

import android.view.View;

import com.huored.common_module.base.BaseActivity;
import com.huored.meizi_module.R;
import com.huored.meizi_module.main.MeiziFragment;

public class MeiziActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_meizi;
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
                .add(R.id.container, new MeiziFragment())
                .commitAllowingStateLoss();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
