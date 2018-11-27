package matthew.hy.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import matthew.hy.com.R;


public abstract class AntNestFragment extends AntBaseFragment implements AntViewInterface, AntDataInterface {
    private FrameLayout mFrameLayout;
    public AntViewManager mAntViewManager;
    public AntDataManager mAntDataManager;
    private boolean isOneLoad = true;   // 是否是第一次加载

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化视图
        if (mFrameLayout != null) mFrameLayout = installFrameLayout();
        //初始化AnViewManage
        mAntViewManager = initialiseAntViewMainager();
        //初始化AntDataManage
        mAntDataManager = initialiseAntDataMainager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // 第一次加载需要初始化数据
        if (isOneLoad) {
            isOneLoad = false;
            onAntCreateView();
        }

        return mFrameLayout;
    }

    /**
     * 初始化FramLayout.
     * @return FrameLayout
     */
    public FrameLayout installFrameLayout( ) {
        return new FrameLayout(getAntContext());
    }

    /**
     * 初始化AntViewManager.
     * 示例: return new AntViewManager(getAntContext(), this, frameLayout);
     * 重写此方法自定义 AntViewManager.
     *
     * @return AntViewManager
     */
    public AntViewManager initialiseAntViewMainager() {
        return new AntViewManager(getAntContext(), this, mFrameLayout);
    }

    /**
     * AntDataManager.
     * 示例: return new AntDataManager(getAntContext(), this);
     * 重写此方法自定义 AntDataManager.
     *
     * @return AntDataManager
     */
    public AntDataManager initialiseAntDataMainager() {
        return new AntDataManager(getAntContext(), this);
    }

    /**
     * 初始化数据,此方法只调用一次.
     */
    public abstract void onAntCreateView();

    /**
     * 初始化等待布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    @Override
    public View installLoadView(Context context) {
        return View.inflate(context, R.layout.view_activity_antnest_load, null);
    }

    /**
     * 初始化异常布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     * @param context Context
     * @return View
     */
    @Override
    public View installErroViewr(Context context) {
        return View.inflate(context, R.layout.view_activity_antnest_error, null);
    }

    /**
     * 初始化空参数布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    @Override
    public View installEmptView(Context context) {
        return View.inflate(context, R.layout.view_activity_antnest_empt, null);
    }

    /**
     * 初始化登录布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    @Override
    public View installLogiView(Context context) {
        return null;
    }

    /**
     * 初始化无网络布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    @Override
    public View installUnliView(Context context) {
        return View.inflate(context, R.layout.view_activity_antnest_unli, null);
    }

    /**
     * 初始化其他布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    @Override
    public View installOtheView(Context context) {
        return null;
    }

    /**
     * 视图切换完成通知
     *
     * @param antViewEnum AntViewEnum切换的视图
     */
    @Override
    public void updateLayoutNotice(AntViewEnum antViewEnum) {

    }

}
