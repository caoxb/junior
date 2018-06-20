package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.NineFragment;

public class NineActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return NineFragment.newInstance();
    }

}
