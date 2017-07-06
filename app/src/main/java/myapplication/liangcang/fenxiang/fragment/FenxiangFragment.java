package myapplication.liangcang.fenxiang.fragment;

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

public class FenxiangFragment extends BaseFragment {

    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.fl_fenxiang)
    FrameLayout fl_fenxiang;

    @Override
    public void initTitle() {
        baseTitle.setText("分享");
    }

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.fragment_fenxiang, null);
        ButterKnife.bind(this, view);
        return view;
    }



}
