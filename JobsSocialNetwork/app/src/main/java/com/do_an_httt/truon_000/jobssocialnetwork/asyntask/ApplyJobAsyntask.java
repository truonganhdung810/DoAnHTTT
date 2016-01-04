package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class ApplyJobAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public ApplyJobAsyntask(Context context) {
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
            new CustomToast(context, "Apply thành công", 1000);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];
        String id = params[1];
        String name_job = params[2];
        String enterprise = params[3];
        String name = params[4];

        try {
            String[] keys = new String[]{"email", "id_job", "name_job", "enterprise", "name"};
            String[] values = new String[]{email, id, name_job, enterprise, name};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "apply_job.php", keys, values);
            Log.d("Result", json);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
