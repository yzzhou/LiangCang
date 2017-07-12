package myapplication.liangcang.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import myapplication.liangcang.shop.bean.ShopGiftInfo;

/**
 * Created by zhouzhou on 2017/7/12.
 */

public class ShopGiftAdapter extends RecyclerView.Adapter<ShopSpecialAdapter.MyViewHolder> {
    private final Context context;
    private final List<ShopGiftInfo.DataBean.ItemsBean> datas;

    public ShopGiftAdapter(Context context, List<ShopGiftInfo.DataBean.ItemsBean> datas) {
        this.context = context;
        this.datas = datas;
    }


    @Override
    public ShopSpecialAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ShopSpecialAdapter.MyViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return datas ==null ? 0: datas.size();
    }
    class MyViewHolder extends  RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
