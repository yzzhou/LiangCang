package myapplication.liangcang.shop.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.activity.LoginActivity;
import myapplication.liangcang.activity.MainActivity;
import myapplication.liangcang.activity.SearchActivity;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.shop.adapter.ShopFragmentAdapter;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class ShopFragment extends BaseFragment {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_search)
    ImageView basesearch;
    @Bind(R.id.base_shop)
    ImageView baseshop;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    private ArrayList<BaseFragment> baseFragments;
    private ShopFragmentAdapter pagerAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_shop, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initTitle() {
        baseTitle.setText("商店");
    }

    @Override
    public void initData() {
        super.initData();
        baseFragments = new ArrayList<>();
        baseFragments.add(new TypeFragment());
        baseFragments.add(new BrandGragment());
        baseFragments.add(new HomeFragment());
        baseFragments.add(new SpecialFragment());
        baseFragments.add(new GiftFragment());

        MainActivity mainActivity = (MainActivity) mContext;
        //设置适配器
        pagerAdapter = new ShopFragmentAdapter(mainActivity.getSupportFragmentManager(), baseFragments);
        viewPager.setAdapter(pagerAdapter);
        tablayout.setupWithViewPager(viewPager);
        basesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,SearchActivity.class));
            }
        });
        baseshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,LoginActivity.class));
            }
        });
    }
}
