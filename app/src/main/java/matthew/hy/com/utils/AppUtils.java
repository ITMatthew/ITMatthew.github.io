package matthew.hy.com.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class AppUtils {
    private static Toast mToast;

    public static void showToast(String msg, Context context){
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            }
            mToast.setText(msg);
            mToast.show();

    }
    /**
     * 打印information日志
     * @param tag 标签
     * @param msg 日志信息
     */
    public static void i(String tag,String msg){
        Log.i(tag, msg);
    }

    /**
     * 打印information日志
     * @param tag	标签
     * @param msg	日志信息
     * @param throwable	异常
     */
    public static void i(String tag, String msg, Throwable throwable){
        Log.i(tag,msg,throwable);
    }

    /**
     * 打印verbose日志
     * @param tag	标签
     * @param msg	日志信息
     */
    public static void v(String tag, String msg){
        Log.v(tag, msg);
    }

    /**
     * 打印verbose日志
     * @param tag	标签
     * @param msg	日志信息
     * @param throwable	异常
     */
    public static void v(String tag, String msg, Throwable throwable){
        Log.v(tag, msg, throwable);
    }

    /**
     * 打印debug信息
     * @param tag	标签信息
     * @param msg	日志信息
     */
    public static void d(String tag, String msg){
        Log.d(tag, msg);
    }

    /**
     * 打印debug日志
     * @param tag	标签信息
     * @param msg	日志信息
     * @param throwable	异常
     */
    public static void d(String tag, String msg, Throwable throwable){
        Log.d(tag, msg, throwable);
    }

    /**
     * 打印warn日志
     * @param tag	标签信息
     * @param msg	日志信息
     */
    public static void w(String tag, String msg){
        Log.w(tag, msg);
    }

    /**
     * 打印warn日志
     * @param tag	标签信息
     * @param msg	日志信息
     * @param throwable	异常
     */
    public static void w(String tag, String msg, Throwable throwable){
        Log.w(tag, msg, throwable);
    }

    /**
     * 打印error日志
     * @param tag	标签
     * @param msg	日志信息
     */
    public static void e(String tag, String msg){
        Log.e(tag, msg);
    }

    /**
     * 打印error日志
     * @param tag	标签
     * @param msg	日志信息
     * @param throwable	异常
     */
    public static void e(String tag, String msg, Throwable throwable){
        Log.e(tag, msg, throwable);
    }

}
