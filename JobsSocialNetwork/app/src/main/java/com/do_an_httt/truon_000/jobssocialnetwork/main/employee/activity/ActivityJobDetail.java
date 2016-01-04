package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.ApplyJobAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllFriendAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetJobContentAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.ShareJobToFriends;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

public class ActivityJobDetail extends Activity {

    private Button btMessage, btShare, btApply, btAdd, btView, btFollow;
    private TextView tvDate, tvNameEnterprise, tvEmailEnterprise, tvNameJob, tvNameEnterpriseInJob, tvJobContent;
    private Boolean[] listChecked;
    private ListView lvFriendsChoose;
    private Button btSubmitShare;
    private int job_id;
    private Job jobContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail);

        Intent intent = getIntent();
        job_id = intent.getIntExtra("job_id", 0);
        new CustomToast(this, "After " + job_id + "", 500);
        if (job_id != 0) {
            new GetJobContentAsyntask(this).execute(job_id + "");
        }
    }

    public void initLayout() {

        btMessage = (Button) findViewById(R.id.bt_jobdetail_message_to_enterprise);
        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btShare = (Button) findViewById(R.id.bt_jobdetal_share);
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogListFriend();
            }
        });

        btApply = (Button) findViewById(R.id.bt_jobdetail_apply);
        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyToJob();
            }
        });

        tvNameEnterprise = (TextView) findViewById(R.id.tv_jobdetail_enterprise);
        tvDate = (TextView) findViewById(R.id.tv_jobdetail_time);
        tvEmailEnterprise = (TextView) findViewById(R.id.tv_jobdetail_email_enterprise);
        tvNameJob = (TextView) findViewById(R.id.tv_jobdetail_jobname);
        tvNameEnterpriseInJob = (TextView) findViewById(R.id.tv_jobdetail_enterprise_fullname);
        tvJobContent = (TextView) findViewById(R.id.tv_jobdtail_main_content);


    }

    public void setContentToLayout(Job jobContent) {
        // gan noi dung cua job vao layout
        tvNameEnterprise.setText(jobContent.name_enterprise);
        tvNameEnterpriseInJob.setText(jobContent.name_enterprise);
        tvNameJob.setText(jobContent.name);
        tvEmailEnterprise.setText(jobContent.email);
        tvDate.setText(jobContent.date);

        String job_description = "Mô tả: " + jobContent.description + "<br><br>" + "Yêu cầu: " + jobContent.requirement
                + "<br><br>" + "Ngày kết thúc: " + jobContent.end_date + "<br>";
        tvJobContent.setText(Html.fromHtml(job_description));
    }

    private void showDialogListFriend() {

        final Dialog choiseFriendDialog = new Dialog(this);
        choiseFriendDialog.setTitle("Share for your friends");
        choiseFriendDialog.setContentView(R.layout.list_friends_multi_choise);

        lvFriendsChoose = (ListView) choiseFriendDialog.findViewById(R.id.lv_friend_multi_choise);
        new GetAllFriendAsyntask(choiseFriendDialog, true, this, lvFriendsChoose).execute(ProjectManagement.employee.email);
        btSubmitShare = (Button) choiseFriendDialog.findViewById(R.id.btSubmitShare);
        btSubmitShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitShareForFriends();
                choiseFriendDialog.dismiss();
            }
        });

    }

    private void submitShareForFriends() {
        SparseBooleanArray checked = lvFriendsChoose.getCheckedItemPositions();
        int count = checked.size();
        String listEmailFriends = "";
        for (int i = 0; i < checked.size(); i++) {
            listEmailFriends += ProjectManagement.allfriends.get(checked.keyAt(i)).email + ";;;";

        }
        if (count > 0) {
            String job_infor = job_id + ";;;" + ProjectManagement.jobDetail.name;
            new ShareJobToFriends(this).execute(ProjectManagement.employee.email, ProjectManagement.employee.name, listEmailFriends, job_infor);
        } else {
             new CustomToast(this, "Bạn chưa chọn bạn bè nào", 1000);
        }
    }

    private void applyToJob() {
        String email = ProjectManagement.employee.email;
        String idJob = job_id + "";
        String name_job = ProjectManagement.jobDetail.name;
        String enterprise = ProjectManagement.jobDetail.email;
        String name = ProjectManagement.employee.name;
        new ApplyJobAsyntask(this).execute(email, idJob, name_job, enterprise, name);
    }
}
