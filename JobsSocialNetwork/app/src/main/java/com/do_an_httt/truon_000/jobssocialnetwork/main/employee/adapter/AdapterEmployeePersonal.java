package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

/**
 * Created by truon_000 on 11/19/2015.
 */
public class AdapterEmployeePersonal extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] listStringMenu;

    public AdapterEmployeePersonal(Context context, String[] array) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        listStringMenu = array;
    }

    @Override
    public int getCount() {
        return listStringMenu.length;
    }

    @Override
    public Object getItem(int position) {
        return listStringMenu[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (position == 0)
            convertView = inflater.inflate(R.layout.employee_drawer_item_timeline, parent, false);
        else {
            convertView = inflater.inflate(R.layout.employee_drawer_item_menu, parent, false);
            TextView tvItemMenu = (TextView) convertView.findViewById(R.id.tvItemMenu);
            tvItemMenu.setText(listStringMenu[position]);
        }

        return convertView;
    }
}
