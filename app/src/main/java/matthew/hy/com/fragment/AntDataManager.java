package matthew.hy.com.fragment;

import android.content.Context;

import java.util.Map;

/**
 * 数据管理类
 */
public class AntDataManager {

    private Context mContext;
    private AntDataInterface mAntDataInterface;

    /**
     * 构造方法.
     *
     * @param context          Context
     * @param antDataInterface AntDataInterface 数据管理类回调接口
     */
    public AntDataManager(Context context, AntDataInterface antDataInterface) {
        mContext = context;
        mAntDataInterface = antDataInterface;
    }

    /**
     * 加载数据
     */
    public <JAVA_BEAN> void onAntLoad(final int tab, final String uri, Map<String, String> parameter, Class<JAVA_BEAN> beanClass, final AntDataCallback<JAVA_BEAN> antDataCallback) {

        // 开始加载数据
        antDataCallback.onAntDataStart(tab, uri, parameter, beanClass);
    }

}
