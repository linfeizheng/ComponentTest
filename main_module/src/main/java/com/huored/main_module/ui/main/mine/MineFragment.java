package com.huored.main_module.ui.main.mine;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huored.common_module.base.BaseFragment;
import com.huored.main_module.R;

/**
 * Created by danao on 2018/6/14.
 */
public class MineFragment extends BaseFragment {

    LinearLayout mContainer;
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected void initView() {
        mContainer = rootView.findViewById(R.id.container);
        mTextView = rootView.findViewById(R.id.textView);
    }

    @Override
    protected void initData() {
        String sss = "_ooOoo_\n" +
                "o8888888o\n" +
                "88\" . \"88\n" +
                "(| -_- |)\n" +
                "O\\  =  /O\n" +
                "____/ '---' \\____\n" +
                ".'  \\\\|     |//  `.\n" +
                "/  \\\\|||  :  |||//  \\\n" +
                "/  _||||| -:- |||||-  \\\n" +
                "|   | \\\\\\  -  /// |   |\n" +
                "| \\_|  ''\\---/''  |   |\n" +
                "\\  .-\\__  `-`  ___/-. /\n" +
                "___`. .'  /--.--\\  `. . __\n" +
                ".\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                "| | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                "\\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                "======`-.____`-.___\\_____/___.-`____.-'======\n" +
                "`=---='\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
        mTextView.setText(sss);

//                    _ooOoo_
//                   o8888888o
//                   88" . "88
//                   (| -_- |)
//                   O\  =  /O
//                ____/`---'\____
//              .'  \\|     |//  `.
//             /  \\|||  :  |||//  \
//            /  _||||| -:- |||||-  \
//            |   | \\\  -  /// |   |
//            | \_|  ''\---/''  |   |
//            \  .-\__  `-`  ___/-. /
//          ___`. .'  /--.--\  `. . __
//       ."" '<  `.___\_<|>_/___.'  >'"".
//      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//      \  \ `-.   \_ __\ /__ _/   .-` /  /
// ======`-.____`-.___\_____/___.-`____.-'======
//                    `=---='
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
