package myapplication.liangcang.fenxiang.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.fenxiang.adapter.FenxiangTuijianAdapter;
import myapplication.liangcang.fenxiang.bean.FenxiangTuijianInfo;
import myapplication.liangcang.utils.Constants;

/**
 * Created by zhouzhou on 2017/7/8.
 */

public class FenxiangTuijianFragment extends BaseFragment {
    @Bind(R.id.fenxiang_tuijian_listview)
    ListView fenxiangTuijianListview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.tv_nomedia)
    TextView tvNomedia;
    private FenxiangTuijianAdapter myAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fgragment_fenxiang_tuijian, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initTitle() {

    }
    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "FenxiangTuijianFragment-initData");
        getDataFromNet(Constants.BASE_URL_FENXIANG_TUIJIAN);
    }

    private void getDataFromNet(String url) {
        RequestParams reques = new RequestParams(url);
        x.http().get(reques, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                LogUtil.e("onSuccess==" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished==");
            }
        });
    }

    /**
     * 解析数据和显示数据
     * @param json
     */
    private void processData(String json) {
        //解析数据
        FenxiangTuijianInfo fenxiangTuijianInfo = new Gson().fromJson(json, FenxiangTuijianInfo.class);
        List<FenxiangTuijianInfo.ListBean> datas = fenxiangTuijianInfo.getList();
        //String text = datas.get(0).getText();
//        Toast.makeText(context, "text=="+text, Toast.LENGTH_SHORT).show();
        if(datas != null && datas.size() >0){
            //有数据
            tvNomedia.setVisibility(View.GONE);
            //设置适配器
            myAdapter = new FenxiangTuijianAdapter(mContext,datas);
            fenxiangTuijianListview.setAdapter(myAdapter);
        }else{
            //没有数据
            tvNomedia.setVisibility(View.VISIBLE);
        }

        progressbar.setVisibility(View.GONE);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
