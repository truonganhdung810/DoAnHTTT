package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;

import java.util.ArrayList;

public class EnterpriseMain extends Activity {

    private ListView lvEnterpriseJobs;
    private AdapterEnterpriseListJobs adapterEnterpriseListJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_main);

        initListView();
    }

    private void initListView() {

        lvEnterpriseJobs = (ListView) findViewById(R.id.lvEnterpriseListJob);
        adapterEnterpriseListJobs = new AdapterEnterpriseListJobs(this, new ArrayList<Job>());
        lvEnterpriseJobs.setAdapter(adapterEnterpriseListJobs);

    }
}
