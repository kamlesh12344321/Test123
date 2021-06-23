package com.ninestar.ninestartask.view;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ninestar.ninestartask.R;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract int getLayoutRes();
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        mToolbar = findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.findViewById(R.id.back_btn).setOnClickListener(v -> finish());
        }
    }
}
