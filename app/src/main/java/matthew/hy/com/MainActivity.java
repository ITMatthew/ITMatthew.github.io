package matthew.hy.com;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        Log.e("MatthewLog", "长按点击事件");
        return true;
    }
}
