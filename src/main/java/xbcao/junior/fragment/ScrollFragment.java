package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xbcao.junior.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScrollFragment extends Fragment {

    public static ScrollFragment newInstance(){
        return new ScrollFragment();
    }
    public ScrollFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll, container, false);
    }

}
