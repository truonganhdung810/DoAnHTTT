package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Message;

import java.util.ArrayList;


/**
 * Created by truon_000 on 11/28/2015.
 */
public class AdapterListMessageReceiver extends BaseAdapter {

    private ArrayList<Message> arrayMessageReceiver;
    private Context context;


    public AdapterListMessageReceiver(Context context, ArrayList<Message> arrayMessageReceiver) {

        this.context = context;
        this.arrayMessageReceiver = arrayMessageReceiver;

    }

    @Override
    public int getCount() {
        return arrayMessageReceiver.size();
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

        Message item = ProjectManagement.listMessage.get(position);
        TextView tvSenderName = (TextView) convertView.findViewById(R.id.tvSenderInboxItem);
        TextView tvNameJobMessage = (TextView) convertView.findViewById(R.id.tvContentInboxItem);
        TextView tvTimeMessage =(TextView) convertView.findViewById(R.id.tvTimeMessageInboxItem);

        tvSenderName.setText(item.name);

        item.id = Integer.parseInt(item.job_info.split(";;;")[0]);
        String name_job = item.job_info.split(";;;")[1];

        tvNameJobMessage.setText(name_job);
        tvTimeMessage.setText(item.date);


        return convertView;
    }
}
