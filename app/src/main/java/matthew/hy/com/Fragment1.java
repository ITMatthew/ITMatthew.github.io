package matthew.hy.com;

import android.os.VibrationEffect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import matthew.hy.com.adapter.FgrefreshAdapter;
import matthew.hy.com.javabean.FgFreshJavaBean;

public class Fragment1 extends BaseFragment {


    private SmartRefreshLayout github_refreshLayout;
    private ArrayList<FgFreshJavaBean> arrayList;
    private RecyclerView recyclerView_refresh;
    private FgrefreshAdapter fgAdapter;

    @Override
    protected int initFgId() {
        return R.layout.fg_one_test;
    }

    @Override
    protected void initViewFg(View view) {
        github_refreshLayout = view.findViewById(R.id.github_refreshLayout);
        recyclerView_refresh = view.findViewById(R.id.recyclerView_refresh);
        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FgFreshJavaBean fgFreshJavaBean = new FgFreshJavaBean();
            fgFreshJavaBean.setmGoods("家用电器" + i);
            fgFreshJavaBean.setmNums(i + "");
            fgFreshJavaBean.setmTitle("顾家" + i);
            arrayList.add(fgFreshJavaBean);
        }
        //设置 Header 为 贝塞尔雷达 样式
        github_refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        //设置 Footer 为 球脉冲 样式
        github_refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        github_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
        github_refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
        });

        recyclerView_refresh.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView_refresh.setAdapter(fgAdapter = new FgrefreshAdapter(getActivity(), arrayList));

    }
}
