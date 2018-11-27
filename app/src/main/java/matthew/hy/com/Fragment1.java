package matthew.hy.com;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment1 extends Fragment {


    @BindView(R.id.sdv_matthew)
    SimpleDraweeView sdvMatthew;
    Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        Uri uri = Uri.parse("http://img17.3lian.com/d/file/201703/13/a2e9bf2c4470e1e5a8ec5928e40e5d8e.jpg");
        sdvMatthew.setImageURI(uri);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
