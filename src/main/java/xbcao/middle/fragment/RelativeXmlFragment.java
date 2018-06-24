package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xbcao.junior.R;

public class RelativeXmlFragment extends Fragment {

    public static RelativeXmlFragment newInstance(){
        return new RelativeXmlFragment();
    }
    public RelativeXmlFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relative_xml, container, false);
    }

}
