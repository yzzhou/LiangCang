package myapplication.liangcang.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.shop.bean.ShopSpecialInfo;

/**
 * Created by zhouzhou on 2017/7/7.
 */

public class ShopSpecialAdapter extends RecyclerView.Adapter<ShopSpecialAdapter.MyViewHolder> {

    private final Context context;
    private final List<ShopSpecialInfo.DataBean.ItemsBean> datas;



    public ShopSpecialAdapter(Context mContext, List<ShopSpecialInfo.DataBean.ItemsBean> datas) {
        this.context = mContext;
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_shop_special, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String imageUrl = datas.get(position).getCover_img_new();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_login_logo)
                .error(R.drawable.ic_login_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivShopSpecial);
        holder.tvShopSpecial.setText(datas.get(position).getTopic_name());
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_shop_special)
        ImageView ivShopSpecial;
        @Bind(R.id.tv_shop_special)
        TextView tvShopSpecial;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
