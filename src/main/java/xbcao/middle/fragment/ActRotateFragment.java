package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.utils.DateUtil;

public class ActRotateFragment extends Fragment {

    public static ActRotateFragment newInstance(){
        return new ActRotateFragment();
    }
    public ActRotateFragment() {
        // Required empty public constructor
    }

    private final static String TAG = "ActRotateActivity";
    private TextView tv_life; // 声明一个文本视图对象
    private String mStr = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act_rotate, container, false);
        // 从布局文件中获取名叫tv_life的文本视图
        tv_life = view.findViewById(R.id.tv_life);
        refreshLife("onCreate");
        return view;
    }
    public void refreshLife(String desc) { // 刷新生命周期的日志信息
        Log.d(TAG, desc);
        mStr = String.format("%s%s %s %s\n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

}
