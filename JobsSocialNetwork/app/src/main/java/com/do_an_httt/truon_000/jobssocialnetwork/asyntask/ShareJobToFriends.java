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
public class ShareJobToFriends extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public ShareJobToFriends(Context context) {
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
            new CustomToast(context, "Chia sẻ thành công", 1000);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String sender = params[0];
        String name = params[1];
        String receiver = params[2];
        String job_infor = params[3];

        try {
            String[] keys = new String[]{"sender", "name", "receiver", "job_info"};
            String[] values = new String[]{sender, name, receiver, job_infor};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "share_job.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
