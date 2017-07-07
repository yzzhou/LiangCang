package myapplication.liangcang.shop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.shop.adapter.ShopSpecialAdapter;
import myapplication.liangcang.shop.bean.ShopSpecialInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class SpecialFragment extends BaseFragment {
    @Bind(R.id.rl_shop_special)
    RecyclerView rlShopSpecial;
    private List<ShopSpecialInfo.DataBean.ItemsBean> datas;
    private ShopSpecialAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_special, null);
        ButterKnife.bind(this, view);
        //getDataFromNet(Constants.BASE_URL_SHOP_SPECIAL);
        return view;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_SHOP_SPECIAL);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }





    class MyStringCallback extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            Log.e("TAG", "请求失败==" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e("TAG", "请求成功==");
            processData(response);

        }
    }

    private void processData(String json) {
        ShopSpecialInfo shopSpecialInfo = JSON.parseObject(json, ShopSpecialInfo.class);
        datas = shopSpecialInfo.getData().getItems();
        //RecyclerView.LayoutManager layout = new LinearLayoutManager(mContext,2)
        RecyclerView.LayoutManager layout = new LinearLayoutManager(mContext);
        rlShopSpecial.setLayoutManager(layout);
        adapter = new ShopSpecialAdapter(mContext, datas);
        rlShopSpecial.setAdapter(adapter);
    }
}
