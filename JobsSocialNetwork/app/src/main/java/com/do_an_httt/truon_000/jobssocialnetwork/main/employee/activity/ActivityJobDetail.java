package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.main.ActivitySendMessage;

public class ActivityJobDetail extends Activity {

    private Button btMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail);

        initLayout();
    }

    private void initLayout() {

        btMessage = (Button) findViewById(R.id.bt_jobdetail_message_to_enterprise);
        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityJobDetail.this, ActivitySendMessage.class);
                startActivity(intent);
            }
        });

    }
}
