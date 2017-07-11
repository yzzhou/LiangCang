package myapplication.liangcang.shop.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.shop.adapter.BrandAdapter;
import myapplication.liangcang.shop.bean.BrandInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class BrandGragment extends BaseFragment {
    @Bind(R.id.lv_brand)
    ListView lvBrand;
    private BrandAdapter adapter;
    private int[] icons = new int[] {R.drawable.ic_arrow_shopgood};

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_brand, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_BRAND);
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
        BrandInfo brandInfo = JSON.parseObject(json, BrandInfo.class);
        final List<BrandInfo.DataBean.ItemsBean> datas = brandInfo.getData().getItems();
        adapter = new BrandAdapter(mContext, datas,icons);
        lvBrand.setAdapter(adapter);
//        lvBrand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //String url = datas.get(position);
//               // BrandInfo.DataBean.ItemsBean data=  adapter.getItem(position);
//                //Toast.makeText(mContext, "点击了==", Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(mContext,BrandDetailActivity.class);
////                intent.setData(Uri.parse(url));
////                mContext.startActivity(intent);
//            }
//        });
    }
}
