package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import xbcao.junior.R;
import xbcao.utils.Utils;

public class RelativeCodeFragment extends Fragment implements View.OnClickListener {

    public static RelativeCodeFragment newInstance(){
        return new RelativeCodeFragment();
    }
    public RelativeCodeFragment() {
        // Required empty public constructor
    }
    private RelativeLayout rl_content; // 声明一个相对布局对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relative_code, container, false);
        // 从布局文件中获取名叫rl_content的相对布局
        rl_content = view.findViewById(R.id.rl_content);
        // 下面通过不同按钮演示在相对布局内部的指定位置添加子视图
        view.findViewById(R.id.btn_add_left).setOnClickListener(this);
        view.findViewById(R.id.btn_add_above).setOnClickListener(this);
        view.findViewById(R.id.btn_add_right).setOnClickListener(this);
        view.findViewById(R.id.btn_add_below).setOnClickListener(this);
        view.findViewById(R.id.btn_add_center).setOnClickListener(this);
        view.findViewById(R.id.btn_add_parent_left).setOnClickListener(this);
        view.findViewById(R.id.btn_add_parent_top).setOnClickListener(this);
        view.findViewById(R.id.btn_add_parent_right).setOnClickListener(this);
        view.findViewById(R.id.btn_add_parent_bottom).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_left) {
            addNewView(RelativeLayout.LEFT_OF, RelativeLayout.ALIGN_TOP, v.getId());
        } else if (v.getId() == R.id.btn_add_above) {
            addNewView(RelativeLayout.ABOVE, RelativeLayout.ALIGN_LEFT, v.getId());
        } else if (v.getId() == R.id.btn_add_right) {
            addNewView(RelativeLayout.RIGHT_OF, RelativeLayout.ALIGN_BOTTOM, v.getId());
        } else if (v.getId() == R.id.btn_add_below) {
            addNewView(RelativeLayout.BELOW, RelativeLayout.ALIGN_RIGHT, v.getId());
        } else if (v.getId() == R.id.btn_add_center) {
            addNewView(RelativeLayout.CENTER_IN_PARENT, -1, rl_content.getId());
        } else if (v.getId() == R.id.btn_add_parent_left) {
            addNewView(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.CENTER_VERTICAL, rl_content.getId());
        } else if (v.getId() == R.id.btn_add_parent_top) {
            addNewView(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.CENTER_HORIZONTAL, rl_content.getId());
        } else if (v.getId() == R.id.btn_add_parent_right) {
            addNewView(RelativeLayout.ALIGN_PARENT_RIGHT, -1, rl_content.getId());
        } else if (v.getId() == R.id.btn_add_parent_bottom) {
            addNewView(RelativeLayout.ALIGN_PARENT_BOTTOM, -1, rl_content.getId());
        }
    }

    // 通过代码在相对布局下面添加新视图，referId代表参考对象的编号
    private void addNewView(int firstAlign, int secondAlign, int referId) {
        // 创建一个新的视图对象
        View v = new View(getActivity());
        // 把该视图的背景设置为半透明的绿色
        v.setBackgroundColor(0xaa66ff66);
        // 声明一个布局参数，其中宽度为100p，高度也为100dp
        RelativeLayout.LayoutParams rl_params = new RelativeLayout.LayoutParams(
                Utils.dip2px(getActivity(), 100), Utils.dip2px(getActivity(), 100));
        // 给布局参数添加第一个相对位置的规则，firstAlign代表位置类型，referId代表参考对象
        rl_params.addRule(firstAlign, referId);
        if (secondAlign >= 0) {
            // 如果存在第二个相对位置，则同时给布局参数添加第二个相对位置的规则
            rl_params.addRule(secondAlign, referId);
        }
        // 给该视图设置布局参数
        v.setLayoutParams(rl_params);
        // 设置该视图的长按监听器
        v.setOnLongClickListener(new View.OnLongClickListener() {
            // 在用户长按该视图时触发
            public boolean onLongClick(View vv) {
                // 一旦监听到长按事件，就从相对布局中删除该视图
                rl_content.removeView(vv);
                return true;
            }
        });
        // 往相对布局中添加该视图
        rl_content.addView(v);
    }
}
