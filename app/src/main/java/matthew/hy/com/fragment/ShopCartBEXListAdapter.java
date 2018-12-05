package matthew.hy.com.fragment;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import matthew.hy.com.R;

/**
 * 购物车用到的ExpandableListAdapter
 */
public class ShopCartBEXListAdapter extends BaseExpandableListAdapter {
    private final static String HY = "ShopCartBEXListAdapter";
    List<Map<String, Object>> parentMapList;
    List<List<Map<String, Object>>> childMapList_list;

    Context context;
    int totalCount = 0;
    double totalPrice = 0.00;
    OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener;
    OnGoodsCheckedChangeListener onGoodsCheckedChangeListener;
    OnCheckHasGoodsListener onCheckHasGoodsListener;


    public void setOnCheckHasGoodsListener(OnCheckHasGoodsListener onCheckHasGoodsListener) {
        this.onCheckHasGoodsListener = onCheckHasGoodsListener;
    }

    public void setOnEditingTvChangeListener(OnEditingTvChangeListener onEditingTvChangeListener) {
        this.onEditingTvChangeListener = onEditingTvChangeListener;
    }

    OnEditingTvChangeListener onEditingTvChangeListener;

    public void setOnGoodsCheckedChangeListener(OnGoodsCheckedChangeListener onGoodsCheckedChangeListener) {
        this.onGoodsCheckedChangeListener = onGoodsCheckedChangeListener;
    }

    public void setOnAllCheckedBoxNeedChangeListener(OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener) {
        this.onAllCheckedBoxNeedChangeListener = onAllCheckedBoxNeedChangeListener;
    }


    public ShopCartBEXListAdapter(Context context, List<Map<String, Object>> parentMapList, List<List<Map<String, Object>>> childMapList_list) {
        this.parentMapList = parentMapList;
        this.childMapList_list = childMapList_list;
        this.context = context;
    }

    //获取当前父item的数据数量
    @Override
    public int getGroupCount() {
        return parentMapList.size();
    }

    //获取当前父item下的子item的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return childMapList_list.get(groupPosition).size();
    }

    //获取当前父item的数据
    @Override
    public Object getGroup(int groupPosition) {
        return parentMapList.get(groupPosition);
    }

    //得到子item需要关联的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMapList_list.get(groupPosition).get(childPosition);
    }

    //得到父item的ID
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //得到子item的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    //设置父item组件
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_cart_parent, null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tv_shop_cart_title = (TextView) convertView
                    .findViewById(R.id.tv_shop_cart_title);
            groupViewHolder.id_cb_select_parent = (CheckBox) convertView
                    .findViewById(R.id.id_cb_select_parent);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");

        final String parentName = storeBean.getName();
        groupViewHolder.tv_shop_cart_title.setText(parentName);

        groupViewHolder.id_cb_select_parent.setChecked(storeBean.isChecked());
        final boolean nowBeanChecked = storeBean.isChecked();


        groupViewHolder.id_cb_select_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupOneParentAllChildChecked(!nowBeanChecked, groupPosition);
                //控制总checkedbox 接口
//                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());
            }
        });


        return convertView;
    }

    //设置子item的组件
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_cart_child, null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tv_items_child = (TextView) convertView
                    .findViewById(R.id.tv_items_child);
            childViewHolder.id_cb_select_child = (CheckBox) convertView
                    .findViewById(R.id.id_cb_select_child);
            childViewHolder.id_ll_normal = (LinearLayout) convertView
                    .findViewById(R.id.id_ll_normal);
//            childViewHolder.id_ll_edtoring = (LinearLayout) convertView
//                    .findViewById(R.id.id_ll_edtoring);
            //常规下：
            childViewHolder.tv_items_child_desc = (TextView) convertView
                    .findViewById(R.id.tv_items_child_desc);
            childViewHolder.id_tv_price = (TextView) convertView
                    .findViewById(R.id.id_tv_price);
            childViewHolder.id_tv_discount_price = (TextView) convertView
                    .findViewById(R.id.id_tv_discount_price);
//            childViewHolder.id_tv_count = (TextView) convertView
//                    .findViewById(R.id.id_tv_count);
            //编辑下：
            childViewHolder.id_iv_reduce = (ImageView) convertView
                    .findViewById(R.id.id_iv_reduce);
            childViewHolder.id_iv_add = (ImageView) convertView
                    .findViewById(R.id.id_iv_add);
            childViewHolder.id_tv_count_now = (TextView) convertView
                    .findViewById(R.id.id_tv_count_now);
//            childViewHolder.id_tv_price_now = (TextView) convertView
//                    .findViewById(R.id.id_tv_price_now);
//            childViewHolder.id_tv_des_now = (TextView) convertView
//                    .findViewById(R.id.id_tv_des_now);

            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        final GoodsBean goodsBean = (GoodsBean) childMapList_list.get(groupPosition).get(childPosition).get("childName");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "商品：" + goodsBean.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        childViewHolder.tv_items_child.setText(goodsBean.getName());
        childViewHolder.id_tv_price.setText(String.format(context.getString(R.string.price), goodsBean.getPrice()));
        // childViewHolder.id_tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//数字划线效果
        childViewHolder.id_tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并抗锯齿
        childViewHolder.id_tv_discount_price.setText(String.format(context.getString(R.string.price), goodsBean.getDiscountPrice()));
        childViewHolder.tv_items_child_desc.setText(String.valueOf(goodsBean.getDesc()));

        childViewHolder.id_tv_count.setText(String.format(context.getString(R.string.good_count), goodsBean.getCount()));
        childViewHolder.id_tv_count_now.setText(String.valueOf(goodsBean.getCount()));

        double priceNow = goodsBean.getCount() * goodsBean.getDiscountPrice();//小结
        childViewHolder.id_tv_price_now.setText(String.format(context.getString(R.string.price), priceNow));
        childViewHolder.id_tv_des_now.setText(goodsBean.getDesc());

        childViewHolder.id_cb_select_child.setChecked(goodsBean.isChecked());
        childViewHolder.id_cb_select_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean nowBeanChecked = goodsBean.isChecked();
                //更新数据
                goodsBean.setIsChecked(!nowBeanChecked);

                boolean isOneParentAllChildIsChecked = dealOneParentAllChildIsChecked(groupPosition);
                Log.d(HY, "getChildView:onClick:  ==============");
                Log.d(HY, "getChildView:onClick:isOneParentAllChildIsChecked:" + isOneParentAllChildIsChecked);

                StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
                storeBean.setIsChecked(isOneParentAllChildIsChecked);


                notifyDataSetChanged();
                //控制总checkedbox 接口
//                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());
                dealPrice();
            }
        });

        childViewHolder.id_iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView textView= (TextView) v.getRootView().findViewById(R.id.id_tv_num);
                dealAdd(goodsBean);
            }
        });
        childViewHolder.id_iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView textView= (TextView) v.getRootView().findViewById(R.id.id_tv_num);
                dealReduce(goodsBean);
            }
        });


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupViewHolder {
        TextView tv_shop_cart_title;
        CheckBox id_cb_select_parent;
    }

    class ChildViewHolder {
        TextView tv_items_child;
        CheckBox id_cb_select_child;
        LinearLayout id_ll_normal;
        LinearLayout id_ll_edtoring;

        TextView tv_items_child_desc;
        TextView id_tv_price;
        TextView id_tv_discount_price;
        TextView id_tv_count;

        ImageView id_iv_reduce;
        ImageView id_iv_add;
        TextView id_tv_des_now;
        TextView id_tv_count_now;
        TextView id_tv_price_now;

    }

    public void dealAdd(GoodsBean goodsBean) {
        int count = goodsBean.getCount();
        count++;
        goodsBean.setCount(count);
        //  textView.setText(String.valueOf(count));
        notifyDataSetChanged();
        dealPrice();
    }

    public void dealReduce(GoodsBean goodsBean) {
        int count = goodsBean.getCount();
        if (count == 1) {
            return;
        }
        count--;
        goodsBean.setCount(count);
        // textView.setText(String.valueOf(count));
        notifyDataSetChanged();
        dealPrice();
    }

    public boolean dealOneParentAllChildIsChecked(int groupPosition) {
        Log.d(HY, "dealOneParentAllChildIsChecked: ============");
        Log.d(HY, "dealOneParentAllChildIsChecked: groupPosition：" + groupPosition);
        // StoreBean storeBean= (StoreBean) parentMapList.get(groupPosition).get("parentName");
        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
        for (int j = 0; j < childMapList.size(); j++) {
            GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
            if (!goodsBean.isChecked()) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    public interface OnAllCheckedBoxNeedChangeListener {
        void onCheckedBoxNeedChange(boolean allParentIsChecked);
    }

    public interface OnEditingTvChangeListener {
        void onEditingTvChange(boolean allIsEditing);
    }

    public interface OnGoodsCheckedChangeListener {
        void onGoodsCheckedChange(int totalCount, double totalPrice);
    }

    public interface OnCheckHasGoodsListener {
        void onCheckHasGoods(boolean isHasGoods);
    }

    public boolean dealAllParentIsChecked() {
        Log.d(HY, "dealAllParentIsChecked: ============");
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            if (!storeBean.isChecked()) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    private void setupOneParentAllChildChecked(boolean isChecked, int groupPosition) {
        Log.d(HY, "setupOneParentAllChildChecked: ============");
        Log.d(HY, "setupOneParentAllChildChecked: groupPosition:" + groupPosition);
        Log.d(HY, "setupOneParentAllChildChecked: isChecked：" + isChecked);
        StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
        storeBean.setIsChecked(isChecked);

        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
        for (int j = 0; j < childMapList.size(); j++) {
            GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
            goodsBean.setIsChecked(isChecked);
        }
        notifyDataSetChanged();
        dealPrice();
    }

    public void dealPrice() {
        // showList();
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < parentMapList.size(); i++) {
            //StoreBean storeBean= (StoreBean) parentMapList.get(i).get("parentName");

            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                int count = goodsBean.getCount();
                double discountPrice = goodsBean.getDiscountPrice();
                if (goodsBean.isChecked()) {
                    totalCount++;//单品多数量只记1
                    totalPrice += discountPrice * count;
                }

            }
        }
        //计算回调
        onGoodsCheckedChangeListener.onGoodsCheckedChange(totalCount, totalPrice);
    }
}
