package com.jb.androidframe.app;

import android.app.Application;

import com.jb.androidframe.app.constant.AppConstant;
import com.jb.androidframe.tools.L;

/**
 *
 * Created by Jianbin on 2015/12/24.
 */
public class JBApplication extends Application {

    private static JBApplication sApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        L.setLogOpen(AppConstant.LOG_OPEN);
//        if (!AppConstant.DEBUG) {
        CrashHandler.getsInstance().init(this);
//        }
    }

    public static JBApplication getInstance() {
        return sApplication;
    }
}
