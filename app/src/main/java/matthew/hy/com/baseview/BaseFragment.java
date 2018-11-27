package matthew.hy.com.baseview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutId(), container, false);
        unBind = ButterKnife.bind(this, view);
        initFragementData();
        return view;
    }

    public abstract int getFragmentLayoutId();

    public abstract void initFragementData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBind != null) {
            unBind.unbind();
        }
    }
}
