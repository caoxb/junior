package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;

public class MarqueeFragment extends Fragment implements View.OnClickListener{

    public static MarqueeFragment newInstance(){
        return new MarqueeFragment();
    }
    public MarqueeFragment() {
        // Required empty public constructor
    }
    private TextView tv_marquee; // 声明一个文本视图对象
    private boolean isPaused = false; // 跑马灯文字是否暂停滚动
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_marquee, container, false);
        // 从布局文件中获取名叫tv_marquee的文本视图
        tv_marquee = view.findViewById(R.id.tv_marquee);
        // 给tv_marquee设置点击监听器
        tv_marquee.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_marquee) { // 点击了文本视图tv_marquee
            isPaused = !isPaused;
            if (isPaused) {
                tv_marquee.setFocusable(false); // 不允许获得焦点
                tv_marquee.setFocusableInTouchMode(false); // 不允许在触摸时获得焦点
            } else {
                tv_marquee.setFocusable(true); // 允许获得焦点
                tv_marquee.setFocusableInTouchMode(true); // 允许在触摸时获得焦点
                tv_marquee.requestFocus(); // 强制获得焦点，让跑马灯滚起来
            }
        }
    }
}
