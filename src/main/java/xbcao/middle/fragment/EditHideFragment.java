package xbcao.middle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import xbcao.junior.R;
import xbcao.middle.activity.EditHideActivity;
import xbcao.utils.ViewUtil;

public class EditHideFragment extends Fragment implements View.OnClickListener {
    private EditText et_other; // 声明一个编辑框对象
    public static EditHideFragment newInstance(){
        return new EditHideFragment();
    }
    public EditHideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_hide, container, false);
        // 从布局文件中获取名叫ll_hide的线性布局
        LinearLayout ll_hide = view.findViewById(R.id.ll_hide);
        // 从布局文件中获取名叫et_phone的手机号码编辑框
        EditText et_phone = view.findViewById(R.id.et_phone);
        // 从布局文件中获取名叫et_password的密码编辑框
        EditText et_password = view.findViewById(R.id.et_password);
        // 从布局文件中获取名叫et_other的其它编辑框
        et_other = view.findViewById(R.id.et_other);
        ll_hide.setOnClickListener(this);
        // 给手机号码编辑框添加文本变化监听器
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone));
        // 给密码编辑框添加文本变化监听器
        et_password.addTextChangedListener(new HideTextWatcher(et_password));
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_hide) {
            // 实际上不只是et_other的软键盘会关闭，其它编辑框的软键盘也会关闭
            // 因为方法内部去获取视图的WindowToken，这个Token在每个页面上都是唯一的
            ViewUtil.hideOneInputMethod(getActivity(), et_other);
        }
    }

    // 定义一个编辑框监听器，在输入文本达到指定长度时自动隐藏输入法
    private class HideTextWatcher implements TextWatcher {
        private EditText mView; // 声明一个编辑框对象
        private int mMaxLength; // 声明一个最大长度变量
        private CharSequence mStr; // 声明一个文本串

        public HideTextWatcher(EditText v) {
            super();
            mView = v;
            // 通过反射机制获取编辑框的最大长度
            mMaxLength = ViewUtil.getMaxLength(v);
        }

        // 在编辑框的输入文本变化前触发
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        // 在编辑框的输入文本变化时触发
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mStr = s;
        }

        // 在编辑框的输入文本变化后触发
        public void afterTextChanged(Editable s) {
            if (mStr == null || mStr.length() == 0)
                return;
            // 输入文本达到11位（如手机号码）时关闭输入法
            if (mStr.length() == 11 && mMaxLength == 11) {
                ViewUtil.hideAllInputMethod(getActivity());
            }
            // 输入文本达到6位（如登录密码）时关闭输入法
            if (mStr.length() == 6 && mMaxLength == 6) {
                ViewUtil.hideOneInputMethod(getActivity(), mView);
            }
        }
    }
}
