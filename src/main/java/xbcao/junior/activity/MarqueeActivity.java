package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.MarqueeFragment;

public class MarqueeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MarqueeFragment.newInstance();
    }

}
