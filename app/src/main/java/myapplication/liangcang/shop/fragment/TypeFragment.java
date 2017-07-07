package myapplication.liangcang.shop.fragment;

import android.support.v7.widget.GridLayoutManager;
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
import myapplication.liangcang.shop.adapter.ShopTypeAdapter;
import myapplication.liangcang.shop.bean.ShopTypeInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class TypeFragment extends BaseFragment {
    @Bind(R.id.lv_type)
    RecyclerView lvType;
    private List<ShopTypeInfo.DataBean.ItemsBean> datas;
    private ShopTypeAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_type, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_SHOP_TYPE);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
        ShopTypeInfo shopTypeInfo = JSON.parseObject(json, ShopTypeInfo.class);
        datas = shopTypeInfo.getData().getItems();
        //RecyclerView.LayoutManager layout = new LinearLayoutManager(mContext,2)
        RecyclerView.LayoutManager layout=new GridLayoutManager(mContext,2);;
        lvType.setLayoutManager(layout);
        adapter = new ShopTypeAdapter(mContext,datas);
        lvType.setAdapter(adapter);
    }
}
