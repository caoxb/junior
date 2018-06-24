package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import xbcao.junior.R;

public class RadioHorizontalFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    public static RadioHorizontalFragment newInstance(){
        return new RadioHorizontalFragment();
    }
    public RadioHorizontalFragment() {
        // Required empty public constructor
    }

    private TextView tv_sex; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_horizontal, container, false);
        // 从布局文件中获取名叫tv_sex的文本视图
        tv_sex = view.findViewById(R.id.tv_sex);
        // 从布局文件中获取名叫rg_sex的单选组
        RadioGroup rg_sex = view.findViewById(R.id.rg_sex);
        // 给rg_sex设置单选监听器，一旦用户点击组内的单选按钮，就触发监听器的onCheckedChanged方法
        rg_sex.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rb_male) {
            tv_sex.setText("哇哦，你是个帅气的男孩");
        } else if (checkedId == R.id.rb_female) {
            tv_sex.setText("哇哦，你是个漂亮的女孩");
        }
    }
}
