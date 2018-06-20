package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.junior.utils.Utils;

public class ScreenFragment extends Fragment {

    public static ScreenFragment newInstance(){
        return new ScreenFragment();
    }
    public ScreenFragment() {
        // Required empty public constructor
    }

    private TextView tv_screen; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen, container, false);
        // 从布局文件中获取名叫tv_screen的文本视图
        tv_screen = view.findViewById(R.id.tv_screen);
        showScreenInfo();
        return view;
    }
    // 显示当前手机的屏幕参数信息
    private void showScreenInfo() {
        // 获取手机屏幕的宽度
        int width = Utils.getScreenWidth(getActivity());
        // 获取手机屏幕的高度
        int height = Utils.getScreenHeight(getActivity());
        // 获取手机屏幕的像素密度
        float density = Utils.getScreenDensity(getActivity());
        // 拼接屏幕参数信息的内容文本
        String info = String.format("当前屏幕的宽度是%dpx，高度是%dpx，像素密度是%f",
                width, height, density);
        // 设置文本视图tv_screen的文本内容
        tv_screen.setText(info);
    }
}
