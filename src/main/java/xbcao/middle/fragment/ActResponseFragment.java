package xbcao.middle.fragment;


import android.app.Activity;
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
import xbcao.utils.DateUtil;

public class ActResponseFragment extends Fragment implements View.OnClickListener {

    public static ActResponseFragment newInstance(){
        return new ActResponseFragment();
    }

    public ActResponseFragment() {
        // Required empty public constructor
    }

    private EditText et_response; // 声明一个编辑框对象
    private TextView tv_response; // 声明一个文本视图对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act_response, container, false);
        view.findViewById(R.id.btn_act_response).setOnClickListener(this);
        // 从布局文件中获取名叫et_response的编辑框
        et_response = view.findViewById(R.id.et_response);
        // 从布局文件中获取名叫tv_response的文本视图
        tv_response = view.findViewById(R.id.tv_response);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 从前一个页面传来的意图中获取快递包裹
        Bundle bundle = getActivity().getIntent().getExtras();
        // 从包裹中取出名叫request_time的字符串
        String request_time = bundle.getString("request_time");
        // 从包裹中取出名叫request_content的字符串
        String request_content = bundle.getString("request_content");
        String desc = String.format("收到请求消息：\n请求时间为%s\n请求内容为%s", request_time, request_content);
        // 把请求消息的详情显示在文本视图上
        tv_response.setText(desc);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_act_response) {
            Intent intent = new Intent(); // 创建一个新意图
            Bundle bundle = new Bundle(); // 创建一个新包裹
            // 往包裹存入名叫response_time的字符串
            bundle.putString("response_time", DateUtil.getNowTime());
            // 往包裹存入名叫response_content的字符串
            bundle.putString("response_content", et_response.getText().toString());
            intent.putExtras(bundle); // 把快递包裹塞给意图
            getActivity().setResult(Activity.RESULT_OK, intent); // 携带意图返回前一个页面
            getActivity().finish(); // 关闭当前页面
        }
    }
}
