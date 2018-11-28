package matthew.hy.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import matthew.hy.com.R;


public class FgShopingCart extends Fragment {

    private ExpandableListView expandableListView;

//    @Override
//    public void onAntCreateView() {
//        mAntViewManager.updateViewState(AntViewEnum.SUCCE);
//    }
//
//    @Override
//    public View installSuccView(Context context) {
//        View view = View.inflate(context, R.layout.fg_shop_cart, null);
////        expandableListView = (ExpandableListView) view.findViewById(R.id.id_elv_listview);
//
//        return view;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_shop_cart,container,false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.id_elv_listview);

        return view;
    }
}
