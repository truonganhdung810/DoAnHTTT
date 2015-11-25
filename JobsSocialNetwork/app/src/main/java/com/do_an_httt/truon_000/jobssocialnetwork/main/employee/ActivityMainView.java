package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllJobsAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.view.SlidingTabLayout;


public class ActivityMainView extends Activity {

    private ListView lvDrawerPersonal;
    private AdapterEmployeePersonal lvDrawerPersonalAdapter;

    private String[] listStringMenu = new String[]{"Timeline", "Cập nhật thông tin",
            "Công việc quan tâm", "Danh sách bạn bè", "Công ty theo dõi", "Hộp thư", "Đăng xuất"};

    // Tabs and view pager
    private ViewPager pagerListJobs;
    private SlidingTabLayout slidingTabLayout;
    private TabsPagerAdapterMainViewListJobs tabsPagerAdapterMainViewListJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.employee_main_view);
        initDrawerPersonal();
        initPagerListJobs();
        new GetAllJobsAsyntask(this).execute("");

    }


    private void initPagerListJobs() {
        // Configure Tabs and View Pager
        pagerListJobs = (ViewPager) findViewById(R.id.pagerListJobs);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTabLayout);
        tabsPagerAdapterMainViewListJobs = new TabsPagerAdapterMainViewListJobs(this);
        pagerListJobs.setAdapter(tabsPagerAdapterMainViewListJobs);

        slidingTabLayout.setViewPager(pagerListJobs);


    }


    private void initDrawerPersonal() {

        lvDrawerPersonal = (ListView) findViewById(R.id.lvSliderPersonal);
        lvDrawerPersonalAdapter = new AdapterEmployeePersonal(this, listStringMenu);
        lvDrawerPersonal.setAdapter(lvDrawerPersonalAdapter);

        lvDrawerPersonal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivityEmployeePersonalPage();
                        break;
                    case 1:
                        startActivityEmployeeUpdateInformation();
                        break;
                    case 2:

                        break;
                    case 3:
                        startActivityListFriend();
                        break;
                    case 4:
                        break;
                    case 5:
                        startActivityInbox();
                        break;
                    case 6:
                        break;
                }
            }
        });


    }

    private void startActivityEmployeeUpdateInformation() {
        Intent intentToEmployeeUpdate = new Intent(this, ActivityEmployeeUpdateInformation.class);
        startActivity(intentToEmployeeUpdate);
    }

    private void startActivityEmployeePersonalPage() {
        Intent intentToEmployeePersonalPage = new Intent(this, ActivityEmployeePersonalPage.class);
        intentToEmployeePersonalPage.putExtra("isMine", true);
        startActivity(intentToEmployeePersonalPage);
    }

    private void startActivityListFriend() {
        Intent intentToListFriend = new Intent(this, ActivityEmployeeListFriends.class);
        startActivity(intentToListFriend);
    }

    private void startActivityInbox() {
        Intent intentToInbox = new Intent(this, ActivityInbox.class);
        startActivity(intentToInbox);
    }

}