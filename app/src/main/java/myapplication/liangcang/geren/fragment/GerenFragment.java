package myapplication.liangcang.geren.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class GerenFragment extends BaseFragment {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_search)
    ImageView basesearch;
    @Bind(R.id.base_shop)
    ImageView baseShop;
    @Bind(R.id.fl_geren)
    FrameLayout fl_geren;

    @Override
    public void initTitle() {
        baseTitle.setText("个人");
    }

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.fragment_geren, null);
        ButterKnife.bind(this, view);
        return view;
    }




}
