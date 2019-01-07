package com.jb.androidframe.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jb.androidframe.app.constant.IntentConstant;

/**
 * BaseActivity
 * Created by Jianbin on 2015/12/7.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Bundle mBundle;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (null != intent) {
            mBundle = intent.getExtras();
            fetchIntent(intent, mBundle);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            mBundle = intent.getExtras();
            fetchIntent(intent, mBundle);
        }
    }

    protected void fetchIntent(Intent intent, @Nullable Bundle bundle) {

    }

    @Nullable
    protected Bundle getBundle() {
        return mBundle;
    }

    protected void toActivity(Class clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }

    protected void toActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
