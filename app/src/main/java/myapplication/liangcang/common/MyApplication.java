package myapplication.liangcang.common;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class MyApplication extends Application {
    public static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //initOkhttpUtils();
        x.Ext.init(this);

    }

    /**
     * 得到全局的上下文
     * @return
     */
    public static MyApplication getContext(){
        return instance;
    }

//    private void initOkhttpUtils() {
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .addInterceptor(new LoggerInterceptor("TAG"))
//                .connectTimeout(5000L, TimeUnit.MILLISECONDS)
//                .readTimeout(5000L, TimeUnit.MILLISECONDS)
//                //其他配置
//                .build();
//
//        OkHttpUtils.initClient(okHttpClient);
//    }
}
