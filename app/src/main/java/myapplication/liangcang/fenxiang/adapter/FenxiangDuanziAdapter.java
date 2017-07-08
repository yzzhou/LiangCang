package myapplication.liangcang.fenxiang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.fenxiang.bean.FenxiangDuanziInfo;

/**
 * Created by zhouzhou on 2017/7/8.
 */

public class FenxiangDuanziAdapter extends BaseAdapter {
    private final Context context;
    private final List<FenxiangDuanziInfo.ListBean> datas;

    public FenxiangDuanziAdapter(Context mContext, List<FenxiangDuanziInfo.ListBean> datas) {
        this.context = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public FenxiangDuanziInfo.ListBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_fenxiang_duanzi, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setData(datas.get(position));

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.ll_video_user_info)
        LinearLayout llVideoUserInfo;
        @Bind(R.id.iv_right_more)
        ImageView ivRightMore;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.iv_video_kind)
        ImageView ivVideoKind;
        @Bind(R.id.tv_video_kind_text)
        TextView tvVideoKindText;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
        public void setData(FenxiangDuanziInfo.ListBean listBean) {
            if (listBean.getU() != null && listBean.getU().getHeader() != null && listBean.getU().getHeader().get(0) != null) {

                x.image().bind(ivHeadpic, listBean.getU().getHeader().get(0));
            }
            if (listBean.getU() != null && listBean.getU().getName() != null) {
                tvName.setText(listBean.getU().getName() + "");
            }

            tvTimeRefresh.setText(listBean.getPasstime());

            //设置标签
            List<FenxiangDuanziInfo.ListBean.TagsBean> tagsEntities = listBean.getTags();
            if (tagsEntities != null && tagsEntities.size() > 0) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < tagsEntities.size(); i++) {
                    buffer.append(tagsEntities.get(i).getName() + " ");
                }
                tvVideoKindText.setText(buffer.toString());
            }

            //设置点赞，踩,转发
            tvContext.setText(listBean.getText());
            tvShenheDingNumber.setText(listBean.getUp());
            tvShenheCaiNumber.setText(listBean.getDown() + "");
            tvPostsNumber.setText(listBean.getForward() + "");

        }

//        public void setData(FenxiangDuanziInfo.ListBean listBean) {
//            super.setData(listBean);
//            tvContext.setText(listBean.getText());
//        }
    }
}
