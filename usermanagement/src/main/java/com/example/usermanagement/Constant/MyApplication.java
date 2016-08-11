package com.example.usermanagement.Constant;

import android.app.Application;

import org.xutils.x;

/**
 * Created by andfoot on 2016/8/10.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
    }
}
