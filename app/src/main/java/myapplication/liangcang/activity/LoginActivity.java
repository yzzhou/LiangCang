package myapplication.liangcang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapplication.liangcang.R;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.ib_shop_login_back)
    ImageButton ibShopLoginBack;
    @Bind(R.id.login_phone)
    EditText loginPhone;
    @Bind(R.id.login_yanzhengma)
    EditText loginYanzhengma;
    @Bind(R.id.bt_login_yanzhengma)
    Button btLoginYanzhengma;
    @Bind(R.id.bt_login_denglu)
    Button btLoginDenglu;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ib_shop_login_back, R.id.bt_login_yanzhengma, R.id.bt_login_denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_shop_login_back:
                finish();
                break;
            case R.id.bt_login_yanzhengma:
                Toast.makeText(LoginActivity.this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_login_denglu:
                Toast.makeText(LoginActivity.this, "登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
