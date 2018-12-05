package matthew.hy.com;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : Heyang
 * e-mail : 15258836173@163.com
 * date   : 2018/12/511:58
 * desc   :
 * version: 1.0
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder binder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initFgId(), container, false);
        binder = ButterKnife.bind(getActivity());
        initViewFg(view);
        return view;
    }


    protected abstract int initFgId();

    protected abstract void initViewFg(View view);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (binder != null)
            binder.unbind();
    }
}
