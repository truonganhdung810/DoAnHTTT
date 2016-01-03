package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllJobsAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter.TabsPagerAdapterMainViewListJobs;
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

    private TextView tvTopMenuEMployeeMain;
    private ImageView imgvMainViewOpenMenu;
    private DrawerLayout drlayoutMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_main_view);

        initLayout();
        initDrawerPersonal();
        initPagerListJobs();
        new GetAllJobsAsyntask(this).execute("");

    }

    private void initLayout() {

        tvTopMenuEMployeeMain = (TextView) findViewById(R.id.tvTopMenuEmployee);
        imgvMainViewOpenMenu = (ImageView) findViewById(R.id.imgvMainViewOpenMenu);
        drlayoutMainView = (DrawerLayout) findViewById(R.id.drlayoutMainView);
        //  tvTopMenuEMployeeMain.setText(ProjectManagement.employee.name);

        imgvMainViewOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drlayoutMainView.isDrawerOpen(GravityCompat.START)) {
                    drlayoutMainView.closeDrawer(GravityCompat.START);
                } else {
                    drlayoutMainView.openDrawer(GravityCompat.START);
                }
            }
        });
    }


    private void initPagerListJobs() {
        // Configure Tabs and View Pager
        pagerListJobs = (ViewPager) findViewById(R.id.pagerListJobs);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTabLayout);
        tabsPagerAdapterMainViewListJobs = new TabsPagerAdapterMainViewListJobs(this);
        pagerListJobs.setAdapter(tabsPagerAdapterMainViewListJobs);

        slidingTabLayout.setViewPager(pagerListJobs);


    }

    public void setTextTopMenuChangeToListJobs() {
        tvTopMenuEMployeeMain.setText("Danh sách công việc");
    }

    public void setTextTopMenuChangeToInbox() {
        tvTopMenuEMployeeMain.setText("Hộp thư đến");
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
