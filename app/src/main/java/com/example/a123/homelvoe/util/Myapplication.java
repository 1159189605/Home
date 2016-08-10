package com.example.a123.homelvoe.util;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 123 on 2016/8/9.
 */
public class Myapplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
