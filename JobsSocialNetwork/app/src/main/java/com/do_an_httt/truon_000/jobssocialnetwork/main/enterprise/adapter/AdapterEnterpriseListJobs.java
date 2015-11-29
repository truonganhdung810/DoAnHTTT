package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 3;
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

        convertView = LayoutInflater.from(context).inflate(R.layout.item_job_of_enterprise, parent, false);

        return convertView;
    }
}
