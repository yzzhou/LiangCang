package myapplication.liangcang.shop.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.OnClick;
import myapplication.liangcang.R;
import myapplication.liangcang.activity.LoginActivity;
import myapplication.liangcang.base.BaseActivity;
import okhttp3.Call;

public class TypeErjiActivity extends BaseActivity {


    @Bind(R.id.tv_title_biaoti)
    TextView tvTitleBiaoti;
    @Bind(R.id.iv_special)
    ImageView ivSpecial;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.rl_shuaixuan)
    RelativeLayout rlShuaixuan;
    @Bind(R.id.erji_recyclerView)
    RecyclerView erjiRecyclerView;
    @Bind(R.id.activity_type_erji)
    LinearLayout activityTypeErji;
    private Uri url;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        //getDataFromNet();
    }

//    private void getDataFromNet() {
//        url= getIntent().getData();
//        OkHttpUtils
//                .get()
//                .url(url)
//                .build()
//                .execute(new MyStringCallback());
//    }





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

    private void processData(String response) {

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_type_erji;
    }



    @OnClick({R.id.iv_special, R.id.base_shop, R.id.rl_shuaixuan, R.id.erji_recyclerView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_special:
                finish();
                break;
            case R.id.base_shop:
                startActivity(new Intent(TypeErjiActivity.this, LoginActivity.class));
                break;
            case R.id.rl_shuaixuan:
                Toast.makeText(TypeErjiActivity.this, "筛选", Toast.LENGTH_SHORT).show();
                break;
            case R.id.erji_recyclerView:
                break;
        }
    }
}
