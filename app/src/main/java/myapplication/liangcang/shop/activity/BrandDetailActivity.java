package myapplication.liangcang.shop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapplication.liangcang.R;

public class BrandDetailActivity extends AppCompatActivity {


    @Bind(R.id.tv_title_biaoti)
    TextView tvTitleBiaoti;
    @Bind(R.id.iv_special)
    ImageView ivSpecial;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.iv_shop_band_icon)
    ImageView ivShopBandIcon;
    @Bind(R.id.tv_shop_band_name)
    TextView tvShopBandName;
    @Bind(R.id.btn_shop_band_gushi)
    Button btnShopBandGushi;
    @Bind(R.id.btn_shop_band_chanpin)
    Button btnShopBandChanpin;
    @Bind(R.id.activity_brand_detail)
    LinearLayout activityBrandDetail;
    private  String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_detail);
        ButterKnife.bind(this);
        //Uri data = getIntent().getData();
        //tvTitleBiaoti.setText();
        Intent intent =getIntent();
        String name = intent.getStringExtra("name");
        Bitmap icon = intent.getParcelableExtra("icon");
        tvTitleBiaoti.setText("品牌产品");
        tvShopBandName.setText(name);
        ivShopBandIcon.setImageBitmap(icon);
        //ivShopBandIcon.setImageBitmap(icon);
    }



    @OnClick({R.id.iv_special, R.id.btn_shop_band_gushi, R.id.btn_shop_band_chanpin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_special:
                finish();
                break;
            case R.id.btn_shop_band_gushi:

                break;
            case R.id.btn_shop_band_chanpin:
                break;
        }
    }
}
