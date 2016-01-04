package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/25/2015.
 */
public class AdapterEnterpriseListJobs extends BaseAdapter {

    private Context context;
    private ArrayList<Job> arrayJob;

    public AdapterEnterpriseListJobs(Context context, ArrayList<Job> arrayListJobs) {

        this.context = context;
        this.arrayJob = arrayListJobs;

    }

    @Override
    public int getCount() {
        return arrayJob.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayJob.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Job item = arrayJob.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_job_of_enterprise, parent, false);
        TextView tvNameJob = (TextView) convertView.findViewById(R.id.tvJobName);
        TextView tvEnterprise = (TextView) convertView.findViewById(R.id.tvEnterpriseName);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tvDateJobCreated);
        TextView tvNumberCV = (TextView) convertView.findViewById(R.id.tv_enterprise_job_number_employee);

        tvNameJob.setText(item.name);
        tvEnterprise.setText(ProjectManagement.enterprise.name);
        tvDate.setText(item.date);
        tvNumberCV.setText(item.number_cv + "");

        return convertView;
    }
}
