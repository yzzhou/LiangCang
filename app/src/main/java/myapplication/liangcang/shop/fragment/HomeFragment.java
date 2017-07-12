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
import myapplication.liangcang.shop.adapter.ShopHomeAdapter;
import myapplication.liangcang.shop.bean.ShopHomeInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.rl_home)
    RecyclerView rlHome;
    private ShopHomeAdapter adapter;
    private List<ShopHomeInfo.DataBean.ItemsBean.ListBeanX> datas;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_SHOP_HOME);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }

    private class MyStringCallback extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {
            Log.e("HOMETAG", "请求失败==" + e.getMessage());
        }
        @Override
        public void onResponse(String response, int id) {
            Log.e("HOMETAG", "请求成功==");
            processData(response);
        }
    }

    private void processData(String json) {
        //ShopHomeInfo shopHomeInfo = new Gson().fromJson(json, ShopHomeInfo.class);
        ShopHomeInfo shopHomeInfo = JSON.parseObject(json, ShopHomeInfo.class);
       datas = shopHomeInfo.getData().getItems().getList();
        if(datas !=null && datas.size()>0){
            adapter=new ShopHomeAdapter(mContext,datas);
            rlHome.setAdapter(adapter);
            rlHome.setLayoutManager(new LinearLayoutManager(mContext));

        }


    }
}
