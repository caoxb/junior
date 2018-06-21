package xbcao.middle.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.SwitchIOSFragment;

public class SwitchIOSActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return SwitchIOSFragment.newInstance();
    }
}
