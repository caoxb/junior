package xbcao.storage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.storage.fragment.TextReadFragment;

public class TextReadActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return TextReadFragment.newInstance();
    }

}
