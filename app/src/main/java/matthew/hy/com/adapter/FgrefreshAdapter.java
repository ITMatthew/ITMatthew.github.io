package matthew.hy.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import matthew.hy.com.R;
import matthew.hy.com.javabean.FgFreshJavaBean;

/**
 * author : Heyang
 * e-mail : 15258836173@163.com
 * date   : 2018/12/516:56
 * desc   :
 * version: 1.0
 */
public class FgrefreshAdapter extends RecyclerView.Adapter<FgrefreshAdapter.FgRefreshViewHolder> {

    private Context context;
    private ArrayList<FgFreshJavaBean> arrayList;

    public FgrefreshAdapter(Context context, ArrayList<FgFreshJavaBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FgRefreshViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fg_refresh,parent,false);
//        View view = View.inflate(context, R.layout.item_fg_refresh, null);
        FgRefreshViewHolder fgRefreshViewHolder = new FgRefreshViewHolder(view);
        return fgRefreshViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FgRefreshViewHolder holder, int position) {
        holder.mTitle.setText(arrayList.get(position).getmTitle());
        holder.mGoods.setText(arrayList.get(position).getmGoods());
        holder.mNum.setText(arrayList.get(position).getmNums());
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 1 : arrayList.size();
    }

    class FgRefreshViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mNum;
        TextView mGoods;

        public FgRefreshViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_item_fresh_title);
            mNum = itemView.findViewById(R.id.tv_item_fresh_num);
            mGoods = itemView.findViewById(R.id.tv_item_fresh_goods);
        }
    }
}
