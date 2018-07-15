package xbcao.storage;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xbcao.junior.R;
import xbcao.junior.activity.SingleFragmentActivity;
import xbcao.storage.fragment.StorageFragment;

public class StorageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return StorageFragment.newInstance();
    }

}
