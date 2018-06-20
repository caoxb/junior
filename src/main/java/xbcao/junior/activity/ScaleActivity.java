package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.ScaleFragment;

public class ScaleActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ScaleFragment.newInstance();
    }

}
