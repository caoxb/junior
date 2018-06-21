package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import xbcao.junior.R;

public class SwitchIOSFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public static SwitchIOSFragment newInstance(){
        return new SwitchIOSFragment();
    }
    public SwitchIOSFragment() {
        // Required empty public constructor
    }
    private CheckBox ck_status; // 声明一个复选框对象
    private TextView tv_result; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switch_io, container, false);
        // 从布局文件中获取名叫sw_status的开关按钮
        ck_status = view.findViewById(R.id.ck_status);
        // 从布局文件中获取名叫tv_result的文本视图
        tv_result = view.findViewById(R.id.tv_result);
        // 给开关按钮设置选择监听器，一旦用户点击它，就触发监听器的onCheckedChanged方法
        ck_status.setOnCheckedChangeListener(this);
        refreshResult();
        return view;
    }
    // 刷新仿iOS按钮的开关状态说明
    private void refreshResult() {
        String result = String.format("仿iOS开关的状态是%s", (ck_status.isChecked()) ? "开" : "关");
        tv_result.setText(result);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        refreshResult();
    }
}
