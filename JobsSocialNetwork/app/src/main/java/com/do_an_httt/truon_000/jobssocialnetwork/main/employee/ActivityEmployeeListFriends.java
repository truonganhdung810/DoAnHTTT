package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

import java.util.ArrayList;

public class ActivityEmployeeListFriends extends Activity {

    private ListView lvListFriend;
    private ArrayList<FriendItem> arrayFriend = new ArrayList<FriendItem>();
    private AdapterListFriends adapterListFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list_friends);

        initLayout();

    }

    private void initLayout() {
        lvListFriend = (ListView) findViewById(R.id.lvListFriend);
        adapterListFriends = new AdapterListFriends(this, arrayFriend);
        lvListFriend.setAdapter(adapterListFriends);

        lvListFriend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intentFriend = new Intent(ActivityEmployeeListFriends.this, ActivityEmployeePersonalPage.class);
                intentFriend.putExtra("isMine", false);
                startActivity(intentFriend);
            }
        });
    }

}