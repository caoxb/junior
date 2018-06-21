package xbcao.middle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.MiddleFragment;

public class MiddleActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MiddleFragment.newInstance();
    }
}
