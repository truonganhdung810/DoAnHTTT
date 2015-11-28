package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter.TabPagerAdapterEmployeeUpdate;
import com.do_an_httt.truon_000.jobssocialnetwork.view.SlidingTabLayoutEmployeeUpdate;

public class ActivityEmployeeUpdateInformation extends Activity {

    private ViewPager pagerEmployeeUpdateInfor;
    private SlidingTabLayoutEmployeeUpdate slidingTabLayout;
    private TabPagerAdapterEmployeeUpdate tabsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_update_information);

        initPagerEmployeeUpdate();

    }

    private void initPagerEmployeeUpdate() {
        // Configure Tabs and View Pager 
        pagerEmployeeUpdateInfor = (ViewPager) findViewById(R.id.pagerEmployeeUpdateInfor);
        slidingTabLayout = (SlidingTabLayoutEmployeeUpdate) findViewById(R.id.slidingTabLayoutEmployeeUpdateInfor);
        tabsPagerAdapter = new TabPagerAdapterEmployeeUpdate(this);
        pagerEmployeeUpdateInfor.setAdapter(tabsPagerAdapter);

        slidingTabLayout.setViewPager(pagerEmployeeUpdateInfor);


    }
}
