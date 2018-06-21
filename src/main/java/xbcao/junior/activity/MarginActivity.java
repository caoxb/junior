package xbcao.junior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.fragment.MarginFragment;

public class MarginActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MarginFragment.newInstance();
    }
}
