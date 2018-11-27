package matthew.hy.com;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import matthew.hy.com.adapter.ViewPagerAdapter;
import matthew.hy.com.baseview.NavitationFollowScrollLayout;
import matthew.hy.com.baseview.NavitationLayout;
import matthew.hy.com.fragment.FgShopingCart;
import matthew.hy.com.utils.AppUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tv_matthew_home)
    public TextView tv_matthew_home;
    @BindViews({R.id.bt_matthew_1, R.id.bt_matthew_2, R.id.bt_matthew_3})
    public List<Button> buttonList;
    @BindString(R.string.app_name)
    String app_name;
    @BindArray(R.array.matthew)
    String[] matthew;
    @BindBitmap(R.mipmap.ic_launcher)
    Bitmap ic_launcher;
    @BindView(R.id.iv_matthew)
    ImageView imageView;
    @BindColor(R.color.colorAccent)
    int color;
    @BindView(R.id.nf_matthew_bar)
    NavitationLayout nfMatthewBar;
    @BindView(R.id.vp_matthew)
    ViewPager vpMatthew;


    private String[] titles = new String[]{"全部", "待付款", "代发货","待收货"};


    private ArrayList<Fragment> fragments2;
    private ViewPagerAdapter viewPagerAdapter2;

    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        tv_matthew_home.setText("改变之后的TextView");
        buttonList.get(0).setText("按钮1");
        buttonList.get(1).setText("按钮2");
        buttonList.get(2).setText(matthew[3]);
        imageView.setImageBitmap(ic_launcher);
        buttonList.get(0).setBackgroundColor(color);

        fragments2 =  new ArrayList<>();
        fragments2.add(new FgShopingCart());
        fragments2.add(new Fragment1());
        fragments2.add(new Fragment1());
        fragments2.add(new Fragment1());
        viewPagerAdapter2 = new ViewPagerAdapter(getSupportFragmentManager(), fragments2);
        vpMatthew.setAdapter(viewPagerAdapter2);
        nfMatthewBar.setViewPager(this, titles, vpMatthew, R.color.color_333333, R.color.color_bar_text, 12, 12, 0, 30, true);
        nfMatthewBar.setBgLine(this, 0, R.color.colorAccent);
        nfMatthewBar.setNavLine(this, 2, R.color.color_bar_text, 0);


        nfMatthewBar.setOnTitleClickListener(new NavitationLayout.OnTitleClickListener() {
            @Override
            public void onTitleClick(View v) {
                Toast.makeText(MainActivity.this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        nfMatthewBar.setOnNaPageChangeListener(new NavitationLayout.OnNaPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void addActivity(Activity activity) {
        super.addActivity(activity);
    }

    @OnClick(R.id.bt_matthew_1)
    public void matthew() {
        Log.e("MatthewLog", "点击事件");
    }

    @OnLongClick(R.id.bt_matthew_2)
    public boolean matthewLong() {
        AppUtils.d("HyMatthew", "打印日志");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_matthew_3)
    public void testHttps() {
        AppUtils.showToast("测试网络请求", MainActivity.this);
        String url = "https://www.jianshu.com/p/da4a806e599b";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String result = response.body().string();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }
                }).start();
            }
        });
    }

    @OnClick(R.id.bt_matthew_2)
    public void testHttp2() {
        String url = "https://blog.csdn.net/zhangconglin/article/details/78403049";
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("", "");
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
