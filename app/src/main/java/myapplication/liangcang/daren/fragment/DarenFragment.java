package myapplication.liangcang.daren.fragment;

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

public class DarenFragment extends BaseFragment {


    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.fl_daren)
    FrameLayout flDaren;

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



}
