package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityJobDetail;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class GetJobContentAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public GetJobContentAsyntask(Context context) {
        this.context = context;
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
            ProjectManagement.jobDetail = (new Gson()).fromJson(json, Job.class);
            ((ActivityJobDetail) context).initLayout();
            ((ActivityJobDetail) context).setContentToLayout(ProjectManagement.jobDetail);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {

        String idString = params[0];

        try {
            String[] keys = new String[]{"id"};
            String[] values = new String[]{idString};
            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_job_by_id.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
