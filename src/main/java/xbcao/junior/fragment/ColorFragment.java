package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;

public class ColorFragment extends Fragment {

    public static ColorFragment newInstance(){
        return new ColorFragment();
    }
    public ColorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        // 从布局文件中获取名叫tv_code_six的文本视图
        TextView tv_code_six = view.findViewById(R.id.tv_code_six);
        // 给文本视图tv_code_six设置背景为透明的绿色，透明就是看不到
        tv_code_six.setBackgroundColor(0x00ff00);
        // 从布局文件中获取名叫tv_code_eight的文本视图
        TextView tv_code_eight = view.findViewById(R.id.tv_code_eight);
        // 给文本视图tv_code_eight设置背景为不透明的绿色，即正常的绿色
        tv_code_eight.setBackgroundColor(0xff00ff00);
        return view;
    }

}
