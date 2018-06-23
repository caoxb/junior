package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import xbcao.junior.R;


public class SwitchDefaultFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public static SwitchDefaultFragment newInstance(){
        return new SwitchDefaultFragment();
    }
    public SwitchDefaultFragment() {
        // Required empty public constructor
    }

    private Switch sw_status; // 声明一个开关按钮对象
    private TextView tv_result; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switch_default, container, false);
        // 从布局文件中获取名叫sw_status的开关按钮
        sw_status = view.findViewById(R.id.sw_status);
        // 从布局文件中获取名叫tv_result的文本视图
        tv_result = view.findViewById(R.id.tv_result);
        // 给开关按钮设置选择监听器，一旦用户点击它，就触发监听器的onCheckedChanged方法
        sw_status.setOnCheckedChangeListener(this);
        refreshResult();
        return view;
    }
    // 刷新Switch按钮的开关状态说明
    private void refreshResult() {
        String result = String.format("Switch按钮的状态是%s", (sw_status.isChecked()) ? "开" : "关");
        tv_result.setText(result);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        refreshResult();
    }
}
