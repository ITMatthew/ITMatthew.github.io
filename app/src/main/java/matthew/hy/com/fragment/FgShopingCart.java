package matthew.hy.com.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import matthew.hy.com.R;


public class FgShopingCart extends AntNestFragment {

    private ExpandableListView exl_shop_cart;
    private static String MHY = "onItemClick";
    //定义父列表项List数据集合
    List<Map<String, Object>> parentMapList = new ArrayList<>();
    List<List<Map<String, Object>>> childMapList_list = new ArrayList<>();
    private LinearLayout id_ll_normal_all_state;
    private RelativeLayout id_rl_foot;
    private ShopCartBEXListAdapter shopCartBEXListAdapter;

    @Override
    public void onAntCreateView() {
        mAntViewManager.updateViewState(AntViewEnum.SUCCE);
    }

    @Override
    public View installSuccView(Context context) {
        View view = View.inflate(context, R.layout.fg_shop_cart, null);
        initCartData();
        exl_shop_cart = (ExpandableListView) view.findViewById(R.id.exl_shop_cart);
        shopCartBEXListAdapter = new ShopCartBEXListAdapter(context, parentMapList, childMapList_list);
        exl_shop_cart.setAdapter(shopCartBEXListAdapter);
        exl_shop_cart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.e(MHY, "进入商品详情页onItemClick: =" + position);
            }
        });
        //遍历所有的group 让所有的子类栏目默认展开
        for (int i = 1; i < parentMapList.size(); i++) {
            exl_shop_cart.expandGroup(i);
        }
        id_ll_normal_all_state = (LinearLayout) view.findViewById(R.id.id_ll_normal_all_state);
        final TextView id_tv_totalPrice = (TextView) view.findViewById(R.id.id_tv_totalPrice);//总价
        final TextView id_tv_totalCount_jiesuan = (TextView) view.findViewById(R.id.id_tv_totalCount_jiesuan);
        id_tv_totalCount_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(MHY, "结算按钮");
            }
        });

        shopCartBEXListAdapter.setOnGoodsCheckedChangeListener(new ShopCartBEXListAdapter.OnGoodsCheckedChangeListener() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onGoodsCheckedChange(int totalCount, double totalPrice) {
                id_tv_totalPrice.setText(String.format(getString(R.string.total), totalPrice));
                id_tv_totalCount_jiesuan.setText(String.format(getString(R.string.jiesuan), totalCount));
            }
        });

//        shopCartBEXListAdapter.setOnAllCheckedBoxNeedChangeListener(new ShopCartBEXListAdapter.OnAllCheckedBoxNeedChangeListener() {
//            @Override
//            public void onCheckedBoxNeedChange(boolean allParentIsChecked) {
//                id_cb_select_all.setChecked(allParentIsChecked);
//            }
//        });

//        shopCartBEXListAdapter.setOnEditingTvChangeListener(new ShopCartBEXListAdapter.OnEditingTvChangeListener() {
//            @Override
//            public void onEditingTvChange(boolean allIsEditing) {
//
//                changeFootShowDeleteView(allIsEditing);//这边类似的功能 后期待使用观察者模式
//
//            }
//        });

        shopCartBEXListAdapter.setOnCheckHasGoodsListener(new ShopCartBEXListAdapter.OnCheckHasGoodsListener() {
            @Override
            public void onCheckHasGoods(boolean isHasGoods) {
                setupViewsShow(isHasGoods);
            }
        });

        /**====include进来方式可能会导致view覆盖listview的最后一个item 解决*/
        //在onCreate方法中一般没办法直接调用view.getHeight方法来获取到控件的高度
        id_rl_foot = (RelativeLayout) view.findViewById(R.id.id_rl_foot);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        id_rl_foot.measure(w, h);
        int r_width = id_rl_foot.getMeasuredWidth();
        int r_height = id_rl_foot.getMeasuredHeight();
        Log.i("MeasureSpec", "MeasureSpec r_width = " + r_width);
        Log.i("MeasureSpec", "MeasureSpec r_height = " + r_height);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int top = dp2px(this, 48);
        lp.setMargins(0, top, 0, r_height);//48

        exl_shop_cart.setLayoutParams(lp);
        /**==========*/

        if (parentMapList != null && parentMapList.size() > 0) {
            setupViewsShow(true);
        } else {
            setupViewsShow(false);
        }

        return view;
    }

    public int dp2px(FgShopingCart context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    private void setupViewsShow(boolean isHasGoods) {
        if (isHasGoods) {
            exl_shop_cart.setVisibility(View.VISIBLE);
            id_rl_foot.setVisibility(View.VISIBLE);
        } else {
            exl_shop_cart.setVisibility(View.GONE);
            id_rl_foot.setVisibility(View.GONE);
        }
    }


    private void initCartData() {


        for (int i = 0; i < 4; i++) {
            String store="全球时刻购物";
//            if(i%2==0){
//                store="专营店";
//            }
            //提供父列表的数据
            Map<String, Object> parentMap = new HashMap<String, Object>();

            parentMap.put("parentName", new StoreBean("" + i, store + i, false, false));

          /*  if (i%2==0) {
                parentMap.put("parentIcon", R.mipmap.ic_launcher);
            }else
            {
                parentMap.put("parentIcon", R.mipmap.louisgeek);
            }*/
            parentMapList.add(parentMap);
            //提供当前父列的子列数据
            List<Map<String, Object>> childMapList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 2; j++) {
                Map<String, Object> childMap = new HashMap<String, Object>();

                GoodsBean goodsBean = new GoodsBean(i + "_" + j, store+i + "下的商品" + j, "url", "均码，红色", 150, 120, 1, GoodsBean.STATUS_VALID, false, false);
                childMap.put("childName", goodsBean);

                childMapList.add(childMap);
            }
            childMapList_list.add(childMapList);
        }

        //请求数据

    }
}
