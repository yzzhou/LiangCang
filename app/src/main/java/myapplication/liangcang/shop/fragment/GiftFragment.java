package myapplication.liangcang.shop.fragment;

import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;

/**
 * Created by zhouzhou on 2017/7/6.
 */

public class GiftFragment extends BaseFragment {
    @Bind(R.id.iv_shop_gift)
    ImageView ivShopGift;
    @Bind(R.id.iv_shop_gift_holiday)
    ImageView ivShopGiftHoliday;
    @Bind(R.id.iv_shop_gift_love)
    ImageView ivShopGiftLove;
    @Bind(R.id.iv_shop_gift_brithday)
    ImageView ivShopGiftBrithday;
    @Bind(R.id.iv_shop_gift_friend)
    ImageView ivShopGiftFriend;
    @Bind(R.id.iv_shop_gift_child)
    ImageView ivShopGiftChild;
    @Bind(R.id.iv_shop_gift_parent)
    ImageView ivShopGiftParent;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_gift, null);
        return view;
    }

    @Override
    public void initTitle() {
    }

}
