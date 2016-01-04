package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllEmployeeApplyAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetCVContentAsyntask;

public class ActivityAppliers extends Activity {

    private ListView lvApplier;
    private int job_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliers);
        getJobId();
        initLayout();
    }

    private void getJobId() {
        job_id = getIntent().getIntExtra("job_id", 0);
    }

    private void initLayout() {
        lvApplier = (ListView) findViewById(R.id.lvAppliers);
        if (job_id != 0) new GetAllEmployeeApplyAsyntask(this, lvApplier).execute(job_id + "");
        lvApplier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String email = ProjectManagement.allApplier.get(position).email;
                new GetCVContentAsyntask(ActivityAppliers.this).execute(email);
            }
        });
    }

}
