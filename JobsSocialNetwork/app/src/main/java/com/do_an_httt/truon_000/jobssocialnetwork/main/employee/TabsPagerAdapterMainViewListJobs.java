package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/19/2015.
 */

public class TabsPagerAdapterMainViewListJobs extends PagerAdapter {

    private Context context;

    public TabsPagerAdapterMainViewListJobs(Context context) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Item " + (position + 1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;

        switch (position) {

            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab1(view);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab2(view);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab3(view);
                break;


        }


        if (view != null) container.addView(view);
        return view;
    }

    private void initTab1(View v) {
        ListView listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);
        JobsRecentAdapter jobRecentAdapter = new JobsRecentAdapter(context, new ArrayList<JobItem>());
        listJobsRecent.setAdapter(jobRecentAdapter);

        listJobsRecent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentToJobDetail = new Intent(context, ActivityJobDetail.class);
                context.startActivity(intentToJobDetail);
            }
        });

    }

    private void initTab2(View v) {
        ListView listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);
        JobsRecentAdapter jobRecentAdapter = new JobsRecentAdapter(context, new ArrayList<JobItem>());
        listJobsRecent.setAdapter(jobRecentAdapter);
    }

    private void initTab3(View v) {
        ListView listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);
        JobsRecentAdapter jobRecentAdapter = new JobsRecentAdapter(context, new ArrayList<JobItem>());
        listJobsRecent.setAdapter(jobRecentAdapter);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
