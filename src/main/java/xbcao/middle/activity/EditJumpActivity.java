package xbcao.middle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.middle.fragment.EditJumpFragment;

public class EditJumpActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return EditJumpFragment.newInstance();
    }

}
