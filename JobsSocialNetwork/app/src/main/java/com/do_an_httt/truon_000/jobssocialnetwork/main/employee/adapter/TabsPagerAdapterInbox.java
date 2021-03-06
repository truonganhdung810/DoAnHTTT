package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityEmployeeMessageDetail;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityJobDetail;
import com.do_an_httt.truon_000.jobssocialnetwork.types.MessageReceiverItem;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class TabsPagerAdapterInbox extends PagerAdapter {

    private Context context;

    // layout message receiver
    private ListView lvMessageInboxReceiver;
    private AdapterListMessageReceiver adapterMessageReciver;

    public TabsPagerAdapterInbox(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
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
                view = LayoutInflater.from(context).inflate(R.layout.inbox_tab2_sent, container, false);
                break;
        }
        if (view != null) container.addView(view);

        return view;
    }

    private void initLayoutInboxReceiver(View view) {

        lvMessageInboxReceiver = (ListView) view.findViewById(R.id.lvMessageInboxTab1Receiver);
        adapterMessageReciver = new AdapterListMessageReceiver(context, ProjectManagement.listMessage);
        lvMessageInboxReceiver.setAdapter(adapterMessageReciver);

        lvMessageInboxReceiver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentToMessageDetail = new Intent(context, ActivityJobDetail.class);
                context.startActivity(intentToMessageDetail);


            }
        });

    }

}
