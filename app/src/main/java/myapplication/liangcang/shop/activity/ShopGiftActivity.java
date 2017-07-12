package myapplication.liangcang.shop.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseActivity;
import myapplication.liangcang.shop.adapter.ShopGiftAdapter;
import myapplication.liangcang.shop.bean.ShopGiftInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

public class ShopGiftActivity extends BaseActivity {

    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_search)
    ImageView baseSearch;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.rl_shuaixuan)
    RelativeLayout rlShuaixuan;
    @Bind(R.id.gift_recyclerView)
    RecyclerView giftRecyclerView;
    @Bind(R.id.activity_shop_gift)
    LinearLayout activityShopGift;
    private ShopGiftAdapter adapter;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getDataFromNet(Constants.BASE_URL_SHOP_GIF);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_gift;
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
        ShopGiftInfo shopGiftInfo = JSON.parseObject(json, ShopGiftInfo.class);
        List<ShopGiftInfo.DataBean.ItemsBean> datas = shopGiftInfo.getData().getItems();
        adapter = new ShopGiftAdapter(this,datas);
        giftRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this,2);
        giftRecyclerView.setLayoutManager(layout);

    }
}
