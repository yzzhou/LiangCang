package myapplication.liangcang.daren.fragment;

import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.daren.adapter.DarenAdapter;
import myapplication.liangcang.daren.bean.DarenInfo;
import myapplication.liangcang.utils.Constants;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class DarenFragment extends BaseFragment {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_search)
    ImageView basesearch;
    @Bind(R.id.base_shop)
    ImageView baseshop;
    @Bind(R.id.gv_daren)
    GridView gvDaren;
    private DarenAdapter adapter;
    private List<DarenInfo.DataBean.ItemsBean> datas;
    private List<DarenInfo.DataBean.ItemsBean.UserImagesBean> images;



    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.feagment_daren, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initTitle() {
        baseTitle.setText("达人");
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_DAREN);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }

    public class MyStringCallback extends StringCallback {

        @Override
        public void onError(okhttp3.Call call, Exception e, int id) {
            Log.e("TAG", "请求失败==" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e("TAG", "请求成功==" );
            processData(response);

        }
    }

    private void processData(String json) {
        DarenInfo darenInfo = JSON.parseObject(json, DarenInfo.class);
        darenInfo.getData().getItems().get(6).getUser_images();
        datas =darenInfo.getData().getItems();

        adapter = new DarenAdapter(mContext,datas,images);
        gvDaren.setAdapter( adapter);
    }

}
