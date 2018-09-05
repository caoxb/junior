package xbcao.storage.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.utils.DateUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuOptionFragment extends Fragment implements View.OnClickListener{


    public MenuOptionFragment() {
        // Required empty public constructor
    }
    public static MenuOptionFragment newInstance(){
        return new MenuOptionFragment();
    }
    private TextView tv_option;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_option, container, false);
        tv_option = view.findViewById(R.id.tv_option);
        view.findViewById(R.id.btn_option).setOnClickListener(this);
        setRandomTime();
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_option) {
            // 注意：如果当前页面继承自AppCompatActivity，并且appcompat版本不低于22.1.0
            // 那么调用openOptionsMenu方法将不会弹出菜单。这应该是Android的一个bug
            getActivity().openOptionsMenu();
        }
    }

    // 在选项菜单的菜单界面创建时调用
    public boolean onCreateOptionsMenu(Menu menu) {
        // 从menu_option.xml中构建菜单界面布局
        getActivity().getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    // 在选项菜单的菜单项选中时调用
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // 获取菜单项的编号
        if (id == R.id.menu_change_time) { // 点击了菜单项“改变时间”
            setRandomTime();
        } else if (id == R.id.menu_change_color) { // 点击了菜单项“改变颜色”
            tv_option.setTextColor(getRandomColor());
        } else if (id == R.id.menu_change_bg) { // 点击了菜单项“改变背景”
            tv_option.setBackgroundColor(getRandomColor());
        }
        return true;
    }
    private void setRandomTime() {
        String desc = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss") + " 这里是菜单显示文本";
        tv_option.setText(desc);
    }

    private int[] mColorArray = {
            Color.BLACK, Color.WHITE, Color.RED, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.DKGRAY
    };

    // 获取随机的颜色值
    private int getRandomColor() {
        int random = (int) (Math.random() * 10 % 10);
        return mColorArray[random];
    }
}
