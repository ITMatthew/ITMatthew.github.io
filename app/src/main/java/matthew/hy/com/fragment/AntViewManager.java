package matthew.hy.com.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * AntViewManager: 视图管理类.
 * <p>
 * 核心功能:
 * 1.用于管理视图的状态{@link AntViewEnum}.
 * 2.通过视图状态展示相应的视图{@link AntViewManager#updateViewState(AntViewEnum)}.
 * <p>
 * 注意:使用此管理类需要在初始化的时候指定视图管理接口{@link AntViewInterface}
 */

public class AntViewManager {

    private AntViewInterface mAntViewInterface = null;
    private FrameLayout mFrameLayout = null;
    private Context mContext = null;
    private AntViewEnum mAntViewEnum = AntViewEnum.SUCCE;   // 当前视图状态(默认为成功视图状态)

    // EXPLAIN 2017/8/15 不同状态下的View.
    private View mLoadView = null;  // 数据加载页面
    private View mErroView = null;  // 数据失败页面
    private View mEmptView = null;  // 数据为空页面
    private View mSuccView = null;  // 数据展示页面
    private View mLogiView = null;  // 未登录界面
    private View mUnliView = null;  // 无网络页面
    private View mOtheView = null;  // 其他状态(保留界面)

    /**
     * 构造方法:不指定FrameLayout.
     *
     * @param context          Context
     * @param antViewInterface 视图管理接口
     */
    public AntViewManager(Context context, AntViewInterface antViewInterface) {
        this(context, antViewInterface, new FrameLayout(context));
    }

    /**
     * 构造方法:指定FragmeLayout.
     *
     * @param context          Context
     * @param antViewInterface 视图管理接口
     * @param frameLayout      FrameLayout
     */
    public AntViewManager(Context context, AntViewInterface antViewInterface, FrameLayout frameLayout) {
        mContext = context;
        mAntViewInterface = antViewInterface;
        mFrameLayout = frameLayout;
    }

    /**
     * 获取FrameLayout
     *
     * @return FrameLayout
     */
    public FrameLayout getFrameLayout() {
        return mFrameLayout;
    }

    /**
     * 获取当前视图状态
     *
     * @return AntViewEnum {@link AntViewEnum}
     */
    public AntViewEnum getAntViewEnum() {
        return mAntViewEnum;
    }

    /**
     * 更新视图状态.
     *
     * @param antViewEnum 视图状态{@link AntViewEnum}
     */
    public void updateViewState(AntViewEnum antViewEnum) {

        // 更新视图状态
        mAntViewEnum = antViewEnum;

        // 根据页面状态，展示相应的布局
        switch (antViewEnum) {
            case LOADS:
                // 创建布局
                if (null == mLoadView) {
                    mLoadView = mAntViewInterface.installLoadView(mContext);

                    if (null == mLoadView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mLoadView);
                    }
                }

                // 展示布局
                if (null != mLoadView) {
                    mLoadView.setVisibility(View.VISIBLE);
                }
                break;

            case ERROR:
                // 创建布局
                if (null == mErroView) {
                    mErroView = mAntViewInterface.installErroViewr(mContext);

                    if (null == mErroView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mErroView);
                    }
                }

                // 展示布局
                if (null != mErroView) {
                    mErroView.setVisibility(View.VISIBLE);
                }
                break;

            case EMPTY:
                // 创建布局
                if (null == mEmptView) {
                    mEmptView = mAntViewInterface.installEmptView(mContext);

                    if (null == mEmptView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mEmptView);
                    }
                }

                // 展示布局
                if (null != mEmptView) {
                    mEmptView.setVisibility(View.VISIBLE);
                }
                break;

            case SUCCE:
                // 创建布局
                if (null == mSuccView) {
                    mSuccView = mAntViewInterface.installSuccView(mContext);

                    if (null == mSuccView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mSuccView);
                    }
                }

                // 展示布局
                if (null != mSuccView) {
                    mSuccView.setVisibility(View.VISIBLE);
                }

                break;

            case LOGIN:
                // 创建布局
                if (null == mLogiView) {
                    mLogiView = mAntViewInterface.installLogiView(mContext);

                    if (null == mLogiView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mLogiView);
                    }
                }

                // 展示布局
                if (null != mLogiView) {
                    mLogiView.setVisibility(View.VISIBLE);
                }
                break;

            case UNLIN:

                // 创建布局
                if (null == mUnliView) {
                    mUnliView = mAntViewInterface.installUnliView(mContext);

                    if (null == mUnliView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mUnliView);
                    }
                }

                // 展示布局
                if (null != mUnliView) {
                    mUnliView.setVisibility(View.VISIBLE);
                }
                break;

            case OTHER:
                // 创建布局
                if (null == mOtheView) {
                    mOtheView = mAntViewInterface.installOtheView(mContext);

                    if (null == mOtheView) {
                        viewNullError(antViewEnum);
                    } else {
                        mFrameLayout.addView(mOtheView);
                    }
                }

                // 展示布局
                if (null != mOtheView) {
                    mOtheView.setVisibility(View.VISIBLE);
                }

                break;
        }

        // 隐藏多余布局
        if (mLoadView != null && antViewEnum != antViewEnum.LOADS)
            mLoadView.setVisibility(View.GONE);
        if (mErroView != null && antViewEnum != antViewEnum.ERROR)
            mErroView.setVisibility(View.GONE);
        if (mEmptView != null && antViewEnum != antViewEnum.EMPTY)
            mEmptView.setVisibility(View.GONE);
        if (mSuccView != null && antViewEnum != antViewEnum.SUCCE)
            mSuccView.setVisibility(View.GONE);
        if (mLogiView != null && antViewEnum != antViewEnum.LOGIN)
            mLogiView.setVisibility(View.GONE);
        if (mUnliView != null && antViewEnum != antViewEnum.UNLIN)
            mUnliView.setVisibility(View.GONE);
        if (mOtheView != null && antViewEnum != antViewEnum.OTHER)
            mOtheView.setVisibility(View.GONE);

        // 通知接口布局切换完成
        mAntViewInterface.updateLayoutNotice(antViewEnum);

    }

    /**
     * 展示异常布局
     * 当应该展示的布局没有进行初始化的情况下所展示的布局,用于提示编写者去实现相关方法.
     *
     * @param antViewEnum 缺失的布局状态
     */
    private void viewNullError(AntViewEnum antViewEnum) {

        // 设置mErroView数据
        String errorString = "布局加载错误";

        switch (antViewEnum) {
            case LOADS:
                errorString = "ERROR:mLoadView 创建失败,请重写AntViewInterface接口中的installLoadView()方法实现等待布局!";
                break;
            case ERROR:
                errorString = "ERROR:mErroView 创建失败,请重写AntViewInterface接口中的installErroViewr()方法实现等待布局!";
                break;
            case EMPTY:
                errorString = "ERROR:mEmptView 创建失败,请重写AntViewInterface接口中的installEmptView()方法实现等待布局!";
                break;
            case SUCCE:
                errorString = "ERROR:mSuccView 创建失败,请重写AntViewInterface接口中的installSuccView()方法实现等待布局!";
                break;
            case LOGIN:
                errorString = "ERROR:mLogiView 创建失败,请重写AntViewInterface接口中的installLogiView()方法实现等待布局!";
                break;
            case UNLIN:
                errorString = "ERROR:mUnliView 创建失败,请重写AntViewInterface接口中的installUnliView()方法实现等待布局!";
                break;
            case OTHER:
                errorString = "ERROR:mOtheView 创建失败,请重写AntViewInterface接口中的installOtheView()方法实现等待布局!";
                break;
        }

        Log.e("AntNext", "AntViewManager viewError Error: " + errorString);

        // 提示
        Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show();
    }

}
