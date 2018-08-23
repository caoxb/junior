package xbcao.storage.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import xbcao.junior.R;
import xbcao.utils.DateUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareWriteFragment extends Fragment implements View.OnClickListener{

    public static ShareWriteFragment newInstance(){
        return new ShareWriteFragment();
    }

    public ShareWriteFragment() {
        // Required empty public constructor
    }

    private SharedPreferences mShared; // 声明一个共享参数对象
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private boolean bMarried = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_write, container, false);
        et_name = view.findViewById(R.id.et_name);
        et_age = view.findViewById(R.id.et_age);
        et_height = view.findViewById(R.id.et_height);
        et_weight = view.findViewById(R.id.et_weight);
        view.findViewById(R.id.btn_save).setOnClickListener(this);
        initTypeSpinner(view);
        // 从share.xml中获取共享参数对象
        mShared = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        return view;
    }
    // 初始化婚姻状况的下拉框
    private void initTypeSpinner(View view) {
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.item_select, typeArray);
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp_married = view.findViewById(R.id.sp_married);
        sp_married.setPrompt("请选择婚姻状况");
        sp_married.setAdapter(typeAdapter);
        sp_married.setSelection(0);
        sp_married.setOnItemSelectedListener(new TypeSelectedListener());
    }

    private String[] typeArray = {"未婚", "已婚"};
    class TypeSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            bMarried = (arg2==0)?false:true;
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if (TextUtils.isEmpty(name)) {
                showToast("请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                showToast("请先填写年龄");
                return;
            } else if (TextUtils.isEmpty(height)) {
                showToast("请先填写身高");
                return;
            } else if (TextUtils.isEmpty(weight)) {
                showToast("请先填写体重");
                return;
            }

            SharedPreferences.Editor editor = mShared.edit(); // 获得编辑器的对象
            editor.putString("name", name); // 添加一个名叫name的字符串参数
            editor.putInt("age", Integer.parseInt(age)); // 添加一个名叫age的整型参数
            editor.putLong("height", Long.parseLong(height)); // 添加一个名叫height的长整型参数
            editor.putFloat("weight", Float.parseFloat(weight)); // 添加一个名叫weight的浮点数参数
            editor.putBoolean("married", bMarried); // 添加一个名叫married的布尔型参数
            editor.putString("update_time", DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            editor.commit(); // 提交编辑器中的修改
            showToast("数据已写入共享参数");
        }
    }

    private void showToast(String desc) {
        Toast.makeText(getActivity(), desc, Toast.LENGTH_SHORT).show();
    }
}
