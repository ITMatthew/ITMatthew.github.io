package matthew.hy.com;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import matthew.hy.com.adapter.BaseRecycleViewAdapter;
import matthew.hy.com.fragment.GoodsBean;

public class HandleFragement extends BaseFragment {


    RecyclerView rcyMatthewDemo;
    private BaseRecycleViewAdapter adapter;
    ArrayList<GoodsBean> arrayList;
    @Override
    protected int initFgId() {
        return R.layout.fg_handler;
    }

    @Override
    protected void initViewFg(View view) {
        getHttpDate();
        rcyMatthewDemo = view.findViewById(R.id.rcy_matthew_demo);
        rcyMatthewDemo.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcyMatthewDemo.setAdapter(adapter = new BaseRecycleViewAdapter(arrayList,getActivity()));
    }

    private void getHttpDate() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GoodsBean goodsBean = new GoodsBean();
            goodsBean.setName("我是标题" + i);
            goodsBean.setCount(i);
            arrayList.add(goodsBean);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
