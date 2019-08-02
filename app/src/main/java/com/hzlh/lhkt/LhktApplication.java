package com.hzlh.lhkt;

import android.app.Application;
import android.content.Context;


/**
 * Created by gxz
 */
public class LhktApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

}
