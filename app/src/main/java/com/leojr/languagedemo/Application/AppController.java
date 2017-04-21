package com.leojr.languagedemo.Application;

import android.app.Application;
import android.content.Context;

import com.leojr.languagedemo.Helper.LanguageHelper;


public class AppController extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LanguageHelper.onAttach(base,"en"));
    }
}
