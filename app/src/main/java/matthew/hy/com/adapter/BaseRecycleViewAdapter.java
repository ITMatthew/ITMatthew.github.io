package matthew.hy.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import matthew.hy.com.R;
import matthew.hy.com.fragment.GoodsBean;

/**
 * author : Heyang
 * e-mail : 15258836173@163.com
 * date   : 2018/12/513:52
 * desc   :
 * version: 1.0
 */
public class BaseRecycleViewAdapter extends RecyclerView.Adapter<BaseRecycleViewAdapter.MyRecycleViewHole> {


    private ArrayList<GoodsBean> mArrayList;
    private Context context;
    public BaseRecycleViewAdapter(ArrayList<GoodsBean> mArrayList, Context context) {
        this.mArrayList = mArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleViewHole onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.shop_cart_child,null);
        MyRecycleViewHole  myRecycleViewHole = new MyRecycleViewHole(view);
        return myRecycleViewHole;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewHole holder, int position) {
        holder.mTitle.setText(mArrayList.get(position).getName());
        holder.mNum.setText(mArrayList.get(position).getCount()+"");

    }

    @Override
    public int getItemCount() {
        return mArrayList == null ? 1 : mArrayList.size();
    }

    public class MyRecycleViewHole extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mNum;

        public MyRecycleViewHole(View itemView) {
            super(itemView);
            mTitle =  itemView.findViewById(R.id.tv_items_child);
            mNum = itemView.findViewById(R.id.id_tv_count_now);
        }
    }
}
