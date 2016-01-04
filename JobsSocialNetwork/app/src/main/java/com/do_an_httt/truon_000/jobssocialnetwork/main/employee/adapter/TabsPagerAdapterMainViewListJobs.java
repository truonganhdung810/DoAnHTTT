package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityEmployeeMessageDetail;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityJobDetail;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/19/2015.
 */

public class TabsPagerAdapterMainViewListJobs extends PagerAdapter {

    private Context context;
    public ListView listJobsRecent;
    public JobsRecentAdapter jobRecentAdapter;

    public TabsPagerAdapterMainViewListJobs(Context context) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return 4;
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
                view = LayoutInflater.from(context).inflate(R.layout.inbox_tab1_received, container, false);
                initLayoutInboxReceiver(view);
                break;

            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab1(view);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab2(view);
                break;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.employee_listjobs_tab1, container, false);
                initTab3(view);
                break;


        }


        if (view != null) container.addView(view);
        return view;
    }


    private void initLayoutInboxReceiver(View view) {

        ListView lvMessageInboxReceiver = (ListView) view.findViewById(R.id.lvMessageInboxTab1Receiver);
        AdapterListMessageReceiver adapterMessageReciver = new AdapterListMessageReceiver(context, new ProjectManagement().listMessage);
        lvMessageInboxReceiver.setAdapter(adapterMessageReciver);

        lvMessageInboxReceiver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentToMessageDetail = new Intent(context, ActivityJobDetail.class);
                intentToMessageDetail.putExtra("job_id", ProjectManagement.listMessage.get(position).id);
                context.startActivity(intentToMessageDetail);

            }
        });


    }

    public void initTab1(View v) {
        listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);

    }

    public void setJobToListView(ArrayList<Job> listAllJobs) {
        jobRecentAdapter = new JobsRecentAdapter(context, listAllJobs);
        listJobsRecent.setAdapter(jobRecentAdapter);

        listJobsRecent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentToJobDetail = new Intent(context, ActivityJobDetail.class);
                intentToJobDetail.putExtra("job_id", ProjectManagement.alljobs.get(position).id);
                new CustomToast(context, "Before " + ProjectManagement.alljobs.get(position).id + "", 500);
                context.startActivity(intentToJobDetail);
            }
        });
    }

    private void initTab2(View v) {
        ListView listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);
        JobsRecentAdapter jobRecentAdapter = new JobsRecentAdapter(context, new ArrayList<Job>());
        listJobsRecent.setAdapter(jobRecentAdapter);
    }

    private void initTab3(View v) {
        ListView listJobsRecent = (ListView) v.findViewById(R.id.lvJobsRecent);
        JobsRecentAdapter jobRecentAdapter = new JobsRecentAdapter(context, new ArrayList<Job>());
        listJobsRecent.setAdapter(jobRecentAdapter);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

}
