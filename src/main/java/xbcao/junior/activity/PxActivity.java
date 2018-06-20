package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.PxFragment;

public class PxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return PxFragment.newInstance();
    }

}
