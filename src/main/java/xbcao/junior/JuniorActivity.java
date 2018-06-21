package xbcao.junior;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.junior.fragment.JuniorFragment;

public class JuniorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return JuniorFragment.newInstance();
    }
}
