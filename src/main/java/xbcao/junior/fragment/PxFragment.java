package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.junior.utils.Utils;

public class PxFragment extends Fragment {

    public static PxFragment newInstance(){
        return new PxFragment();
    }

    public PxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_px, container, false);
        // 将10dp的尺寸大小转换为对应的px数值
        int dip_10 = Utils.dip2px(getActivity(), 10L);
        // 从布局文件中获取名叫tv_padding的文本视图
        TextView tv_padding = view.findViewById(R.id.tv_padding);
        // 设置该文本视图的内部文字与控件四周的间隔大小
        tv_padding.setPadding(dip_10, dip_10, dip_10, dip_10);
        return view;
    }

}
