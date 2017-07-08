package myapplication.liangcang.fenxiang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import myapplication.liangcang.base.BaseFragment;

/**
 * Created by zhouzhou on 2017/7/8.
 */

public class FenxiangFragmentAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> baseFragments;
    //private final Context context;

    private String[] fenxiangtitles = new String[]{"推荐", "段子"};
    public FenxiangFragmentAdapter(FragmentManager fm, ArrayList<BaseFragment> baseFragments) {
        super(fm);

        //this.context = context;
        this.baseFragments =baseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragments.get(position);
    }

    @Override
    public int getCount() {
        return baseFragments==null?0 :baseFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return fenxiangtitles[position];
    }
}
