package com.example.xyl.draganddraw;

import android.app.Fragment;

public class DragAndDrawActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return DragAndDrawFragment.newInstance();
    }

}
