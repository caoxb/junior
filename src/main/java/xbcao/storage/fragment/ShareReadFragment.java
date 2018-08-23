package xbcao.storage.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

import xbcao.junior.R;

public class ShareReadFragment extends Fragment {

    public static ShareReadFragment newInstance(){
        return new ShareReadFragment();
    }


    public ShareReadFragment() {
        // Required empty public constructor
    }

    private TextView tv_share;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_read, container, false);
        tv_share = view.findViewById(R.id.tv_share);
        readSharedPreferences();
        return view;
    }

    private void readSharedPreferences() {
        // 从share.xml中获取共享参数对象
        SharedPreferences shared = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        String desc = "共享参数中保存的信息如下：";
        // 获取共享参数中保存的所有映射配对信息
        Map<String, Object> mapParam = (Map<String, Object>) shared.getAll();
        // 遍历该映射对象，并将配对信息形成描述文字
        for (Map.Entry<String, Object> item_map : mapParam.entrySet()) {
            String key = item_map.getKey(); // 获取该配对的键信息
            Object value = item_map.getValue(); // 获取该配对的值信息
            if (value instanceof String) { // 如果配对值的类型为字符串
                desc = String.format("%s\n　%s的取值为%s", desc, key,
                        shared.getString(key, ""));
            } else if (value instanceof Integer) { // 如果配对值的类型为整型数
                desc = String.format("%s\n　%s的取值为%d", desc, key,
                        shared.getInt(key, 0));
            } else if (value instanceof Float) { // 如果配对值的类型为浮点数
                desc = String.format("%s\n　%s的取值为%f", desc, key,
                        shared.getFloat(key, 0.0f));
            } else if (value instanceof Boolean) { // 如果配对值的类型为布尔数
                desc = String.format("%s\n　%s的取值为%b", desc, key,
                        shared.getBoolean(key, false));
            } else if (value instanceof Long) { // 如果配对值的类型为长整型
                desc = String.format("%s\n　%s的取值为%d", desc, key,
                        shared.getLong(key, 0L));
            } else { // 如果配对值的类型为未知类型
                desc = String.format("%s\n参数%s的取值为未知类型", desc, key);
            }
        }
        if (mapParam.size() <= 0) {
            desc = "共享参数中保存的信息为空";
        }
        tv_share.setText(desc);
    }
}
