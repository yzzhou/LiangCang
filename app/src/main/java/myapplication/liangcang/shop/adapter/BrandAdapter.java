package myapplication.liangcang.shop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.Bind;
import myapplication.liangcang.R;
import myapplication.liangcang.shop.bean.BrandInfo;

/**
 * Created by zhouzhou on 2017/7/7.
 */

public class BrandAdapter extends BaseAdapter {
    private final Context context;
    private final List<BrandInfo.DataBean.ItemsBean> datas;
    private final int[] icons;

    public BrandAdapter(Context mContext, List<BrandInfo.DataBean.ItemsBean> datas, int[] icons) {
        this.context = mContext;
        this.datas = datas;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_brand, null);
            viewHolder = new ViewHolder();
            viewHolder.ivBrandIcon = (ImageView) convertView.findViewById(R.id.iv_brand_icon);
            viewHolder.tvBrandName = (TextView) convertView.findViewById(R.id.tv_brand_name);
            viewHolder.ibBrandIcon = (ImageButton) convertView.findViewById(R.id.ib_brand_icon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String imageUrl =datas.get(position).getBrand_logo();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_login_logo)
                .error(R.drawable.ic_login_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.ivBrandIcon);
        viewHolder.tvBrandName.setText(datas.get(position).getBrand_name());
        viewHolder.ibBrandIcon.setImageResource(icons[0]);
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.iv_brand_icon)
        ImageView ivBrandIcon;
        @Bind(R.id.tv_brand_name)
        TextView tvBrandName;
        @Bind(R.id.ib_brand_icon)
        ImageButton ibBrandIcon;

    }
}
