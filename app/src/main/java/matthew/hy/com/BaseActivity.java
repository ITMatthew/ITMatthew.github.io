package matthew.hy.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 所有Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    private List<Activity> listActivity = new ArrayList<>();
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        mBind = ButterKnife.bind(this);
        initEventAndData();
    }

    protected abstract int getViewId();

    protected abstract void initEventAndData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }

    /**
     * 添加activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        listActivity.add(activity);
    }

    /**
     * 移除某个activity
     *
     * @param activity
     */
    public void removeSingle(Activity activity) {
        listActivity.remove(activity);
        if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 移除所有的activity(通常会在一键退出的时候使用)
     */
    public void finishAll() {
        for (Activity activity : listActivity
                ) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 清楚掉除了自己之外的activity
     * 这个方法一般会用在，如果activity任务栈中已经存在了几个activty了，但是你想回到最底层的activty并且销毁掉之前所有的activty
     * 比如说 现在有4个activity A B C D,A是第一个activty，然后进行activity的跳转 A ->B ->C ->D,然后你想从D->跳到A，并且销毁掉B和C，那么可以在进入到A后，在A中调用此方法
     * 举个实际点的例子：你想做一个切换账号的功能，一般此功能都是在 个人中心 ->设置 ->退出当前登录，那么如果你直接进入到登录界面进行登录不做任何处理的话，之前的activty没有finish掉
     * ，gc（垃圾回收机）也不会回收这些内存，这样很容易引起内存泄漏（亲身经历）
     *
     * @param activity
     */
    public void finishAllButNotMe(Activity activity) {
        for (Activity ac : listActivity
                ) {
            if (ac == activity) {
                //如果是当前的activty，不做任何处理
            } else if (!ac.isFinishing()) {
                //如果不是，finish掉
                ac.finish();
            }
        }
    }
}
