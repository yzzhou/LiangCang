package myapplication.liangcang.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseActivity;

public class SplashActivity extends BaseActivity {
    @Bind(R.id.iv_loading_start)
    ImageView ivLoadingStart;
    @Bind(R.id.activity_splash)
    RelativeLayout activitySplash;

//    @Bind(R.id.iv_welcome_icon)
//    ImageView ivWelcomeIcon;
//    @Bind(R.id.textView)
//    TextView textView;
//    @Bind(R.id.splash_tv_version)
//    TextView splashTvVersion;
//    @Bind(R.id.activity_splash)
//    RelativeLayout activitySplash;

    @Override
    public void initListener() {
        //第一个参数是倒计时的总时长，倒计时时间间隔
        //倒计时结束
        CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //倒计时结束
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }

    @Override
    public void initData() {
        Glide.with(this).load(R.drawable.loading_start).asGif().into(ivLoadingStart);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }



}
