package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class TabsPagerAdapterInbox extends PagerAdapter {

    private Context context;

    public TabsPagerAdapterInbox(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        switch (position) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.inbox_tab1_received, container, false);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.inbox_tab2_sent, container, false);
                break;
        }
        if (view != null) container.addView(view);

        return view;
    }
}
