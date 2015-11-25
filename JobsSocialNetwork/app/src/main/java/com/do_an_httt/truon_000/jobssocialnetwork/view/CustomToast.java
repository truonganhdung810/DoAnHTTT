package com.do_an_httt.truon_000.jobssocialnetwork.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by truon_000 on 9/23/2015.
 */
public class CustomToast {

    public CustomToast(Context context, String title, long time) {
        final Toast toast = Toast.makeText(context, title, Toast.LENGTH_LONG);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, time);
    }
}

