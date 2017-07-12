package myapplication.liangcang.shop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapplication.liangcang.R;

public class HomeDetailActivity extends AppCompatActivity {

    @Bind(R.id.tv_title_biaoti)
    TextView tvTitleBiaoti;
    @Bind(R.id.iv_special)
    ImageView ivSpecial;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.home_webView)
    WebView homeWebView;
    @Bind(R.id.activity_home_detail)
    LinearLayout activityHomeDetail;
    private Uri url;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        ButterKnife.bind(this);
        tvTitleBiaoti.setText(getIntent().getStringExtra("data"));
        url = getIntent().getData();

        settings = homeWebView.getSettings();
//        settings.setTextZoom(400);
        //设置相关配置
        //设置支持javaScript
        settings.setJavaScriptEnabled(true);
        //设置双击页面变大变小
        settings.setUseWideViewPort(true);

        //添加变大变小按钮
        settings.setBuiltInZoomControls(true);

        //设置加载网页完成的监听
        homeWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }
        });

        //加载网页地址
        homeWebView.loadUrl(url.toString());
//        webview.loadUrl("http://126.com/");

    }


    @OnClick({R.id.iv_special, R.id.base_shop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_special:
                finish();
                break;
            case R.id.base_shop:
                break;
        }
    }
}
