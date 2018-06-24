package xbcao.middle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.RadioVerticalFragment;

public class RadioVerticalActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return RadioVerticalFragment.newInstance();
    }

}
