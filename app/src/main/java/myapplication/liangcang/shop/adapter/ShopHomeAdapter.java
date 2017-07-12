package myapplication.liangcang.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapplication.liangcang.R;
import myapplication.liangcang.shop.activity.HomeDetailActivity;
import myapplication.liangcang.shop.bean.ShopHomeInfo;

/**
 * Created by zhouzhou on 2017/7/11.
 */

public class ShopHomeAdapter extends RecyclerView.Adapter  {

    private final Context context;
    private final List<ShopHomeInfo.DataBean.ItemsBean.ListBeanX> datas;



    public ShopHomeAdapter(Context mContext, List<ShopHomeInfo.DataBean.ItemsBean.ListBeanX> datas) {
        this.context = mContext;
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        int home_type = datas.get(position).getHome_type();

        if (1 == home_type) {
            return 1;
        } else if (2 == home_type) {
            return 2;
        } else if (4 == home_type) {
            return 4;
        } else if (6 == home_type) {
            return 6;
        }
        return home_type;
    }




    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return initViewHolder(parent, viewType);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 1) {
            OneHolder oneHolder = (OneHolder) holder;
            oneHolder.setData(datas.get(position));
        } else if (getItemViewType(position) == 2) {
            TwoHolder twoHolder = (TwoHolder) holder;
           twoHolder.setData(datas.get(position));
        } else if (getItemViewType(position) == 4) {
            FourHolder fourHolder = (FourHolder) holder;
            fourHolder.setData(datas.get(position));
        } else if (getItemViewType(position) == 6) {
            SixHolder sixHolder = (SixHolder) holder;
            sixHolder.setData(datas.get(position));

        }
//        holder.itemView.setTag(datas.get(position));
//        holder.itemView.setOnClickListener(this);

    }

    private RecyclerView.ViewHolder initViewHolder(ViewGroup parent, int viewType) {
        Log.d("TAG", "viewType: "+ viewType);
        RecyclerView.ViewHolder viewHolder = null;
        View convertView = null;
        switch (viewType) {
            case 1:
                convertView = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
                viewHolder = new OneHolder(convertView);
                break;
            case 2:
                convertView = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
                viewHolder = new TwoHolder(convertView);
                break;
            case 4:
                convertView = LayoutInflater.from(context).inflate(R.layout.item_foue, parent, false);
                viewHolder = new FourHolder(convertView);
                break;
            case 6:
                convertView = LayoutInflater.from(context).inflate(R.layout.item_six, parent, false);
                viewHolder = new SixHolder(convertView);
                break;
        }
        return viewHolder;
    }

//    @Override
//    public void onClick(View v) {
//        if(onRecyclerViwItemListener !=null){
//            onRecyclerViwItemListener.OnItemClick(v,(ShopHomeInfo.DataBean.ItemsBean.ListBeanX) v.getTag());
//        }
//    }


    class OneHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_one)
        ImageView ivOne;
        //private ShopHomeInfo.DataBean.ItemsBean.ListBeanX data;

        public OneHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(final ShopHomeInfo.DataBean.ItemsBean.ListBeanX listBeanX) {
//            ivOne.setImageResource(R.drawable.ic_login_logo);
            if (listBeanX.getOne().getPic_url() != null) {
                Glide.with(context).load(listBeanX.getOne().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL).into(ivOne);

            }
            ivOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, HomeDetailActivity.class);
                    //String url = listBeanX.getOne().getTopic_url();
                    //intent.putExtra("data",url);
                    intent.setData(Uri.parse(listBeanX.getOne().getPic_url()));
                    //intent.putExtra("data",listBeanX.getOne().getTopic_name());
                    context.startActivity(intent);
                }
            });
        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_two_one)
        ImageView itemTwoOne;
        @Bind(R.id.item_two_two)
        ImageView itemTwoTwo;

        public TwoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(final ShopHomeInfo.DataBean.ItemsBean.ListBeanX listBeanX) {
            if (listBeanX.getOne().getPic_url() != null) {
                Glide.with(context).load(listBeanX.getOne().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL).into(itemTwoOne);
                itemTwoOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getOne().getTopic_url()));
                        intent.putExtra("data",listBeanX.getOne().getTopic_name());
                        context.startActivity(intent);
                    }
                });
//                Log.e("TAG", "url1==" + datas.get(position).getOne().getPic_url());
//                Log.e("TAG", "url2==" + datas.get(position).getTwo().getPic_url());
                Glide.with(context).load(listBeanX.getTwo().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL).into(itemTwoTwo);
                itemTwoTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getTwo().getTopic_url()));
                        intent.putExtra("data",listBeanX.getTwo().getTopic_name());
                        context.startActivity(intent);
                    }
                });
            }
        }
    }

    class FourHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_four_one)
        ImageView ivFourOne;
        @Bind(R.id.iv_four_two)
        ImageView ivFourTwo;
        @Bind(R.id.iv_four_three)
        ImageView ivFourThree;
        @Bind(R.id.iv_four_four)
        ImageView ivFourFour;
        public FourHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(final ShopHomeInfo.DataBean.ItemsBean.ListBeanX listBeanX) {
//            ivFourFour.setImageResource(R.drawable.ic_login_logo);
            if (listBeanX.getOne().getPic_url() != null) {
                Glide.with(context).load(listBeanX.getOne().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivFourOne);
                ivFourOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getOne().getTopic_url()));
                        intent.putExtra("data",listBeanX.getOne().getTopic_name());
                        context.startActivity(intent);
                    }
                });
                Glide.with(context).load(listBeanX.getTwo().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivFourTwo);
                ivFourTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getTwo().getTopic_url()));
                        intent.putExtra("data",listBeanX.getTwo().getTopic_name());
                        context.startActivity(intent);
                    }
                });
                Glide.with(context).load(listBeanX.getThree().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivFourThree);
                ivFourThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getThree().getTopic_url()));
                        intent.putExtra("data",listBeanX.getThree().getTopic_name());
                        context.startActivity(intent);
                    }
                });
                Glide.with(context).load(listBeanX.getFour().getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivFourFour);
                ivFourFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomeDetailActivity.class);
                        //String url = listBeanX.getOne().getTopic_url();
                        //intent.putExtra("data",url);
                        intent.setData(Uri.parse(listBeanX.getFour().getTopic_url()));
                        intent.putExtra("data",listBeanX.getFour().getTopic_name());
                        context.startActivity(intent);
                    }
                });
            }
        }
    }

    class SixHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_six)
        ImageView ivSix;

        public SixHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(final ShopHomeInfo.DataBean.ItemsBean.ListBeanX listBeanX) {
            //ivSix.setImageResource(R.drawable.ic_login_logo);
            if (listBeanX.getPic_url() != null) {
                Log.e("TAG", "url6==" + listBeanX.getPic_url());
                Glide.with(context).load(listBeanX.getPic_url())
                        .placeholder(R.drawable.ic_login_logo).
                        error(R.drawable.ic_login_logo).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivSix);
//                itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(context, HomeDetailActivity.class);
//                        //intent.putExtra("data",datas.get(position).getTopic_name());
//                        intent.setData(Uri.parse(listBeanX.getOne().getTopic_url()));
//                        context.startActivity(intent);
//                    }
//                });

            }

        }
    }
//    public interface OnRecyclerViwItemListener{
//        void OnItemClick(View v,ShopHomeInfo.DataBean.ItemsBean.ListBeanX position);
//    }
//    private OnRecyclerViwItemListener onRecyclerViwItemListener=null;
//    public void setOnItemClickListener(OnRecyclerViwItemListener listener) {
//        this.onRecyclerViwItemListener=listener;
//    }
}
