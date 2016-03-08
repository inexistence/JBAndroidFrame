package com.jb.androidframe.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.jb.androidframe.app.constant.IntentConstant;
import com.jb.androidframe.tools.L;

/**
 * BaseActivity
 * Created by Jianbin on 2015/12/7.
 */
public class BaseActivity extends AppCompatActivity {

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (null != intent) {
            fetchIntent(intent, intent.getBundleExtra(IntentConstant.INTENT_EXTRA_BUNDLE));
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void fetchIntent(Intent intent, Bundle bundle) {

    }

    protected void jumpToActivity(Class clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }

    protected void jumpToActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        intent.putExtra(IntentConstant.INTENT_EXTRA_BUNDLE, bundle);
        startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findView(int id) {
        return (T) super.findViewById(id);
    }
}
