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
import myapplication.liangcang.R;

public class SpecialDetailActivity extends AppCompatActivity {

    @Bind(R.id.iv_special)
    ImageView ivSpecial;
    @Bind(R.id.tv_title_biaoti)
    TextView tvtitlebiaoti;
    @Bind(R.id.special_webView)
    WebView specialWebView;
    @Bind(R.id.activity_special_detail)
    LinearLayout activitySpecialDetail;
    private Uri url;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_detail);
        ButterKnife.bind(this);


        ivSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvtitlebiaoti.setText(getIntent().getStringExtra("biaoti"));
        url = getIntent().getData();
        settings = specialWebView.getSettings();
//        settings.setTextZoom(400);
        //设置相关配置
        //设置支持javaScript
        settings.setJavaScriptEnabled(true);
        //设置双击页面变大变小
        settings.setUseWideViewPort(true);

        //添加变大变小按钮
        settings.setBuiltInZoomControls(true);

        //设置加载网页完成的监听
        specialWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }
        });

        //加载网页地址
        specialWebView.loadUrl(url.toString());
//        webview.loadUrl("http://126.com/");

    }


}
