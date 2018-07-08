package xbcao.middle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import xbcao.junior.R;
import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.ActRotateFragment;

public class ActRotateActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ActRotateFragment.newInstance();
    }

    public ActRotateFragment getFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment!=null){
            return (ActRotateFragment)fragment;
        }else {
            return ActRotateFragment.newInstance();
        }
    }

    @Override
    protected void onStart() { // 开始活动页面
        getFragment().refreshLife("onStart");
        super.onStart();
    }

    @Override
    protected void onStop() { // 停止活动页面
        getFragment().refreshLife("onStop");
        super.onStop();
    }

    @Override
    protected void onResume() { // 恢复活动页面
        getFragment().refreshLife("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() { // 暂停活动页面
        getFragment().refreshLife("onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() { // 重启活动页面
        getFragment().refreshLife("onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() { // 销毁活动页面
        getFragment().refreshLife("onDestroy");
        super.onDestroy();
    }
}
