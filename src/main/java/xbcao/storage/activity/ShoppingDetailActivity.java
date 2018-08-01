package xbcao.storage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.storage.fragment.ShoppingDetailFragment;

public class ShoppingDetailActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ShoppingDetailFragment.newInstance();
    }

}
