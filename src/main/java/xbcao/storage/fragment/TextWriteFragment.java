package xbcao.storage.fragment;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import xbcao.junior.R;
import xbcao.utils.DateUtil;
import xbcao.utils.FileUtil;


public class TextWriteFragment extends Fragment implements View.OnClickListener {

    public static TextWriteFragment newInstance(){
        return new TextWriteFragment();
    }
    public TextWriteFragment() {
        // Required empty public constructor
    }
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private boolean bMarried = false;
    private String mPath;
    private TextView tv_path;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_write, container, false);
        et_name = view.findViewById(R.id.et_name);
        et_age = view.findViewById(R.id.et_age);
        et_height = view.findViewById(R.id.et_height);
        et_weight = view.findViewById(R.id.et_weight);
        tv_path = view.findViewById(R.id.tv_path);
        view.findViewById(R.id.btn_save).setOnClickListener(this);
        // 获取当前App的私有存储目录
        mPath = getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/";
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

            String content = "";
            content = String.format("%s　姓名：%s\n", content, name);
            content = String.format("%s　年龄：%s\n", content, age);
            content = String.format("%s　身高：%scm\n", content, height);
            content = String.format("%s　体重：%skg\n", content, weight);
            content = String.format("%s　婚否：%s\n", content, typeArray[!bMarried ? 0 : 1]);
            content = String.format("%s　注册时间：%s\n", content, DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String file_path = mPath + DateUtil.getNowDateTime("") + ".txt";
                // 把文本字符串保存为文本文件
                FileUtil.saveText(file_path, content);
                tv_path.setText("用户注册信息文件的保存路径为：\n" + file_path);
                showToast("数据已写入SD卡文件");
            } else {
                showToast("未发现已挂载的SD卡，请检查");
            }
        }
    }

    private void showToast(String desc) {
        Toast.makeText(getActivity(), desc, Toast.LENGTH_SHORT).show();
    }

}
