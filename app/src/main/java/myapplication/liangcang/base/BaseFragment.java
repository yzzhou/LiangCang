package myapplication.liangcang.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();

    }

    public abstract View initView() ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initTitle();
        initListener();

    }

    /**
     * 有子类实现，实现特有效果
     * @return
     */

    /**
     * 初始化数据
     */
    public void initData() {

    }
    public abstract void initTitle();

    /*
    * 重写
    * */
    public void initListener() {

    }


}
