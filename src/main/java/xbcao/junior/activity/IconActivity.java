package xbcao.junior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.fragment.IconFragment;

public class IconActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return IconFragment.newInstance();
    }

}
