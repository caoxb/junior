package xbcao.middle.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import xbcao.junior.R;

public class ActUriFragment extends Fragment implements View.OnClickListener {

    public static ActUriFragment newInstance(){
        return new ActUriFragment();
    }
    public ActUriFragment() {
        // Required empty public constructor
    }

    private EditText et_phone; // 声明一个编辑框对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act_uri, container, false);
        view.findViewById(R.id.btn_call).setOnClickListener(this);
        view.findViewById(R.id.btn_dial).setOnClickListener(this);
        view.findViewById(R.id.btn_sms).setOnClickListener(this);
        // 从布局文件中获取名叫et_phone的编辑框
        et_phone = view.findViewById(R.id.et_phone);
        return view;
    }

    @Override
    public void onClick(View v) {
        // 获取编辑框的输入文本
        String phone = et_phone.getText().toString();
        if (v.getId() == R.id.btn_call) { // 点击了直接拨号按钮
            // 拨号功能还需在AndroidManifest.xml中添加拨号权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_CALL); // 设置意图动作为直接拨号
            Uri uri = Uri.parse("tel:" + phone); // 声明一个拨号的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        } else if (v.getId() == R.id.btn_dial) { // 点击了准备拨号按钮
            // 拨号功能还需在AndroidManifest.xml中添加拨号权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_DIAL); // 设置意图动作为准备拨号
            Uri uri = Uri.parse("tel:" + phone); // 声明一个拨号的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        } else if (v.getId() == R.id.btn_sms) { // 点击了发送短信按钮
            // 发送短信还需在AndroidManifest.xml中添加发短信的权限配置
            Intent intent = new Intent(); // 创建一个新意图
            intent.setAction(Intent.ACTION_SENDTO); // 设置意图动作为发短信
            Uri uri = Uri.parse("smsto:" + phone); // 声明一个发送短信的Uri
            intent.setData(uri); // 设置意图前往的路径
            startActivity(intent); // 启动意图通往的活动页面
        }
    }
}
