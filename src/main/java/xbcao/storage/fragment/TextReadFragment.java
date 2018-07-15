package xbcao.storage.fragment;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import xbcao.junior.R;
import xbcao.utils.FileUtil;

public class TextReadFragment extends Fragment implements View.OnClickListener {

    public static TextReadFragment newInstance(){
        return new TextReadFragment();
    }

    public TextReadFragment() {
        // Required empty public constructor
    }

    private final static String TAG = "TextReadActivity";
    private TextView tv_text;
    private Spinner sp_file;
    private String mPath;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_read, container, false);
        tv_text = view.findViewById(R.id.tv_text);
        sp_file = view.findViewById(R.id.sp_file);
        view.findViewById(R.id.btn_delete).setOnClickListener(this);
        // 获取当前App的私有存储目录
        mPath = getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            refreshSpinner();
        } else {
            showToast("未发现已挂载的SD卡，请检查");
        }
        return view;
    }

    private String[] fileArray;
    private void refreshSpinner() {
        // 获得指定目录下面的所有文本文件
        ArrayList<File> fileAlllist = FileUtil.getFileList(mPath, new String[]{".txt"});
        if (fileAlllist.size() > 0) {
            fileArray = new String[fileAlllist.size()];
            for (int i = 0; i < fileAlllist.size(); i++) {
                fileArray[i] = fileAlllist.get(i).getName();
            }
            ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_select, fileArray);
            typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
            sp_file.setPrompt("请选择文本文件");
            sp_file.setAdapter(typeAdapter);
            sp_file.setSelection(0);
            sp_file.setOnItemSelectedListener(new FileSelectedListener());
        } else {
            fileArray = null;
            fileArray = new String[1];
            fileArray[0] = "";
            ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_select, fileArray);
            sp_file.setPrompt(null);
            sp_file.setAdapter(typeAdapter);
            sp_file.setOnItemSelectedListener(null);
            tv_text.setText("");
        }
    }

    class FileSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            // 打开并显示选中的文本文件内容
            String file_path = mPath + fileArray[arg2];
            String content = FileUtil.openText(file_path);
            tv_text.setText("文件内容如下：\n" + content);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_delete) {
            for (int i = 0; i < fileArray.length; i++) {
                String file_path = mPath + fileArray[i];
                File f = new File(file_path);
                if (!f.delete()) {
                    Log.d(TAG, "file_path=" + file_path + ", delete failed");
                }
            }
            refreshSpinner();
            showToast("已删除临时目录下的所有文本文件");
        }
    }

    private void showToast(String desc) {
        Toast.makeText(getActivity(), desc, Toast.LENGTH_SHORT).show();
    }
}
