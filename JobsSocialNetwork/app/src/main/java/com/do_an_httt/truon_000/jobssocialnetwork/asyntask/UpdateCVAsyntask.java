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
public class UpdateCVAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public UpdateCVAsyntask(Context context) {
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
            new CustomToast(context, "Cập nhật thành công", 1000);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];
        String name = params[1];
        String job = params[2];
        String phone = params[3];
        String address = params[4];
        String contact = params[5];
        String education = params[6];
        String experience = params[7];
        String skill = params[8];
        String other = params[9];

        try {
            String[] keys = new String[]{"email", "name", "job", "phone", "address",
                    "contact", "education", "experience", "skill", "other"};
            String[] values = new String[]{email, name, job, phone, address, contact,
                    education, experience, skill, other};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "cv_update.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
