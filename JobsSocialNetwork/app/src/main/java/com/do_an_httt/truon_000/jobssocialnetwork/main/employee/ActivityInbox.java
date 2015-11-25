package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.view.SlidingTabLayout;
import com.do_an_httt.truon_000.jobssocialnetwork.view.SlidingTabLayoutInbox;

public class ActivityInbox extends Activity {

    private SlidingTabLayoutInbox slidingTabLayoutInbox;
    private ViewPager viewPagerInboxTab;
    private TabsPagerAdapterInbox tabsPagerAdapterInbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        initPagerListJobs();

    }


    private void initPagerListJobs() {
        // Configure Tabs and View Pager
        viewPagerInboxTab = (ViewPager) findViewById(R.id.viewPagerInboxTab);
        slidingTabLayoutInbox = (SlidingTabLayoutInbox) findViewById(R.id.slidingTabLayoutInbox);
        tabsPagerAdapterInbox = new TabsPagerAdapterInbox(this);
        viewPagerInboxTab.setAdapter(tabsPagerAdapterInbox);

        slidingTabLayoutInbox.setViewPager(viewPagerInboxTab);


    }
}
