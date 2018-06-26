package xbcao.junior.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import xbcao.junior.R;
import xbcao.utils.DateUtil;

public class CaptureFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener{

    public static CaptureFragment newInstance(){
        return new CaptureFragment();
    }
    public CaptureFragment() {
        // Required empty public constructor
    }
    private TextView tv_capture; // 声明一个文本视图对象
    private ImageView iv_capture; // 声明一个图像视图对象

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_capture, container, false);
        // 从布局文件中获取名叫tv_capture的文本视图
        tv_capture = view.findViewById(R.id.tv_capture);
        // 从布局文件中获取名叫iv_capture的图像视图
        iv_capture = view.findViewById(R.id.iv_capture);
        // 开启文本视图tv_capture的绘图缓存
        tv_capture.setDrawingCacheEnabled(true);
        // 从布局文件中获取名叫btn_chat的按钮
        Button btn_chat = view.findViewById(R.id.btn_chat);
        // 从布局文件中获取名叫btn_capture的按钮
        Button btn_capture = view.findViewById(R.id.btn_capture);
        // 给btn_chat设置点击监听器
        btn_chat.setOnClickListener(this);
        // 给btn_chat设置长按监听器
        btn_chat.setOnLongClickListener(this);
        // 给btn_capture设置点击监听器
        btn_capture.setOnClickListener(this);
        return view;
    }
    private String[] mChatStr = {"你吃饭了吗？", "今天天气真好呀。", "我中奖啦！", "我们去看电影吧。", "晚上干什么好呢？"};
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_chat) { // 点击了聊天按钮，则给文本视图添加聊天文字
            int random = (int) (Math.random() * 10) % 5;
            // 下面的DateUtil参见本书附录源码中的DateUtil.java
            String newStr = String.format("%s\n%s %s", tv_capture.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            tv_capture.setText(newStr);
        } else if (v.getId() == R.id.btn_capture) { // 点击了截图按钮，则将截图信息显示在图像视图上
            // 从文本视图tv_capture的绘图缓存中获取位图对象
            Bitmap bitmap = tv_capture.getDrawingCache();
            // 给图像视图iv_capture设置位图对象
            iv_capture.setImageBitmap(bitmap);
            // 注意这里在截图完毕后不能马上关闭绘图缓存，因为画面渲染需要时间，
            // 如果立即关闭缓存，渲染画面就会找不到位图对象，会报错：
            // “java.lang.IllegalArgumentException: Cannot draw recycled bitmaps”。
            // 所以要等界面渲染完成后再关闭绘图缓存，下面的做法是延迟200毫秒再关闭
            mHandler.postDelayed(mResetCache, 200);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        // 长按了按钮btn_chat，则清空文本视图tv_capture
        if (v.getId() == R.id.btn_chat) {
            tv_capture.setText("");
        }
        return true;
    }

    private Handler mHandler = new Handler(); // 声明一个任务处理器
    private Runnable mResetCache = new Runnable() {
        @Override
        public void run() {
            // 关闭文本视图tv_capture的绘图缓存
            tv_capture.setDrawingCacheEnabled(false);
            // 开启文本视图tv_capture的绘图缓存
            tv_capture.setDrawingCacheEnabled(true);
        }
    };
}
