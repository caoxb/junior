package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.CaptureFragment;

public class CaptureActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CaptureFragment.newInstance();
    }

}
