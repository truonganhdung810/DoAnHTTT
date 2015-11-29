package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class AdapterListFriends extends BaseAdapter {

    private Context context;
    private ArrayList<FriendItem> arrayFriends;

    public AdapterListFriends(Context context, ArrayList<FriendItem> arrayFriends) {

        this.context = context;
        this.arrayFriends = ProjectManagement.allfriends;

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
        TextView tvNameFriend = (TextView) convertView.findViewById(R.id.tvNameListFriends);
        TextView tvEmailFriend = (TextView) convertView.findViewById(R.id.tvEmailListFriend);
        ImageView imgvAcceptFriend = (ImageView) convertView.findViewById(R.id.imgvAcceptFriend);

        FriendItem friend = arrayFriends.get(position);
        if (friend.name.equals("null")) tvNameFriend.setText("Chưa cập nhật");
        else tvNameFriend.setText(friend.name);
        tvEmailFriend.setText(friend.email);
        if (friend.status == 0) imgvAcceptFriend.setVisibility(View.VISIBLE);
        else imgvAcceptFriend.setVisibility(View.GONE);

        return convertView;
    }
}
