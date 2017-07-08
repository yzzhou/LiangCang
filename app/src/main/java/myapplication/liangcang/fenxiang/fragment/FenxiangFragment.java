package myapplication.liangcang.fenxiang.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.activity.MainActivity;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.fenxiang.adapter.FenxiangFragmentAdapter;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class FenxiangFragment extends BaseFragment {

    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_search)
    ImageView baseSearch;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.fenxiang_tablayout)
    TabLayout fenxiangTablayout;
    @Bind(R.id.fenixnag_view_pager)
    ViewPager fenixnagViewPager;
    private ArrayList<BaseFragment> baseFragments;
    private FenxiangFragmentAdapter fenxiangFragmentAdapter;

    @Override
    public void initTitle() {
        baseTitle.setText("百思不得姐 C");
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fenxiang, null);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void initData() {
        super.initData();
        baseFragments = new ArrayList<>();
        baseFragments.add(new FenxiangTuijianFragment());
        baseFragments.add(new FenxiangDuanziFragment());

        MainActivity mainActivity = (MainActivity) mContext;
        //设置适配器
        fenxiangFragmentAdapter = new FenxiangFragmentAdapter(mainActivity.getSupportFragmentManager(), baseFragments);
        fenixnagViewPager.setAdapter(fenxiangFragmentAdapter);
        fenxiangTablayout.setupWithViewPager(fenixnagViewPager);
    }


}
