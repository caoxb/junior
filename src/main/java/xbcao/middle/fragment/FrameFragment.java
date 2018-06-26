package xbcao.middle.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import xbcao.junior.R;
import xbcao.utils.Utils;

public class FrameFragment extends Fragment implements View.OnClickListener {

    public static FrameFragment newInstance(){
        return new FrameFragment();
    }
    public FrameFragment() {
        // Required empty public constructor
    }

    private FrameLayout fl_content; // 声明一个框架布局对象
    // 定义一个颜色数组
    private int[] mColorArray = {
            Color.BLACK, Color.WHITE, Color.RED, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.DKGRAY
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame, container, false);
        // 从布局文件中获取名叫fl_content的框架布局
        fl_content = view.findViewById(R.id.fl_content);
        view.findViewById(R.id.btn_add_frame).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_frame) {
            int random = (int) (Math.random() * 10 % 10);
            // 创建一个新的视图对象
            View vv = new View(getActivity());
            // 把该视图的背景设置为随机颜色
            vv.setBackgroundColor(mColorArray[random]);
            // 声明一个布局参数，其中宽度与上级持平，高度为随机高度
            LinearLayout.LayoutParams ll_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, Utils.dip2px(getActivity(), (random + 1) * 30));
            // 给该视图设置布局参数
            vv.setLayoutParams(ll_params);
            // 设置该视图的长按监听器
            vv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View vvv) {
                    // 一旦监听到长按事件，就从相对布局中删除该视图
                    fl_content.removeView(vvv);
                    return true;
                }
            });
            // 往框架布局中添加该视图
            fl_content.addView(vv);
        }
    }
}
