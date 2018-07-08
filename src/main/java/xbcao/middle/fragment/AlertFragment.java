package xbcao.middle.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;

public class AlertFragment extends Fragment implements View.OnClickListener {

    public static AlertFragment newInstance(){
        return  new AlertFragment();
    }
    public AlertFragment() {
        // Required empty public constructor
    }
    private TextView tv_alert; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert, container, false);
        // 给btn_alert设置点击监听器，一旦用户点击按钮，就触发监听器的onClick方法
        view.findViewById(R.id.btn_alert).setOnClickListener(this);
        // 从布局文件中获取名叫tv_alert的文本视图
        tv_alert = view.findViewById(R.id.tv_alert);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_alert) {
            // 创建提醒对话框的建造器
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // 给建造器设置对话框的标题文本
            builder.setTitle("尊敬的用户");
            // 给建造器设置对话框的信息文本
            builder.setMessage("你真的要卸载我吗？");
            // 给建造器设置对话框的肯定按钮文本及其点击监听器
            builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv_alert.setText("虽然依依不舍，但是只能离开了");
                }
            });
            // 给建造器设置对话框的否定按钮文本及其点击监听器
            builder.setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv_alert.setText("让我再陪你三百六十五个日夜");
                }
            });
            // 根据建造器完成提醒对话框对象的构建
            AlertDialog alert = builder.create();
            // 在界面上显示提醒对话框
            alert.show();
        }
    }
}
