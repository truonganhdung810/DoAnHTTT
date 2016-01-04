package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllFriendAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter.AdapterListFriends;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;

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
        new GetAllFriendAsyntask(false, this, lvListFriend).execute(ProjectManagement.employee.email);

    }

    private void initLayout() {
        lvListFriend = (ListView) findViewById(R.id.lvListFriend);
        lvListFriend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentFriend = new Intent(ActivityEmployeeListFriends.this, ActivityEmployeePersonalPage.class);
                intentFriend.putExtra("isMine", false);
                startActivity(intentFriend);
            }
        });
    }

}
