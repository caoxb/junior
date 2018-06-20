package xbcao.junior.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xbcao.junior.R;

public class ScaleFragment extends Fragment implements View.OnClickListener{

    public static ScaleFragment newInstance(){
        return new ScaleFragment();
    }
    public ScaleFragment() {
        // Required empty public constructor
    }
    private ImageView iv_scale; // 声明一个图像视图的对象
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scale, container, false);
        // 从布局文件中获取名叫iv_scale的图像视图
        iv_scale = view.findViewById(R.id.iv_scale);
        // 下面通过七个按钮，分别演示不同拉伸类型的图片拉伸效果
        view.findViewById(R.id.btn_center).setOnClickListener(this);
        view.findViewById(R.id.btn_fitCenter).setOnClickListener(this);
        view.findViewById(R.id.btn_centerCrop).setOnClickListener(this);
        view.findViewById(R.id.btn_centerInside).setOnClickListener(this);
        view.findViewById(R.id.btn_fitXY).setOnClickListener(this);
        view.findViewById(R.id.btn_fitStart).setOnClickListener(this);
        view.findViewById(R.id.btn_fitEnd).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_center) {
            // 将拉伸类型设置为“按照原尺寸居中显示”
            iv_scale.setScaleType(ImageView.ScaleType.CENTER);
        } else if (v.getId() == R.id.btn_fitCenter) {
            // 将拉伸类型设置为“保持宽高比例，拉伸图片使其位于视图中间”
            iv_scale.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (v.getId() == R.id.btn_centerCrop) {
            // 将拉伸类型设置为“拉伸图片使其充满视图，并位于视图中间”
            iv_scale.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (v.getId() == R.id.btn_centerInside) {
            // 将拉伸类型设置为“保持宽高比例，缩小图片使之位于视图中间（只缩小不放大）”
            iv_scale.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else if (v.getId() == R.id.btn_fitXY) {
            // 将拉伸类型设置为“拉伸图片使其正好填满视图（图片可能被拉伸变形）”
            iv_scale.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (v.getId() == R.id.btn_fitStart) {
            // 将拉伸类型设置为“保持宽高比例，拉伸图片使其位于视图上方或左侧”
            iv_scale.setScaleType(ImageView.ScaleType.FIT_START);
        } else if (v.getId() == R.id.btn_fitEnd) {
            // 将拉伸类型设置为“保持宽高比例，拉伸图片使其位于视图下方或右侧”
            iv_scale.setScaleType(ImageView.ScaleType.FIT_END);
        }
    }
}
