package xbcao.junior.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import xbcao.junior.R;

public class IconFragment extends Fragment implements View.OnClickListener{

    public static IconFragment newInstance(){
        return new IconFragment();
    }
    public IconFragment() {
        // Required empty public constructor
    }
    private Button btn_icon; // 声明一个按钮对象
    private Drawable drawable; // 声明一个图形对象

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icon, container, false);
        // 从布局文件中获取名叫btn_icon的按钮控件
        btn_icon = view.findViewById(R.id.btn_icon);
        // 从资源文件ic_launcher.png中获取图形对象
        drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        // 设置图形对象的矩形边界大小，注意必须设置图片大小，否则不会显示图片
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        // 下面通过四个按钮，分别演示左、上、右、下四个方向的图标效果
        view.findViewById(R.id.btn_left).setOnClickListener(this);
        view.findViewById(R.id.btn_top).setOnClickListener(this);
        view.findViewById(R.id.btn_right).setOnClickListener(this);
        view.findViewById(R.id.btn_bottom).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_left) {
            // 设置按钮控件btn_icon内部文字左边的图标
            btn_icon.setCompoundDrawables(drawable, null, null, null);
        } else if (v.getId() == R.id.btn_top) {
            // 设置按钮控件btn_icon内部文字上方的图标
            btn_icon.setCompoundDrawables(null, drawable, null, null);
        } else if (v.getId() == R.id.btn_right) {
            // 设置按钮控件btn_icon内部文字右边的图标
            btn_icon.setCompoundDrawables(null, null, drawable, null);
        } else if (v.getId() == R.id.btn_bottom) {
            // 设置按钮控件btn_icon内部文字下方的图标
            btn_icon.setCompoundDrawables(null, null, null, drawable);
        }
    }
}
