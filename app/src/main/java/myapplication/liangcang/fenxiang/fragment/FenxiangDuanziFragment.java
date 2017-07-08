package myapplication.liangcang.fenxiang.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.fenxiang.adapter.FenxiangDuanziAdapter;
import myapplication.liangcang.fenxiang.bean.FenxiangDuanziInfo;
import myapplication.liangcang.utils.Constants;
import okhttp3.Call;

/**
 * Created by zhouzhou on 2017/7/8.
 */

public class FenxiangDuanziFragment extends BaseFragment {
    @Bind(R.id.fenxiang_duanzi_listview)
    ListView fenxiangDuanziListview;
    @Bind(R.id.fenxiang_duanzi_progressbar)
    ProgressBar fenxiangDuanziProgressbar;
    @Bind(R.id.fenxiang_duanzi_nomedia)
    TextView fenxiangDuanziNomedia;
    private FenxiangDuanziAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fenxiang_duanzi, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet(Constants.BASE_URL_FENXIANG_DUANZI);
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
            Log.e("TAGE", "请求成功==");
            processData(response);

        }
    }

    private void processData(String json) {
        FenxiangDuanziInfo fenxiangDuanziInfo = JSON.parseObject(json, FenxiangDuanziInfo.class);
        List<FenxiangDuanziInfo.ListBean> datas = fenxiangDuanziInfo.getList();
//        adapter = new FenxiangDuanziAdapter(mContext, datas);
//        fenxiangDuanziListview.setAdapter(adapter);
        if(datas !=null &&datas.size()>0){
            //有数据
            fenxiangDuanziNomedia.setVisibility(View.GONE);
            adapter = new FenxiangDuanziAdapter(mContext, datas);
            fenxiangDuanziListview.setAdapter(adapter);
        }
        else{
            fenxiangDuanziNomedia.setVisibility(View.VISIBLE);
        }
        fenxiangDuanziProgressbar.setVisibility(View.GONE);


    }
}
