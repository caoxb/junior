package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xbcao.junior.R;

public class ShapeFragment extends Fragment implements View.OnClickListener{
    private View v_content; // 声明一个视图对象

    public static ShapeFragment newInstance(){
        return new ShapeFragment();
    }
    public ShapeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shape, container, false);
        // 从布局文件中获取名叫v_content的视图
        v_content = view.findViewById(R.id.v_content);
        // 给btn_rect设置点击监听器
        view.findViewById(R.id.btn_rect).setOnClickListener(this);
        // 给btn_oval设置点击监听器
        view.findViewById(R.id.btn_oval).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_rect) { // 点击了按钮btn_rect
            // 把矩形形状设置为v_content的背景
            v_content.setBackgroundResource(R.drawable.shape_rect_gold);
        } else if (v.getId() == R.id.btn_oval) { // 点击了按钮btn_oval
            // 把椭圆形状设置为v_content的背景
            v_content.setBackgroundResource(R.drawable.shape_oval_rose);
        }
    }
}
