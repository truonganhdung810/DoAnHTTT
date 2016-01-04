package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter.AdapterEnterpriseListJobs;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class GetAllEnterpriseJobs extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;
    ListView listEnterprseJob;

    public GetAllEnterpriseJobs(Context context, ListView listEnterpriseJob) {
        this.context = context;
        this.listEnterprseJob = listEnterpriseJob;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        if (result) {
            Log.d("Result", json);
            Type jobs = new TypeToken<ArrayList<Job>>() {
            }.getType();
            ProjectManagement.alljobs = (new Gson()).fromJson(json, jobs);
            Log.d("Result", ProjectManagement.alljobs.size() + "");

            AdapterEnterpriseListJobs adapterEnterpriseListJobs = new AdapterEnterpriseListJobs(context, ProjectManagement.alljobs);
            listEnterprseJob.setAdapter(adapterEnterpriseListJobs);

            for (Job job : ProjectManagement.alljobs) {
                //   Log.d("Result", job.description);
                //  Log.d("Result", job.name_enterprise);
            }

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {

        String email = ProjectManagement.enterprise.email;

        try {
            String[] keys = new String[]{"email"};
            String[] values = new String[]{email};
            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_enterprise_job.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
