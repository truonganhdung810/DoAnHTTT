package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityEmployeeCVPreview;
import com.do_an_httt.truon_000.jobssocialnetwork.types.CV;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class GetCVContentAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public GetCVContentAsyntask(Context context) {
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
            ProjectManagement.cvContent = (new Gson()).fromJson(json, CV.class);
            Intent intent = new Intent(context, ActivityEmployeeCVPreview.class);
            context.startActivity(intent);

        } else {
            //that bai;
            Log.d("Result", "That bai");
            new CustomToast(context, "Load cv that bai", 500);
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {

        String email = params[0];

        try {
            String[] keys = new String[]{"email"};
            String[] values = new String[]{email};
            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_cv.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
