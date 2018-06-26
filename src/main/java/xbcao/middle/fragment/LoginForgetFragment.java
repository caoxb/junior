package xbcao.middle.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import xbcao.junior.R;

public class LoginForgetFragment extends Fragment implements View.OnClickListener {

    public static LoginForgetFragment newInstance(){
        return new LoginForgetFragment();
    }
    public LoginForgetFragment() {
        // Required empty public constructor
    }

    private EditText et_password_first; // 声明一个编辑框对象
    private EditText et_password_second; // 声明一个编辑框对象
    private EditText et_verifycode; // 声明一个编辑框对象
    private String mVerifyCode; // 验证码
    private String mPhone; // 手机号码

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_forget, container, false);
        // 从布局文件中获取名叫et_password_first的编辑框
        et_password_first = view.findViewById(R.id.et_password_first);
        // 从布局文件中获取名叫et_password_second的编辑框
        et_password_second = view.findViewById(R.id.et_password_second);
        // 从布局文件中获取名叫et_verifycode的编辑框
        et_verifycode = view.findViewById(R.id.et_verifycode);
        view.findViewById(R.id.btn_verifycode).setOnClickListener(this);
        view.findViewById(R.id.btn_confirm).setOnClickListener(this);
        // 从前一个页面获取要修改密码的手机号码
        mPhone = getActivity().getIntent().getStringExtra("phone");
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verifycode) { // 点击了“获取验证码”按钮
            if (mPhone == null || mPhone.length() < 11) {
                Toast.makeText(getActivity(), "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            // 生成六位随机数字的验证码
            mVerifyCode = String.format("%06d", (int) (Math.random() * 1000000 % 1000000));
            // 弹出提醒对话框，提示用户六位验证码数字
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("请记住验证码");
            builder.setMessage("手机号" + mPhone + "，本次验证码是" + mVerifyCode + "，请输入验证码");
            builder.setPositiveButton("好的", null);
            AlertDialog alert = builder.create();
            alert.show();
        } else if (v.getId() == R.id.btn_confirm) { // 点击了“确定”按钮
            String password_first = et_password_first.getText().toString();
            String password_second = et_password_second.getText().toString();
            if (password_first.length() < 6 || password_second.length() < 6) {
                Toast.makeText(getActivity(), "请输入正确的新密码", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password_first.equals(password_second)) {
                Toast.makeText(getActivity(), "两次输入的新密码不一致", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!et_verifycode.getText().toString().equals(mVerifyCode)) {
                Toast.makeText(getActivity(), "请输入正确的验证码", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "密码修改成功", Toast.LENGTH_SHORT).show();
                // 把修改好的新密码返回给前一个页面
                Intent intent = new Intent();
                intent.putExtra("new_password", password_first);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        }
    }
}
