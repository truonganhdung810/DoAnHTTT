package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;

import java.util.ArrayList;

/**
 * Created by truon_000 on 1/3/2016.
 */
public class AdapterListFriendsMultichoise extends BaseAdapter {

    private Context context;
    private ArrayList<FriendItem> arrayFriends;

    public AdapterListFriendsMultichoise(Context context, ArrayList<FriendItem> arrayFriends) {

        this.context = context;
        this.arrayFriends = arrayFriends;

    }

    @Override
    public int getCount() {
        return arrayFriends.size();
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

        convertView = LayoutInflater.from(context).inflate(R.layout.item_friend_multi_choise, parent, false);
        TextView tvNameFriend = (TextView) convertView.findViewById(R.id.tvNameFriendItemChoose);
        tvNameFriend.setText(arrayFriends.get(position).name);
        return convertView;
    }
}
