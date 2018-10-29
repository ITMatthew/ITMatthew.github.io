package matthew.hy.com;

import android.app.Activity;
import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        /**
            注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，
          也需要在App代码中调用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，UMConfigure.init调用中appkey和channel参数请置为null）。
        */
//        UMConfigure.init(Context context, String appkey, String channel, int deviceType, String pushSecret);
    }



}
