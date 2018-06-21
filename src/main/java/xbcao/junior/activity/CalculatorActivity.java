package xbcao.junior.activity;

import android.support.v4.app.Fragment;

import xbcao.junior.fragment.CalculatorFragment;

public class CalculatorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CalculatorFragment.newInstance();
    }

}
