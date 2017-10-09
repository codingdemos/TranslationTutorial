package com.codingdemos.translationtutorial;

import android.app.Application;
import android.content.Context;

/**
 * Created by abdalla on 10/1/17.
 */

public class Home extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
