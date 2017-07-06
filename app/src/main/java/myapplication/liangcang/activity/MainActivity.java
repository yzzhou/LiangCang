package myapplication.liangcang.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseActivity;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.daren.fragment.DarenFragment;
import myapplication.liangcang.fenxiang.fragment.FenxiangFragment;
import myapplication.liangcang.geren.fragment.GerenFragment;
import myapplication.liangcang.shop.fragment.ShopFragment;
import myapplication.liangcang.zazhi.fragment.ZaZhiFragment;

public class MainActivity extends BaseActivity {


    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.rb_shop)
    RadioButton rbShop;
    @Bind(R.id.rb_zazhi)
    RadioButton rbZazhi;
    @Bind(R.id.rb_daren)
    RadioButton rbDaren;
    @Bind(R.id.rb_fenxiang)
    RadioButton rbFenxiang;
    @Bind(R.id.rb_geren)
    RadioButton rbGeren;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    /**
     * Fragment的集合
     */
    private ArrayList<BaseFragment> fragments;
    /**
     * 选择某个Fragment的位置
     */
    private int position = 0;
    /**
     * 之前显示过的Fragment
     */
    private Fragment tempFragment;
    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        //初始多个页面对应的Fragment并且设置默认的Fragment页面
        initFragment();

        //设置RadioGroup的选中监听
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

        //设置默认选择首页
        rgMain.check(R.id.rb_shop);
    }


    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_shop:
                    position = 0;
                    break;
                case R.id.rb_zazhi:
                    position = 1;
                    break;
                case R.id.rb_daren:
                    position = 2;
                    break;
                case R.id.rb_fenxiang:
                    position = 3;
                    break;
                case R.id.rb_geren:
                    position = 4;
                    break;

            }
            Fragment currentFragment = fragments.get(position);
            switchFragment(currentFragment);
        }
    }
    /**
     * 要显示的Fragment
     * @param currentFragment
     */
    private void switchFragment(Fragment currentFragment) {
        if(currentFragment != tempFragment){//不是同一个
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            if(!currentFragment.isAdded()){

                //把之前的隐藏
                if(tempFragment!= null){
                    ft.hide(tempFragment);
                }
                //把现在的添加
                ft.add(R.id.frameLayout,currentFragment);

            }else{
                //把之前的隐藏
                if(tempFragment!= null){
                    ft.hide(tempFragment);
                }
                //把当前的显示
                ft.show(currentFragment);
            }


            //提交
            ft.commit();

            tempFragment = currentFragment;

        }

    }
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShopFragment());
        fragments.add(new ZaZhiFragment());
        fragments.add(new DarenFragment());
        fragments.add(new FenxiangFragment());
        fragments.add(new GerenFragment());
//        //一进入要显示的Fragment
//        switchFragment(fragments.get(position));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }



}
