package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import xbcao.junior.R;

public class EditAutoFragment extends Fragment {

    public static EditAutoFragment newInstance(){
        return new EditAutoFragment();
    }
    public EditAutoFragment() {
        // Required empty public constructor
    }

    // 定义自动完成的提示文本数组
    private String[] hintArray = {"第一", "第一次", "第一次写代码", "第一次领工资", "第二", "第二个"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_auto, container, false);
        // 从布局文件中获取名叫ac_text的自动完成编辑框
        AutoCompleteTextView ac_text = view.findViewById(R.id.ac_text);
        // 声明一个自动完成时下拉展示的数组适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_dropdown, hintArray);
        // 设置自动完成编辑框的数组适配器
        ac_text.setAdapter(adapter);
        return view;
    }

}
