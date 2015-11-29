package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class CreateNewJobAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public CreateNewJobAsyntask(Context context) {
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
            new CustomToast(context, "Tạo công việc mới thành công", 1000);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];
        String name = params[1];
        String date = params[2];
        String end_date = params[3];
        String description = params[4];
        String requirement = params[5];
        String domain = params[6];

        try {
            String[] keys = new String[]{"email", "name", "date", "end_date", "description",
                    "requirement", "domain"};
            String[] values = new String[]{email, name, date, end_date, description, requirement, domain};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "create_job.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
