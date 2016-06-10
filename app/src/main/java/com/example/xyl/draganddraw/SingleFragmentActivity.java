package com.example.xyl.draganddraw;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by XyL on 2016/5/20.
 * 抽象类
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    public static Intent newIntent(Context context) {
        return new Intent(context, DragAndDrawActivity.class);
    }

    @LayoutRes
    private int getLayoutResId() {
        return R.layout.fragment_drag_and_draw;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
