package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.ClickFragment;

public class ClickActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ClickFragment.newInstance();
    }

}
