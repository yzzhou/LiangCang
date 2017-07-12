package myapplication.liangcang.shop.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapplication.liangcang.R;
import myapplication.liangcang.base.BaseFragment;
import myapplication.liangcang.shop.activity.ShopGiftActivity;
import myapplication.liangcang.shop.activity.ShopGiftBrithdayActivity;
import myapplication.liangcang.shop.activity.ShopGiftChildActivity;
import myapplication.liangcang.shop.activity.ShopGiftFriendActivity;
import myapplication.liangcang.shop.activity.ShopGiftHolidayActivity;
import myapplication.liangcang.shop.activity.ShopGiftLoveActivity;
import myapplication.liangcang.shop.activity.ShopGiftParentActivity;

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
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initTitle() {
    }


    @OnClick({R.id.iv_shop_gift, R.id.iv_shop_gift_holiday, R.id.iv_shop_gift_love, R.id.iv_shop_gift_brithday, R.id.iv_shop_gift_friend, R.id.iv_shop_gift_child, R.id.iv_shop_gift_parent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_shop_gift:
                startActivity(new Intent(mContext,ShopGiftActivity.class));
                break;
            case R.id.iv_shop_gift_holiday:
                startActivity(new Intent(mContext,ShopGiftHolidayActivity.class));
                break;
            case R.id.iv_shop_gift_love:
                startActivity(new Intent(mContext,ShopGiftLoveActivity.class));
                break;
            case R.id.iv_shop_gift_brithday:
                startActivity(new Intent(mContext,ShopGiftBrithdayActivity.class));
                break;
            case R.id.iv_shop_gift_friend:
                startActivity(new Intent(mContext,ShopGiftFriendActivity.class));
                break;
            case R.id.iv_shop_gift_child:
                startActivity(new Intent(mContext,ShopGiftChildActivity.class));
                break;
            case R.id.iv_shop_gift_parent:
                startActivity(new Intent(mContext,ShopGiftParentActivity.class));
                break;
        }
    }
}
