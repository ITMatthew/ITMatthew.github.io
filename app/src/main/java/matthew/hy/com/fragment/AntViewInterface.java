package matthew.hy.com.fragment;

import android.content.Context;
import android.view.View;


/**
 * AntViewInterface:　视图管理接口．
 * <p>
 * 此接口用于视图管理类{@link AntViewManager}与视图进行交互．
 */

public interface AntViewInterface {

    /**
     * 初始化等待布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installLoadView(Context context);

    /**
     * 初始化异常布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installErroViewr(Context context);

    /**
     * 初始化空参数布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installEmptView(Context context);

    /**
     * 初始化正常布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installSuccView(Context context);

    /**
     * 初始化登录布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installLogiView(Context context);

    /**
     * 初始化无网络布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installUnliView(Context context);

    /**
     * 初始化其他布局
     * 示例代码:View.inflate(context, R.layout.view_activity_xxxx_xxxx, null);
     *
     * @param context Context
     * @return View
     */
    View installOtheView(Context context);

    /**
     * 视图切换完成通知
     *
     * @param antViewEnum AntViewEnum切换的视图
     */
    void updateLayoutNotice(AntViewEnum antViewEnum);
}
