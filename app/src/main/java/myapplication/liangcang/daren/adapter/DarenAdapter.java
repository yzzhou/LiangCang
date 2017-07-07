package myapplication.liangcang.daren.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import myapplication.liangcang.R;
import myapplication.liangcang.daren.bean.DarenInfo;

/**
 * Created by zhouzhou on 2017/7/7.
 */

public class DarenAdapter extends BaseAdapter {

    private final Context context;
    private final List<DarenInfo.DataBean.ItemsBean> datas;
    private final List<DarenInfo.DataBean.ItemsBean.UserImagesBean> imageUrl;

    public DarenAdapter(Context mContext, List<DarenInfo.DataBean.ItemsBean> datas, List<DarenInfo.DataBean.ItemsBean.UserImagesBean> images) {
        this.context = mContext;
        this.datas =datas;
        this.imageUrl = images;
    }

    @Override
    public int getCount() {
        return datas ==null? 0: datas.size();
    }

    @Override
    public DarenInfo.DataBean.ItemsBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.item_daren,null);
            viewHolder =new ViewHolder();
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_duty = (TextView) convertView.findViewById(R.id.tv_duty);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String imageUrl =datas.get(position).getUser_images().getOrig();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_login_logo)
                .error(R.drawable.ic_login_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.iv_icon);
        viewHolder.tv_name.setText(datas.get(position).getUsername());
        viewHolder.tv_duty.setText(datas.get(position).getDuty());
        return convertView;
    }
    static class  ViewHolder{
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_duty;
    }
}
