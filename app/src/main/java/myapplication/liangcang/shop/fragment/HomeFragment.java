package myapplication.liangcang.shop.fragment;

import android.view.View;

import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class HomeFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home,null);
        return view;
    }

    @Override
    public void initTitle() {

    }
}
