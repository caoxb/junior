package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import xbcao.junior.R;

public class CheckboxFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public static CheckboxFragment newInstance(){
        return new CheckboxFragment();
    }
    public CheckboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox, container, false);
        // 从布局文件中获取名叫ck_system的复选框
        CheckBox ck_system = view.findViewById(R.id.ck_system);
        // 从布局文件中获取名叫ck_custom的复选框
        CheckBox ck_custom = view.findViewById(R.id.ck_custom);
        // 给ck_system设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        ck_system.setOnCheckedChangeListener(this);
        // 给ck_custom设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        ck_custom.setOnCheckedChangeListener(this);
        // 给ck_system设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        //ck_system.setOnCheckedChangeListener(new CheckListener());
        // 给ck_custom设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        //ck_custom.setOnCheckedChangeListener(new CheckListener());
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("您%s了这个CheckBox", isChecked ? "勾选" : "取消勾选");
        buttonView.setText(desc);
    }

    // 定义一个勾选监听器，它实现了接口CompoundButton.OnCheckedChangeListener
    private class CheckListener implements CompoundButton.OnCheckedChangeListener{
        // 在用户点击复选框时触发
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String desc = String.format("您勾选了控件%d，状态为%b", buttonView.getId(), isChecked);
            Toast.makeText(getActivity(), desc, Toast.LENGTH_LONG).show();
        }
    }
}
