package xbcao.middle.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.SwitchDefaultFragment;

public class SwitchDefaultActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return SwitchDefaultFragment.newInstance();
    }

}
