package myapplication.liangcang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapplication.liangcang.R;

public class SearchActivity extends AppCompatActivity {


    @Bind(R.id.ib_shop_search_back)
    ImageButton ibShopSearchBack;
    @Bind(R.id.tv_search_home)
    TextView tvSearchHome;
    @Bind(R.id.activity_search)
    LinearLayout activitySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.ib_shop_search_back, R.id.tv_search_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_shop_search_back:
                finish();
                break;
            case R.id.tv_search_home:
                Toast.makeText(SearchActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
