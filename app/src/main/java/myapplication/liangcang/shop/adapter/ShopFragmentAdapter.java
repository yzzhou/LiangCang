package myapplication.liangcang.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import myapplication.liangcang.base.BaseFragment;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class ShopFragmentAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> baseFragments;

    private String[] titles = new String[]{"分类", "品牌","首页","专题","礼物"};
    public ShopFragmentAdapter(FragmentManager fm, ArrayList<BaseFragment> baseFragments) {
        super(fm);
        this.baseFragments =baseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragments.get(position);
    }

    @Override
    public int getCount() {
        return baseFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
