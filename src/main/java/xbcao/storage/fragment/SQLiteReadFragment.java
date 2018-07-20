package xbcao.storage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import xbcao.bean.UserInfo;
import xbcao.database.UserDBHelper;
import xbcao.junior.R;

public class SQLiteReadFragment extends Fragment implements View.OnClickListener {

    public static SQLiteReadFragment newInstance(){
        return new SQLiteReadFragment();
    }
    public SQLiteReadFragment() {
        // Required empty public constructor
    }
    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private TextView tv_sqlite;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sqlite_read, container, false);
        tv_sqlite = view.findViewById(R.id.tv_sqlite);
        view.findViewById(R.id.btn_delete).setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // 获得数据库帮助器的实例
        mHelper = UserDBHelper.getInstance(getActivity(), 2);
        // 打开数据库帮助器的读连接
        mHelper.openReadLink();
        readSQLite();
    }

    @Override
    public void onStop() {
        super.onStop();
        // 关闭数据库连接
        mHelper.closeLink();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_delete) {
            // 关闭数据库连接
            mHelper.closeLink();
            // 打开数据库帮助器的写连接
            mHelper.openWriteLink();
            // 删除所有记录
            mHelper.deleteAll();
            // 关闭数据库连接
            mHelper.closeLink();
            // 打开数据库帮助器的读连接
            mHelper.openReadLink();
            readSQLite();
        }
    }

    // 读取数据库中保存的所有用户记录
    private void readSQLite() {
        if (mHelper == null) {
            showToast("数据库连接为空");
            return;
        }
        // 执行数据库帮助器的查询操作
        ArrayList<UserInfo> userArray = mHelper.query("1=1");
        String desc = String.format("数据库查询到%d条记录，详情如下：", userArray.size());
        for (int i = 0; i < userArray.size(); i++) {
            UserInfo info = userArray.get(i);
            desc = String.format("%s\n第%d条记录信息如下：", desc, i + 1);
            desc = String.format("%s\n　姓名为%s", desc, info.name);
            desc = String.format("%s\n　年龄为%d", desc, info.age);
            desc = String.format("%s\n　身高为%d", desc, info.height);
            desc = String.format("%s\n　体重为%f", desc, info.weight);
            desc = String.format("%s\n　婚否为%b", desc, info.married);
            desc = String.format("%s\n　更新时间为%s", desc, info.update_time);
        }
        if (userArray.size() <= 0) {
            desc = "数据库查询到的记录为空";
        }
        tv_sqlite.setText(desc);
    }

    private void showToast(String desc) {
        Toast.makeText(getActivity(), desc, Toast.LENGTH_SHORT).show();
    }
}
