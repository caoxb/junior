package xbcao.storage.fragment;


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

import xbcao.bean.UserInfo;
import xbcao.database.UserDBHelper;
import xbcao.junior.R;
import xbcao.utils.DateUtil;

public class SQLiteWriteFragment extends Fragment implements View.OnClickListener {

    public static SQLiteWriteFragment newInstance(){
        return new SQLiteWriteFragment();
    }
    public SQLiteWriteFragment() {
        // Required empty public constructor
    }

    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private boolean bMarried = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sqlite_write, container, false);
        et_name = view.findViewById(R.id.et_name);
        et_age = view.findViewById(R.id.et_age);
        et_height = view.findViewById(R.id.et_height);
        et_weight = view.findViewById(R.id.et_weight);
        view.findViewById(R.id.btn_save).setOnClickListener(this);
        initTypeSpinner(view);
        return view;
    }

    private String[] typeArray = {"未婚", "已婚"};
    // 初始化婚姻状况的下拉框
    private void initTypeSpinner(View view) {
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_select, typeArray);
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp_married = view.findViewById(R.id.sp_married);
        sp_married.setPrompt("请选择婚姻状况");
        sp_married.setAdapter(typeAdapter);
        sp_married.setSelection(0);
        sp_married.setOnItemSelectedListener(new TypeSelectedListener());
    }

    private class TypeSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            bMarried = (arg2 == 0) ? false : true;
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        // 获得数据库帮助器的实例
        mHelper = UserDBHelper.getInstance(getActivity(), 2);
        // 打开数据库帮助器的写连接
        mHelper.openWriteLink();
    }

    @Override
    public void onStop() {
        super.onStop();
        // 关闭数据库连接
        mHelper.closeLink();
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
            // 以下声明一个用户信息对象，并填写它的各字段值
            UserInfo info = new UserInfo();
            info.name = name;
            info.age = Integer.parseInt(age);
            info.height = Long.parseLong(height);
            info.weight = Float.parseFloat(weight);
            info.married = bMarried;
            info.update_time = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss");
            // 执行数据库帮助器的插入操作
            mHelper.insert(info);
            showToast("数据已写入SQLite数据库");
        }
    }

    private void showToast(String desc) {
        Toast.makeText(getActivity(), desc, Toast.LENGTH_SHORT).show();
    }
}
