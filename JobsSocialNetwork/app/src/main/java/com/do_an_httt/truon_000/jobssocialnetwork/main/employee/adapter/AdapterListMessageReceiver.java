package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.MessageReceiverItem;

import java.util.ArrayList;


/**
 * Created by truon_000 on 11/28/2015.
 */
public class AdapterListMessageReceiver extends BaseAdapter {

    private ArrayList<MessageReceiverItem> arrayMessageReceiver;
    private Context context;


    public AdapterListMessageReceiver(Context context, ArrayList<MessageReceiverItem> arrayMessageReceiver) {

        this.context = context;
        this.arrayMessageReceiver = arrayMessageReceiver;

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return arrayMessageReceiver.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.inbox_tab1_item_message, parent, false);
        return convertView;
    }
}
