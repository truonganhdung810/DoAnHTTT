package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Applier;

import java.util.ArrayList;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class AdapterJobApplier extends BaseAdapter {

    private Context context;
    private ArrayList<Applier> applierArrayList;

    public AdapterJobApplier(Context context, ArrayList<Applier> appliers) {

        this.context = context;
        this.applierArrayList = appliers;

    }

    @Override
    public int getCount() {
        return applierArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return applierArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Applier item = applierArrayList.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_employee_applier, parent, false);
        TextView tvNameApplier = (TextView) convertView.findViewById(R.id.tvNameApplier);
        TextView tvEmailApplier = (TextView) convertView.findViewById(R.id.tvEmailApplier);

        tvNameApplier.setText(item.name);
        tvEmailApplier.setText(item.email);
        
        return convertView;
    }
}
