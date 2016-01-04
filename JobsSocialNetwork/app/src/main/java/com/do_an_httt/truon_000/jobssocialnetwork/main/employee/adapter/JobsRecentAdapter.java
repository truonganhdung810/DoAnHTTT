package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/20/2015.
 */
public class JobsRecentAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Job> listJobs;

    public JobsRecentAdapter(Context context, ArrayList<Job> listJobs) {

        this.context = context;
        this.listJobs = listJobs;

    }

    @Override
    public int getCount() {
        return listJobs.size();
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

        Job item = listJobs.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_job, parent, false);
        TextView tvJobName = (TextView) convertView.findViewById(R.id.tvJobName);
        TextView tvJobEnterprise = (TextView) convertView.findViewById(R.id.tvEnterpriseName);
        TextView tvDateStart = (TextView) convertView.findViewById(R.id.tvDateJobCreated);

        tvJobName.setText(item.name);
        tvJobEnterprise.setText(item.name_enterprise);
        tvDateStart.setText(item.date);

        return convertView;
    }
}
