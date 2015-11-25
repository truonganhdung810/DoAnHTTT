package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class AdapterListFriends extends BaseAdapter {

    private Context context;
    private ArrayList<FriendItem> arrayFriends;

    public AdapterListFriends(Context context, ArrayList<FriendItem> arrayFriends) {

        this.context = context;
        this.arrayFriends = arrayFriends;

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return arrayFriends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.employee_item_friend, parent, false);
        return convertView;
    }
}
