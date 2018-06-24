package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import xbcao.junior.R;

public class RadioVerticalFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    public static RadioVerticalFragment newInstance(){
        return new RadioVerticalFragment();
    }
    public RadioVerticalFragment() {
        // Required empty public constructor
    }

    private TextView tv_marry; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_vertical, container, false);
        // 从布局文件中获取名叫tv_marry的文本视图
        tv_marry = view.findViewById(R.id.tv_marry);
        // 从布局文件中获取名叫rg_marry的单选组
        RadioGroup rg_marry = view.findViewById(R.id.rg_marry);
        // 给rg_marry设置单选监听器，一旦用户点击组内的单选按钮，就触发监听器的onCheckedChanged方法
        rg_marry.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rb_married) {
            tv_marry.setText("哇哦，祝你早生贵子");
        } else if (checkedId == R.id.rb_unmarried) {
            tv_marry.setText("哇哦，你的前途不可限量");
        }
    }
}
