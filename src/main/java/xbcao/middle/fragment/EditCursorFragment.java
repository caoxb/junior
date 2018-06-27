package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xbcao.junior.R;

public class EditCursorFragment extends Fragment {

    public static EditCursorFragment newInstance(){
        return new EditCursorFragment();
    }

    public EditCursorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_cursor, container, false);

        return view;
    }

}
