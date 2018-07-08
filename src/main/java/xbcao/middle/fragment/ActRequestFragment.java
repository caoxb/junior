package xbcao.middle.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.middle.activity.ActResponseActivity;
import xbcao.utils.DateUtil;


public class ActRequestFragment extends Fragment implements View.OnClickListener {

    public static ActRequestFragment newInstance(){
        return new ActRequestFragment();
    }

    public ActRequestFragment() {
        // Required empty public constructor
    }

    private EditText et_request; // 声明一个编辑框对象
    private TextView tv_request; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act_request, container, false);
        view.findViewById(R.id.btn_act_request).setOnClickListener(this);
        // 从布局文件中获取名叫et_request的编辑框
        et_request = view.findViewById(R.id.et_request);
        // 从布局文件中获取名叫tv_request的文本视图
        tv_request = view.findViewById(R.id.tv_request);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_act_request) {
            // 创建一个新意图
            Intent intent = new Intent();
            // 设置意图要跳转的活动类
            intent.setClass(getActivity(), ActResponseActivity.class);
            // 往意图存入名叫request_time的字符串
            intent.putExtra("request_time", DateUtil.getNowTime());
            // 往意图存入名叫request_content的字符串
            intent.putExtra("request_content", et_request.getText().toString());
            // 期望接收下个页面的返回数据
            startActivityForResult(intent, 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            // 从意图中取出名叫response_time的字符串
            String response_time = data.getStringExtra("response_time");
            // 从意图中取出名叫response_content的字符串
            String response_content = data.getStringExtra("response_content");
            String desc = String.format("收到返回消息：\n应答时间为%s\n应答内容为%s", response_time, response_content);
            // 把返回消息的详情显示在文本视图上
            tv_request.setText(desc);
        }
    }
}
