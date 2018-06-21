package xbcao.junior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.fragment.ColorFragment;

public class ColorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ColorFragment.newInstance();
    }

}
