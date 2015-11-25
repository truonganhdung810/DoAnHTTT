package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/20/2015.
 */
public class JobsRecentAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<JobItem> listJobs;

    public JobsRecentAdapter(Context context, ArrayList<JobItem> listJobs) {

        this.context = context;
        this.listJobs = listJobs;

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return listJobs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_job, parent, false);


        return convertView;
    }
}
