package matthew.hy.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class AntBaseFragment extends Fragment {
    /**
     * Fragemnt的基类
     */
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    /**
     * 获取Context
     */
    public Context getAntContext() {
        return mContext;
    }
}
